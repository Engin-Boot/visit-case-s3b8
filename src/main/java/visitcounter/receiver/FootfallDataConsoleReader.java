package visitcounter.receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FootfallDataConsoleReader {
	
	public static void readFootfalldataLinebyLineFromConsole(){
		String line = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while((line = br.readLine())!=null) {
				FootFallRecordObjectStorer.storeFootFallRecordAsObject(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
