package visitcounter.receiver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FootfallDataConsoleReader {

	public void readFootfalldataLinebyLineFromConsole(FootFallRecordObjectStorer footFallRecordObjectStorer) throws Exception{
		String line = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
			while((line = br.readLine())!=null) {
				footFallRecordObjectStorer.storeFootFallRecordAsObject(line);
			}
		} catch (IOException e) {
			throw e;
		} 
		
//	
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/01,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/02,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/02,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/03,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/04,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/05,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/06,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/07,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/07,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/07,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/08,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/14,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/21,08:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/21,09:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/21,11:03:50");
//		footFallRecordObjectStorer.storeFootFallRecordAsObject("2020/01/21,16:03:50");
//		
//		System.out.println("DONEEE1");
		//System.out.println(FootFallRecordObjectStorer.getFootFallRecords().get(0).getDate());
		//System.out.println(FootFallRecordObjectStorer.getFootFallRecords().get(0).getTime());		
	}
}
