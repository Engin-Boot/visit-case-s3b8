package visitcounter.receiver;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;

public class StatisticsCalculator {
	
	public static void calculateAverageFootfallsPerHourOverDay() throws IOException {
		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<LocalDate,Integer> countFootFallPerDay = getMapCountFootFallsForEveryDate(footFallRecords);
		CSVWriter writer = FootFallStatisticsCsvWriter.getWriter(Utility.getCsvOutputFilePathFromProperties("filename1"));
		
		String [] column_names = {"Date", "Average Foot Fall Per Hour"};
		
		FootFallStatisticsCsvWriter.writeColumnNamesToCsv(column_names, writer);
		
		countFootFallPerDay.forEach((k,v) -> {
			Double dailyFootfallPerHour = v.doubleValue()/24;
			String [] data = {k.toString(), dailyFootfallPerHour.toString()};
			FootFallStatisticsCsvWriter.writeRecordToCsv(data, writer);
		});
		
		FootFallStatisticsCsvWriter.executeFlush(writer);
	}
	
	public static void calculateDailyFootfallsOverWeek() throws IOException {
		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<String,Integer> countFootFallPerDayOfWeek = getMapCountFootFallsPerDayOfWeek(footFallRecords);
		Map<String,Integer> countNoOfOccurencesOfDaysOfWeek = getMapCountNoOfOccurencesOfDaysOfWeek(footFallRecords);

		CSVWriter writer = FootFallStatisticsCsvWriter.getWriter(Utility.getCsvOutputFilePathFromProperties("filename2"));
		
		String [] column_names = {"Day of Week", "Daily Foot Falls Over Week "};
		
		FootFallStatisticsCsvWriter.writeColumnNamesToCsv(column_names, writer);
		
		countFootFallPerDayOfWeek.forEach((k,v) -> {
			Double dailyFootfallPerDayOfWeek = v.doubleValue()/countNoOfOccurencesOfDaysOfWeek.get(k);
			String [] data = {k.toString(), dailyFootfallPerDayOfWeek.toString()};
			FootFallStatisticsCsvWriter.writeRecordToCsv(data, writer);
		});
		
		FootFallStatisticsCsvWriter.executeFlush(writer);
	}
		
	
	// Refractor to reduce cyclomatic complaxity of calculatePeakDailyFootfallsInParticularMonth
	public static String[] getPeakData(Map.Entry<LocalDate,Integer> record, int year, Integer peak_value, String peak_date) {
		if(record.getKey().getYear() == year) {
			if(record.getValue() > peak_value) {
				peak_value = record.getValue();
				peak_date = record.getKey().toString();
			}
		}
		String [] data = {peak_date, peak_value.toString()};
		return data;
	}
	
	public static void calculatePeakDailyFootfallsInParticularMonth(int month, int year) {
		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<LocalDate,Integer> countFootFallForEveryDate = getMapCountFootFallsForEveryDate(footFallRecords);
		
		CSVWriter writer = FootFallStatisticsCsvWriter.getWriter(Utility.getCsvOutputFilePathFromProperties("filename3"));
		
		String [] column_names = {"Date", "Peak FootFall for current month"};
		
		FootFallStatisticsCsvWriter.writeColumnNamesToCsv(column_names, writer);
		
		Integer peak_value = 0;
		String peak_date = "2020/01/01";
		System.out.println(peak_date +"HHHH");
		String [] data = null;
		for (Map.Entry<LocalDate,Integer> record : countFootFallForEveryDate.entrySet()) {
			if(record.getKey().getMonthValue() == month)
			{
				data = getPeakData(record, year, peak_value, peak_date);
				peak_value = Integer.parseInt(data[1]);
				peak_date = data[0];
			}
		}
		FootFallStatisticsCsvWriter.writeRecordToCsv(data, writer);
		FootFallStatisticsCsvWriter.executeFlush(writer);
		
		
	}
	
	
	private static Map<LocalDate,Integer> getMapCountFootFallsForEveryDate(List<FootFallModel> footFallRecords){
		Map<LocalDate,Integer> countFootFallForEveryDate = new LinkedHashMap<>();
		for(FootFallModel record: footFallRecords) {
			countFootFallForEveryDate.merge(record.getDate(), 1, Integer::sum);
		}
		return countFootFallForEveryDate;
		
	}
	
	private static Map<String,Integer> getMapCountFootFallsPerDayOfWeek(List<FootFallModel> footFallRecords){
		Map<String,Integer> countFootFallPerDay = new LinkedHashMap<>();
		for(FootFallModel record: footFallRecords) {
			countFootFallPerDay.merge(record.getDate().getDayOfWeek().toString(), 1, Integer::sum);
		}
		return countFootFallPerDay;
		
	}
	
	private static Map<String,Integer> getMapCountNoOfOccurencesOfDaysOfWeek(List<FootFallModel> footFallRecords){
		Map<String,Integer> countNoOfOccurencesOfDaysOfWeek= new LinkedHashMap<>();
		String date = ""; 
		for(FootFallModel record: footFallRecords) {
			if(!date.equals(record.getDate().toString())) {
				countNoOfOccurencesOfDaysOfWeek.merge(record.getDate().getDayOfWeek().toString(), 1, Integer::sum);
				date = record.getDate().toString();
			}	
		}
		return countNoOfOccurencesOfDaysOfWeek;
		
	} 
	
	

}
