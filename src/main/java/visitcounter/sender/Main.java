package visitcounter.sender;

import java.util.List;

public class Main {
		
	public static void main(String[] args){
		
		try {
			FootFallCsvReader footFallCsvReader = new FootFallCsvReader();
			
			List<String> footfallRecords = footFallCsvReader.readFootfalldataLinebyLinefromCsv(Utility.readCsvFileNameFromProperties("filename"));
			
			IFootFallConsoleWriter consoleWriter = new FootFallConsoleWriter();
			ConsoleWriterSimulatorLogic consoleWriterSimulatorLogic = new ConsoleWriterSimulatorLogic(consoleWriter);
			consoleWriterSimulatorLogic.sendFootFalldataInbunch(footfallRecords);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
