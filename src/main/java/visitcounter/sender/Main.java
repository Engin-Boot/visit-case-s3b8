package visitcounter.sender;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> footfallrecords = FootFallCsvReader.ReadFootfalldataLinebyLinefromCsv("Dataset/footfall.csv");
		ConsoleWriterSimulatorLogic.sendFootFalldataInbunch(footfallrecords);
	}
}
