package visitcounter.sender;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	static final Logger logger = LogManager.getLogger(Main.class);
	
	static boolean checkMainIsExecutedSuccessfully = false;
		
	public static void main(String[] args){
		try {
			String key = UtilitySender.checkIfValidKey(args);
			checkMainIsExecutedSuccessfully = false;
			FootFallCsvReader footFallCsvReader = new FootFallCsvReader();
			List<String> footfallRecords = footFallCsvReader.readFootfalldataLinebyLinefromCsv(UtilitySender.readCsvFileNameFromProperties(key));
			IFootFallConsoleWriter consoleWriter = new FootFallConsoleWriter();
			ConsoleWriterSimulatorLogic consoleWriterSimulatorLogic = new ConsoleWriterSimulatorLogic(consoleWriter);
			consoleWriterSimulatorLogic.sendFootFalldataInbunch(footfallRecords);
			checkMainIsExecutedSuccessfully = true;
			
		}
		catch(Exception e) {
			checkMainIsExecutedSuccessfully = false;
			logger.debug(e);
			logger.error(e.getMessage());
		}
	}
}
