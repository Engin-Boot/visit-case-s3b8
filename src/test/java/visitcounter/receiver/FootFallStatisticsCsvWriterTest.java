package visitcounter.receiver;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.opencsv.CSVWriter;

@RunWith(MockitoJUnitRunner.class)
public class FootFallStatisticsCsvWriterTest {
	
	@Mock
	CSVWriter writer;

	
	@Test
	public void xx() throws IOException
	{
		String path = "src/test/resources/test1.csv";
		FootFallStatisticsCsvWriter footFallStatisticsCsvWriter = new FootFallStatisticsCsvWriter();
		footFallStatisticsCsvWriter.createWriter(path);
		Assert.assertNotNull(footFallStatisticsCsvWriter.getWriter());
	}
	
	@Test(expected = IOException.class)
	public void xx1() throws IOException
	{
		String invalid_path = "[invalid_path]/invalid";
		FootFallStatisticsCsvWriter footFallStatisticsCsvWriter = new FootFallStatisticsCsvWriter();
		footFallStatisticsCsvWriter.createWriter(invalid_path);
	}
	
//	@Test
//	public void xx2() throws IOException
//	{
//		String path = "src/test/resources/test1.csv";
//		FootFallStatisticsCsvWriter footFallStatisticsCsvWriter = new FootFallStatisticsCsvWriter();
//		footFallStatisticsCsvWriter.createWriter(path);
//		
//		verify(writer, times(1)).writeNext(any());
//		//Assert.assertNotNull(footFallStatisticsCsvWriter.getWriter());
//	}
	

}
