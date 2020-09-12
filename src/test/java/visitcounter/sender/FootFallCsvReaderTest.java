package visitcounter.sender;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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
	public void whenCsvFileIsPresentAndNoDataIsPresentInCsvThenReturnEmptyList() throws IOException
	{
		List<String> returnedrecords = FootFallCsvReader.readFootfalldataLinebyLinefromCsv("emptytest.csv");
		assertThat(returnedrecords.isEmpty(), equalTo(true));
	}
	
	@Test
	public void whenCsvFileIsPresentThenReturnListOfRecords() throws IOException
	{
		List<String> expectedRecords = new ArrayList<>();
		expectedRecords.add("2020-01-01,08:10:01");
		expectedRecords.add("2020-01-01,08:10:30");	
		
		List<String> actualRecords = FootFallCsvReader.readFootfalldataLinebyLinefromCsv("test.csv");
		Assert.assertArrayEquals(expectedRecords.toArray(), actualRecords.toArray());	
	}
}
