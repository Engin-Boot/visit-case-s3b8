package visitcounter.sender;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	static final Logger logger = LogManager.getLogger(Main.class);
		
	public static void main(String[] args){
		
		try {
			
			FootFallCsvReader footFallCsvReader = new FootFallCsvReader();
			
			List<String> footfallRecords = footFallCsvReader.readFootfalldataLinebyLinefromCsv(Utility.readCsvFileNameFromProperties("filename"));
			
			IFootFallConsoleWriter consoleWriter = new FootFallConsoleWriter();
			ConsoleWriterSimulatorLogic consoleWriterSimulatorLogic = new ConsoleWriterSimulatorLogic(consoleWriter);
			consoleWriterSimulatorLogic.sendFootFalldataInbunch(footfallRecords);
		}
		catch(Exception e) {
			logger.error("", e);
			System.exit(1);
		}
	}
}
