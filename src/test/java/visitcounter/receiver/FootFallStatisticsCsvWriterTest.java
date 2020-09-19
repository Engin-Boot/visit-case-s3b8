package visitcounter.receiver;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FootFallStatisticsCsvWriterTest {
	

	
	@Test
	public void whenCsvWriterIsCreatedThenThrowNoException() throws IOException
	{
		String path = "src/test/resources/test1.csv";
		FootFallStatisticsCsvWriter footFallStatisticsCsvWriter = new FootFallStatisticsCsvWriter();
		footFallStatisticsCsvWriter.createWriter(path);
		Assert.assertNotNull(footFallStatisticsCsvWriter.getWriter());
	}
	
	@Test(expected = IOException.class)
	public void whenCsvWriterIsCreatedWithInvalidPathThenThrowException() throws IOException
	{
		String invalid_path = "[invalid_path]/invalid";
		FootFallStatisticsCsvWriter footFallStatisticsCsvWriter = new FootFallStatisticsCsvWriter();
		footFallStatisticsCsvWriter.createWriter(invalid_path);
	}
	
	@Test
	public void whenDataisWrittenToCsvFileThenFileShouldNotBeEmpty() throws IOException
	{
		String column_names[] = {"Column1","Column2"};
		String record[] = {"2020-01-01","10:00:00"};
		String path = "src/test/resources/test1.csv";
		FootFallStatisticsCsvWriter footFallStatisticsCsvWriter = new FootFallStatisticsCsvWriter();
		footFallStatisticsCsvWriter.createWriter(path);
		footFallStatisticsCsvWriter.writeColumnNamesToCsv(column_names);
		footFallStatisticsCsvWriter.writeRecordToCsv(record);
		footFallStatisticsCsvWriter.closeWriter();
		
		File file = new File("src/test/resources/test1.csv");
		Assert.assertTrue(file.length()>0);
		
	}
	

}
