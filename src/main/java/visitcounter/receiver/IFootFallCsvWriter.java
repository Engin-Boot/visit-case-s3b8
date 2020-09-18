package visitcounter.receiver;

import java.io.IOException;

public interface IFootFallCsvWriter {
	
	public void createWriter(String path) throws IOException;
		
		
	public void writeColumnNamesToCsv(String[] column_names);
	
	
	public void writeRecordToCsv(String[] record);
	
	
	public void closeWriter() throws IOException;
		

}
