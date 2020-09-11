package visitcounter.sender;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		try {
		List<String> footfallrecords = FootFallCsvReader.readFootfalldataLinebyLinefromCsv("footfall.csv");
		ConsoleWriterSimulatorLogic.sendFootFalldataInbunch(footfallrecords);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
