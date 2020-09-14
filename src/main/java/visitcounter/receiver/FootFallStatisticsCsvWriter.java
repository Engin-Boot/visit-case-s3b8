package visitcounter.receiver;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class FootFallStatisticsCsvWriter {
	
	public static CSVWriter getWriter() throws IOException {
	CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/output.csv"));
	return writer;
	}
}
