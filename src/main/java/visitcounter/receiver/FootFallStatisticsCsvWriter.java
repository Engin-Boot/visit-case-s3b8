package visitcounter.receiver;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.opencsv.CSVWriter;

public class FootFallStatisticsCsvWriter {
	
	public static CSVWriter getWriter(String path) {
	CSVWriter writer = null;
	try {
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
		writer = new CSVWriter(outputStreamWriter);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return writer;
	}
	
	public static void writeColumnNamesToCsv(String[] column_names, CSVWriter writer) {
		writer.writeNext(column_names);
	}
	
	public static void writeRecordToCsv(String[] record, CSVWriter writer) {
		writer.writeNext(record);
	}
	
	public static void executeFlush(CSVWriter writer){
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
