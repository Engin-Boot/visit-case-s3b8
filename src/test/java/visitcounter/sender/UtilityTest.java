package visitcounter.sender;


import org.junit.Assert;
import org.junit.Test;

public class UtilityTest {
	@Test
	public void whenAFilePathIsPresentInPropertiesFileThenReturnNonEmptyStringPath()
	{
		Assert.assertEquals("src/test/resources/test.csv", Utility.readCsvFileNameFromProperties());
	}
	
}
