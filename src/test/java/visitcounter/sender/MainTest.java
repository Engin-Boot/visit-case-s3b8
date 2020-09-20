package visitcounter.sender;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	
	@Test
	public void whenMainExecutedThenThrowNoException() {
		try {
		Main.main(null);
		}
		catch(Exception ex) {
			Assert.fail();
		}
	}
	

}
