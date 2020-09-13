package visitcounter.sender;


import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class UtilityClassTest {
	@Test
	public void whenAFilePathIsPresentInPropertiesFileThenReturnNonEmptyStringPath() throws Exception
	{
		assertNotEquals("", Utility.readCsvFileNameFromProperties());
	}
	
}
