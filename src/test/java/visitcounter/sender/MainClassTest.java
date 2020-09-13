package visitcounter.sender;


import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class MainClassTest {
	@Test
	public void whenAFilePathIsPresentInPropertiesFileThenReturnNonEmptyStringPath() throws Exception
	{
		assertNotEquals("", Main.readPathFromProperties());
	}
	
}
