package visitcounter.sender;

import org.junit.Assert;
import org.junit.Test;

public class FootFallConsoleWriterTest {
	
	@Test
	public void whenRecordIsWrittenToConsoleThenReturnRecord()
	{
		IFootFallConsoleWriter writer = new FootFallConsoleWriter();
		String expectedRecord = "2020-01-01,10:00:05";
		String actualRecord = writer.writeFootFallRecordtoConsole(expectedRecord);
		
		Assert.assertEquals(expectedRecord, actualRecord);
	}

}
