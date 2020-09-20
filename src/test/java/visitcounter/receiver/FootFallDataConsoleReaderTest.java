package visitcounter.receiver;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FootFallDataConsoleReaderTest {
	
	@Mock
	BufferedReader br;
	
	@Mock
	FootFallRecordObjectStorer storer;
	
	ArgumentCaptor<String> argumentCaptorRecord = ArgumentCaptor.forClass(String.class);
	
	@Test
	public void whenReadRecordFromConsoleThenThrowNoExcpetion() throws Exception
	{
		FootfallDataConsoleReader consoleReader = new FootfallDataConsoleReader();
		when(br.readLine()).thenReturn("record1", "record2", null);
		doNothing().when(storer).storeFootFallRecordAsObject(any());
		
		consoleReader.readFootfalldataLinebyLineFromConsole(storer, br);
		
		verify(storer, times(2)).storeFootFallRecordAsObject(argumentCaptorRecord.capture());
		Assert.assertEquals("record1", argumentCaptorRecord.getAllValues().get(0));
		Assert.assertEquals("record2", argumentCaptorRecord.getAllValues().get(1));
		
	}
	
	@Test(expected = IOException.class)
	public void whenReadRecordFromConsoleButBufferedReaderReadLineDosentWorkThenThrowExcpetion1() throws Exception
	{
		FootfallDataConsoleReader consoleReader = new FootfallDataConsoleReader();
		doThrow(new IOException()).when(br).readLine();
		doNothing().when(storer).storeFootFallRecordAsObject(any());
		
		consoleReader.readFootfalldataLinebyLineFromConsole(storer, br);	
	}
	
	@Test(expected = Exception.class)
	public void whenReadRecordWithInvalidFormatFromThenThrowExcpetion1() throws Exception
	{
		FootfallDataConsoleReader consoleReader = new FootfallDataConsoleReader();
		when(br.readLine()).thenReturn("record1", "record2", null);
		doThrow(new IOException()).when(storer).storeFootFallRecordAsObject(any());
		
		consoleReader.readFootfalldataLinebyLineFromConsole(storer, br);	
	}


}
