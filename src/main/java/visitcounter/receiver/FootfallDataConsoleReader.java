package visitcounter.receiver;

import java.io.BufferedReader;

public class FootfallDataConsoleReader {

	public void readFootfalldataLinebyLineFromConsole(FootFallRecordObjectStorer footFallRecordObjectStorer, BufferedReader reader) throws Exception{
		String line = "";
		try(BufferedReader br = reader)  {
			while((line = br.readLine())!=null) {
				footFallRecordObjectStorer.storeFootFallRecordAsObject(line);
			}
		} catch (Exception e) {
			throw e;
		} 		
	}
}
