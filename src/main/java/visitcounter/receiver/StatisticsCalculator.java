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
		Map<LocalDate,Integer> countFootFallPerDay = getMapCountFootFallsPerDay(footFallRecords);
		CSVWriter writer = FootFallStatisticsCsvWriter.getWriter();
		
		String [] column_name = {"Date", "Average Foot Fall Per Hour"};
		writer.writeNext(column_name);
		
		countFootFallPerDay.forEach((k,v) -> {
			Double dailyFootfallPerHour = v.doubleValue()/24;
			String [] data = {k.toString(), dailyFootfallPerHour.toString()};
			writer.writeNext(data);
		});
		
		writer.flush();
	}
	
	public static void calculateDailyFootfallsOverWeek() throws IOException {
		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<LocalDate,Integer> countFootFallPerDay = getMapCountFootFallsPerDay(footFallRecords);
		
		CSVWriter writer = FootFallStatisticsCsvWriter.getWriter();
		int total_count_in_a_week = 0;
		for (Map.Entry<LocalDate,Integer> record : countFootFallPerDay.entrySet()) {
			if(record.getKey().getDayOfMonth() == 8) {
				break;
			}
			total_count_in_a_week += record.getValue();
		}
		System.out.println("DailyFootFallOverWeek = "+ (double)total_count_in_a_week/7);
		
	}
	
	// Refractor to reduce cyclomatic complaxity of calculatePeakDailyFootfallsInParticularMonth
	public static int refractor(Map.Entry<LocalDate,Integer> record, int year, int peak_value) {
		if(record.getKey().getYear() == year) {
			if(record.getValue() > peak_value) {
				peak_value = record.getValue();
			}
		}
		return peak_value;
	}
	
	public static void calculatePeakDailyFootfallsInParticularMonth(int month, int year) {
		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<LocalDate,Integer> countFootFallPerDay = getMapCountFootFallsPerDay(footFallRecords);
		
		int peak_value = 0;
		for (Map.Entry<LocalDate,Integer> record : countFootFallPerDay.entrySet()) {
			if(record.getKey().getMonthValue() == month)
			{
				peak_value = refractor(record, year, peak_value);
			}
		}
		System.out.println("Peak Daily footfalls for month="+ month+ " is "+ peak_value);
		
	}
	
	
	public static Map<LocalDate,Integer> getMapCountFootFallsPerDay(List<FootFallModel> footFallRecords){
		Map<LocalDate,Integer> countFootFallPerDay = new LinkedHashMap<>();
		for(FootFallModel record: footFallRecords) {
			countFootFallPerDay.merge(record.getDate(), 1, Integer::sum);
		}
		return countFootFallPerDay;
		
	}

}
