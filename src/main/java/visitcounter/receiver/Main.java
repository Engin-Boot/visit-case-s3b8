package visitcounter.receiver;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String [] args) {
		//System.out.println(Utility.convertStringToDate("2020/01/02"));
		//System.out.println(Utility.convertStringToTime("08:03:50"));
		
		FootfallDataConsoleReader.readFootfalldataLinebyLineFromConsole();
		//StatisticsCalculator.calculateAverageFootfallsPerHourOverDay();
		//StatisticsCalculator.calculateDailyFootfallsOverWeek();
		
		StatisticsCalculator.calculatePeakDailyFootfallsInParticularMonth(1, 2020);

		
	}
}
