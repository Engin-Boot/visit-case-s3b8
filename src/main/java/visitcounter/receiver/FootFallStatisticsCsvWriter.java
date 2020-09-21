package visitcounter.receiver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVWriter;

public class FootFallStatisticsCsvWriter implements IFootFallCsvWriter {
	
	private CSVWriter writer;
	
	public CSVWriter getWriter() {
		return writer;
	}

	@Override
	public void createWriter(String path) throws IOException {
		try {
			//OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(Paths.get(path), StandardCharsets.UTF_8));
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), StandardCharsets.UTF_8);
			this.writer = new CSVWriter(writer);
		} catch (IOException e) {
			throw e;
		}
	}
	
	@Override
	public void writeColumnNamesToCsv(String... column_names) {
		writer.writeNext(column_names);
	}
	
	@Override
	public void writeRecordToCsv(String... record) {
		writer.writeNext(record);
	}
	
	@Override
	public void closeWriter() throws IOException{
		try {
			writer.close();
		} catch (IOException e) {
			throw e;
		}
	}
	
	
}
