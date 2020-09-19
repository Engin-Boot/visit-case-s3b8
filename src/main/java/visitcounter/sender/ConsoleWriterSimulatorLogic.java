package visitcounter.sender;

import java.util.List;

public class ConsoleWriterSimulatorLogic {
	
	IFootFallConsoleWriter consoleWriter;
	
	public ConsoleWriterSimulatorLogic(IFootFallConsoleWriter consoleWriter) {
		super();
		this.consoleWriter = consoleWriter;
	}

	// This function help in simulating a sensor
	private void sensorSimulationUsingThread(int countofdatasent) throws InterruptedException {
		if(countofdatasent%10 == 0) {
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			throw e;
		}
	  }
	}

	public void sendFootFalldataInbunch(List<String> footfallrecords) throws InterruptedException {
		int countOfDataSent = 0;
		for(String record : footfallrecords) {
			consoleWriter.writeFootFallRecordtoConsole(record);
			countOfDataSent++;
			sensorSimulationUsingThread(countOfDataSent);
		}
	}
}
