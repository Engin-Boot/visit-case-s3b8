package visitcounter.sender;

import java.util.List;
import java.util.ResourceBundle;

public class Main {
	
	public static String readPathFromProperties() {	
		ResourceBundle rb = ResourceBundle.getBundle("filepath");
		String path = rb.getString("filename");
		return path;
	}
	
	public static void main(String[] args){
		
		try {
			List<String> footfallRecords = FootFallCsvReader.readFootfalldataLinebyLinefromCsv(readPathFromProperties());
			ConsoleWriterSimulatorLogic.sendFootFalldataInbunch(footfallRecords);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
