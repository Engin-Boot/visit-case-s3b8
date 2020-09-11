package visitcounter.sender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FootFallCsvReader{
	
	public static List<String> ReadFootfalldataLinebyLinefromCsv(String filename) {
		List<String> footfalldata = new ArrayList<String>();
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(filename));
			String csvfileheader = br.readLine();
			System.out.println("Sending Header: " + csvfileheader); //sending header Date, time
			while((line = br.readLine())!=null) {
				footfalldata.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return footfalldata;	
	}
}
