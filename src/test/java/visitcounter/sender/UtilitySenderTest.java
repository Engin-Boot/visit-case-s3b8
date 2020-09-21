package visitcounter.sender;


import java.util.MissingResourceException;

import org.junit.Assert;
import org.junit.Test;

public class UtilitySenderTest {
	@Test
	public void whenReadCsvFileNameFromPropertiesFileWithValidKeyThenReturnFileNameWithPath()
	{
		String filePath = UtilitySender.readCsvFileNameFromProperties("filename");
		Assert.assertEquals("src/test/resources/test.csv", filePath);
	}
	
	@Test(expected = MissingResourceException.class)
	public void whenReadCsvFileNameFromPropertiesFileWithInvalidKeyThenThrowException()
	{
		UtilitySender.readCsvFileNameFromProperties("invalidkey");
	}
	
	@Test
	public void whenArgValidThenReturnKey()
	{
		String args[] = new String[0];
		String key = UtilitySender.checkIfValidKey(args);
		Assert.assertEquals("filename", key);
	}
	
	@Test
	public void whenArgInvalidThenReturnInvalidKey()
	{
		String args[] = {"test_invalidfile"};
		String key = UtilitySender.checkIfValidKey(args);
		Assert.assertEquals("filename_invalid", key);
	}
	
	
}
