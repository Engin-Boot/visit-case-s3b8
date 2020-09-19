package visitcounter.receiver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String [] args){
		
		try {
			FootfallDataConsoleReader consoleReader = new FootfallDataConsoleReader();
			FootFallRecordObjectStorer footFallRecordObjectStorer = new FootFallRecordObjectStorer();
			consoleReader.readFootfalldataLinebyLineFromConsole(footFallRecordObjectStorer);
	
			FootFallStatisticsCsvWriter csvWriter = new FootFallStatisticsCsvWriter();
			
			StatisticsCalculator.calculateAverageFootfallsPerHourOverDay(footFallRecordObjectStorer.getFootFallRecords(), csvWriter);
			StatisticsCalculator.calculateDailyFootfallsOverWeek(footFallRecordObjectStorer.getFootFallRecords(), csvWriter);
			StatisticsCalculator.calculatePeakDailyFootFallsInLastMonth(footFallRecordObjectStorer.getFootFallRecords(), csvWriter);		
		}
		catch(Exception e) {
			logger.error("", e);
		}

	}
}
