package visitcounter.receiver;

public class Main {
	
	public static void main(String [] args){
		
		try {
			//System.out.println(Utility.convertStringToDate("2020/01/02"));
			//System.out.println(Utility.convertStringToTime("08:03:50"));
			
			FootfallDataConsoleReader consoleReader = new FootfallDataConsoleReader();
			FootFallRecordObjectStorer footFallRecordObjectStorer = new FootFallRecordObjectStorer();
			consoleReader.readFootfalldataLinebyLineFromConsole(footFallRecordObjectStorer);
			//StatisticsCalculator.calculateAverageFootfallsPerHourOverDay();
			//StatisticsCalculator.calculateDailyFootfallsOverWeek();
			
			//StatisticsCalculator.calculateAverageFootfallsPerHourOverDay();
			//StatisticsCalculator.calculatePeakDailyFootfallsInParticularMonth(1, 2020);
			
			//StatisticsCalculator.calculateDailyFootfallsOverWeek();
			FootFallStatisticsCsvWriter csvWriter = new FootFallStatisticsCsvWriter();
			StatisticsCalculator.calculateAverageFootfallsPerHourOverDay(footFallRecordObjectStorer.getFootFallRecords(), csvWriter);
			
			StatisticsCalculator.calculateDailyFootfallsOverWeek(footFallRecordObjectStorer.getFootFallRecords(), csvWriter);
			StatisticsCalculator.calculatePeakDailyFootFallsInLastMonth(footFallRecordObjectStorer.getFootFallRecords(), csvWriter);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
