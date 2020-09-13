package visitcounter.sender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FootFallCsvReader{
	
	public static List<String> readFootfalldataLinebyLinefromCsv(String filename) throws IOException {
		List<String> footfallData = new ArrayList<String>();
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			br.readLine();  //to skip the first row
			while((line = br.readLine())!=null) {
				footfallData.add(line);
			}
		} catch (IOException e) {
			throw e;
		} 
		return footfallData;
	}
}
