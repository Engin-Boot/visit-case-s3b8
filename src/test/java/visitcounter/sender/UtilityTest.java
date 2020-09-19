package visitcounter.sender;


import java.util.MissingResourceException;

import org.junit.Assert;
import org.junit.Test;

public class UtilityTest {
	@Test
	public void whenReadCsvFileNameFromPropertiesFileWithValidKeyThenReturnFileNameWithPath()
	{
		String filePath = Utility.readCsvFileNameFromProperties("filename");
		Assert.assertEquals("src/test/resources/test.csv", filePath);
	}
	
	@Test(expected = MissingResourceException.class)
	public void whenReadCsvFileNameFromPropertiesFileWithInvalidKeyThenThrowException()
	{
		Utility.readCsvFileNameFromProperties("invalidkey");
	}
	
}
