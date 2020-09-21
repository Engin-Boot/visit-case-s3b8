package visitcounter.receiver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String [] args){
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
			FootfallDataConsoleReader consoleReader = new FootfallDataConsoleReader();
			FootFallRecordObjectStorer footFallRecordObjectStorer = new FootFallRecordObjectStorer();
			consoleReader.readFootfalldataLinebyLineFromConsole(footFallRecordObjectStorer, br);
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
