package visitcounter.sender;

import java.util.List;

public class ConsoleWriterSimulatorLogic{

	// This function help in simulating a sensor
		private static void sensorSimulationUsingThread(int countofdatasent) {
			if(countofdatasent%10 == 0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		}

		public static void sendFootFalldataInbunch(List<String> footfallrecords) {
			int countofdatasent = 0;
			for(String string : footfallrecords) {
				System.out.println(string);
				countofdatasent++;
				sensorSimulationUsingThread(countofdatasent);
			}
		}
}
