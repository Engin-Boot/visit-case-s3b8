package visitcounter.sender;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class MainTest {
	
	
	@Test
	public void whenMainCalledWithValidKeyForPropertiesFileThenCheckifMainExecutedSuccessfully() throws IOException {
		String arg[] = new String[0];
		Main.main(arg);
		
		Assert.assertTrue(Main.checkMainIsExecutedSuccessfully);
	}
	
	@Test
	public void whenMainCalledWithIValidKeyForPropertiesFileThenCheckifMainExecutedSuccessfully() throws IOException {
		String  arg [] = {"test_invalidfile"};
		Main.main(arg);
		
		Assert.assertFalse(Main.checkMainIsExecutedSuccessfully);
	}
	

}
