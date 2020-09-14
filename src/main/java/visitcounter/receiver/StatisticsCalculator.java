package visitcounter.receiver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StatisticsCalculator {
	
	public static void calculateAverageFootfallsPerHourOverDay() {
		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<LocalDate,Integer> countFootFallPerDay = getMapCountFootFallsPerDay(footFallRecords);
		
		countFootFallPerDay.forEach((k,v) -> System.out.println(k.toString() + " = "+ v.doubleValue()/24)); 			
	}
	
	public static void calculateDailyFootfallsOverWeek() {
		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<LocalDate,Integer> countFootFallPerDay = getMapCountFootFallsPerDay(footFallRecords);
		

		
		int total_count_in_a_week = 0;
		for (Map.Entry<LocalDate,Integer> record : countFootFallPerDay.entrySet()) {
			if(record.getKey().getDayOfMonth() == 8) {
				break;
			}
			total_count_in_a_week += record.getValue();
		}
		System.out.println("DailyFootFallOverWeek = "+ (double)total_count_in_a_week/7);
		
	}
	
	public static void calculatePeakDailyFootfallsInParticularMonth(int month, int year) {
		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
		Map<LocalDate,Integer> countFootFallPerDay = getMapCountFootFallsPerDay(footFallRecords);
		
		int peak_value = 0;
		for (Map.Entry<LocalDate,Integer> record : countFootFallPerDay.entrySet()) {
			if(record.getKey().getMonthValue() == month && record.getKey().getYear() == year) {
				if(record.getValue() > peak_value) {
					peak_value = record.getValue();
				}
			}
		}
		System.out.println("Peak Daily footfalls for month="+ month+ " is "+ peak_value);
		
	}
	
//	public static Map<LocalDate,Integer> getLastMonthData(int month, int year){
//		List<FootFallModel> footFallRecords = FootFallRecordObjectStorer.getFootFallRecords();
//		Map<LocalDate,Integer> countFootFallPerDay = getMapCountFootFallsPerDay(footFallRecords);
//		
//		
//	}
	
	public static Map<LocalDate,Integer> getMapCountFootFallsPerDay(List<FootFallModel> footFallRecords){
		Map<LocalDate,Integer> countFootFallPerDay = new LinkedHashMap<>();
		for(FootFallModel record: footFallRecords) {
			countFootFallPerDay.merge(record.getDate(), 1, Integer::sum);
		}
		return countFootFallPerDay;
		
	}

}
