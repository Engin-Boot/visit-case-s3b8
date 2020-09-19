package visitcounter.sender;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FootFallCsvReaderTest {
	
	@Test(expected = IOException.class)
	public void whenFileIsNotPresentThenThrowException() throws IOException 
	{
		FootFallCsvReader reader = new FootFallCsvReader();
		reader.readFootfalldataLinebyLinefromCsv("src/test/resources/missingfile.csv");	
	}
	
	@Test
	public void whenCsvFileIsPresentAndNoDataIsPresentInCsvThenReturnEmptyList() throws IOException
	{
		FootFallCsvReader reader = new FootFallCsvReader();
		List<String> returnedrecords = reader.readFootfalldataLinebyLinefromCsv("src/test/resources/emptytest.csv");
		assertThat("asserting record is empty",returnedrecords.isEmpty(), equalTo(true));
	}
	
	@Test
	public void whenCsvFileIsPresentThenReturnListOfRecords() throws IOException
	{
		FootFallCsvReader reader = new FootFallCsvReader();
		List<String> expectedRecords = new ArrayList<>();
		expectedRecords.add("2020-01-01,08:10:01");
		expectedRecords.add("2020-01-01,08:10:30");	
		
		List<String> actualRecords = reader.readFootfalldataLinebyLinefromCsv("src/test/resources/test.csv");
		Assert.assertArrayEquals(expectedRecords.toArray(), actualRecords.toArray());	
	}
}
