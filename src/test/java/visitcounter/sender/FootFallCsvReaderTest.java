package visitcounter.sender;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FootFallCsvReaderTest {
	
	@Test(expected = FileNotFoundException.class)
	public void whenFileIsNotPresentThenThrowException() throws IOException
	{
		FootFallCsvReader.readFootfalldataLinebyLinefromCsv("missingfile.csv");
		
	}
	
	@Test
	public void whenCsvFileIsPresentThenReturnListOfRecords() throws IOException
	{
		List<String> expectedRecords = new ArrayList<>();
		expectedRecords.add("2020-01-01,08:10:01");
		expectedRecords.add("2020-01-01,08:10:30");	
		
		List<String> actualRecords = FootFallCsvReader.readFootfalldataLinebyLinefromCsv("test.csv");
		Assert.assertArrayEquals(expectedRecords.toArray(), actualRecords.toArray());
		//System.out.println(actualRecords.get(0));
		
	}
	
	
	

}
