package visitcounter.sender;

import java.util.List;
import java.util.ResourceBundle;

public class Main {
		
	public static void main(String[] args){
		
		try {
			List<String> footfallRecords = FootFallCsvReader.readFootfalldataLinebyLinefromCsv(Utility.readCsvFileNameFromProperties());
			ConsoleWriterSimulatorLogic.sendFootFalldataInbunch(footfallRecords);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
