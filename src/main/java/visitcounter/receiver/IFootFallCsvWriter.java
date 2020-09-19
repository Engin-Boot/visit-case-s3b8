package visitcounter.receiver;

import java.io.IOException;

public interface IFootFallCsvWriter {
	
	 void createWriter(String path) throws IOException;
		
		
	 void writeColumnNamesToCsv(String... column_names);
	
	
	 void writeRecordToCsv(String... record);
	
	
	 void closeWriter() throws IOException;
		

}
