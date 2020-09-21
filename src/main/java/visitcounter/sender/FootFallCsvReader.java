package visitcounter.sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FootFallCsvReader{
	
	public List<String> readFootfalldataLinebyLinefromCsv(String filename) throws IOException {
		List<String> footfallData = new ArrayList<String>();
		String line = "";
		try (BufferedReader br = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
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
