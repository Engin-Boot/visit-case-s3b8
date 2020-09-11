package visitcounter.sender;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> footfallrecords = FootFallCsvReader.ReadFootfalldataLinebyLinefromCsv("footfall.csv");
		ConsoleWriterSimulatorLogic.sendFootFalldataInbunch(footfallrecords);
	}
}
