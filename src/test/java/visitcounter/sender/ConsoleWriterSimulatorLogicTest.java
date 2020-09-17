package visitcounter.sender;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleWriterSimulatorLogicTest {
	
	@Mock
	FootFallConsoleWriter footFallConsoleWriter;
	
//	@Test
//	public void add() throws InterruptedException
//	{
//		List<String> footFallRecords = new ArrayList<String>();
//		footFallRecords.add("testrecord1");
//		footFallRecords.add("testrecord2");
//		ConsoleWriterSimulatorLogic.sendFootFalldataInbunch(footFallRecords);
//		verify(footFallConsoleWriter, times(1)).writeFootFallRecordtoConsole(anyString());
//		
//		
//	}
	
//	@Test
//	public void test2() throws IOException
//	{
//		List<String> expectedRecords = new ArrayList<>();
//		expectedRecords.add("2020-01-01,08:10:01");
//		expectedRecords.add("2020-01-01,08:10:30");	
//		
//		List<String> actualRecords = FootFallCsvReader.readFootfalldataLinebyLinefromCsv("src/test/resources/test.csv");
//		Assert.assertArrayEquals(expectedRecords.toArray(), actualRecords.toArray());
//	}
}
