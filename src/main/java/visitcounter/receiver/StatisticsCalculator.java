package visitcounter.receiver;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StatisticsCalculator {
	
	public static void calculateAverageFootfallsPerHourOverDay(List<FootFallModel> footFallRecords, IFootFallCsvWriter footFallCsvWriter) throws IOException {
		//List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<String,Integer> countFootFallForEveryWorkingHour = getMapCountNoOfFootfallsForEveryWorkingHour(footFallRecords);
		footFallCsvWriter.createWriter(Utility.getCsvOutputFilePathFromProperties("filename1"));
		
		String [] column_names = {"Working Hour", "Average Foot Fall Per Hour"};
		
		footFallCsvWriter.writeColumnNamesToCsv(column_names);
		
		countFootFallForEveryWorkingHour.forEach((k,v) -> {
			Double dailyFootfallPerHour = v.doubleValue()/30;
			String [] data = {k, dailyFootfallPerHour.toString()};
			footFallCsvWriter.writeRecordToCsv(data);
		});
		
		footFallCsvWriter.closeWriter();
	}
	
	public static void calculateDailyFootfallsOverWeek(List<FootFallModel> footFallRecords, IFootFallCsvWriter footFallCsvWriter) throws IOException {
		Map<String,Integer> countFootFallPerDayOfWeek = getMapCountFootFallsPerDayOfWeek(footFallRecords);
		Map<String,Integer> countNoOfOccurencesOfDaysOfWeek = getMapCountNoOfOccurencesOfDaysOfWeek(footFallRecords);

		footFallCsvWriter.createWriter(Utility.getCsvOutputFilePathFromProperties("filename2"));
		
		String [] column_names = {"Day of Week", "Daily Foot Falls Over Week "};
		
		footFallCsvWriter.writeColumnNamesToCsv(column_names);
		
		countFootFallPerDayOfWeek.forEach((k,v) -> {
			Double dailyFootfallPerDayOfWeek = v.doubleValue()/countNoOfOccurencesOfDaysOfWeek.get(k);
			String [] data = {k.toString(), dailyFootfallPerDayOfWeek.toString()};
			footFallCsvWriter.writeRecordToCsv(data);
		});
		
		footFallCsvWriter.closeWriter();
	}
		
	
	// Refractor to reduce cyclomatic complaxity of calculatePeakDailyFootfallsInParticularMonth
	private static String[] getPeakData(Map.Entry<LocalDate,Integer> record, int year, Integer peak_value, String peak_date) {
		if(record.getKey().getYear() == year && record.getValue() > peak_value) {
				peak_value = record.getValue();
				peak_date = record.getKey().toString();
			}
		String [] data = {peak_date, peak_value.toString()};
		return data;
	}
	
	public static void calculatePeakDailyFootfallsInParticularMonth(int month, int year, List<FootFallModel> footFallRecords, IFootFallCsvWriter footFallCsvWriter) throws IOException {
		Map<LocalDate,Integer> countFootFallForEveryDate = getMapCountFootFallsForEveryDate(footFallRecords);
		
		footFallCsvWriter.createWriter(Utility.getCsvOutputFilePathFromProperties("filename3"));
		
		String [] column_names = {"Date", "Peak FootFall for current month"};
		
		footFallCsvWriter.writeColumnNamesToCsv(column_names);
		
		Integer peak_value = 0;
		String peak_date = "2020/01/01";  //initializing with random value
		String [] data = null;
		for (Map.Entry<LocalDate,Integer> record : countFootFallForEveryDate.entrySet()) {
			if(record.getKey().getMonthValue() == month)
			{
				data = getPeakData(record, year, peak_value, peak_date);
				peak_value = Integer.parseInt(data[1]);
				peak_date = data[0];
			}
		}
		footFallCsvWriter.writeRecordToCsv(data);
		footFallCsvWriter.closeWriter();	
	}
	
	public static void calculatePeakDailyFootFallsInLastMonth(List<FootFallModel> footFallRecords, IFootFallCsvWriter footFallCsvWriter) throws IOException {
		int[] last_month_with_year = getLastMonthWithYear(footFallRecords);
		calculatePeakDailyFootfallsInParticularMonth(last_month_with_year[0], last_month_with_year[1], footFallRecords, footFallCsvWriter);
		
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
		Map<String,Integer> countNoOfOccurencesOfDaysOfWeek = new LinkedHashMap<>();
		String date = ""; 
		for(FootFallModel record: footFallRecords) {
			if(!date.equals(record.getDate().toString())) {
				countNoOfOccurencesOfDaysOfWeek.merge(record.getDate().getDayOfWeek().toString(), 1, Integer::sum);
				date = record.getDate().toString();
			}	
		}
		return countNoOfOccurencesOfDaysOfWeek;
		
	} 

	private static Map<String,Integer> getMapCountNoOfFootfallsForEveryWorkingHour(List<FootFallModel> footFallRecords){
		Map<String,Integer> countNoOfFootfallsForEveryWorkingHours = new LinkedHashMap<>();
		int [] working_hour = Utility.getWorkingHourOFaDay();
		int opening_time = working_hour[0];
		int closing_time = working_hour[1];
		for(int i = opening_time; i <= closing_time; i++) {
			countNoOfFootfallsForEveryWorkingHours.put(String.valueOf(i), 0);
		}
		
		for(FootFallModel record: footFallRecords) {
			countNoOfFootfallsForEveryWorkingHours.merge(String.valueOf(record.getTime().getHour()), 1, Integer::sum);
		}
		return countNoOfFootfallsForEveryWorkingHours;
		
	} 
	
	private static int[] getLastMonthWithYear(List<FootFallModel> footFallRecords) {
		FootFallModel last_record = footFallRecords.get(footFallRecords.size()-1);
		int last_month_with_year[] = new int[2];
		last_month_with_year[0] = last_record.getDate().getMonthValue();
		last_month_with_year[1] = last_record.getDate().getYear();
		
		return last_month_with_year;
	}
		

}
