package visitcounter.sender;


import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class MainClassTest {
	@Test
	public void whenFileIsNotPresentThenThrowException() throws Exception
	{
		assertNotEquals("", Main.readPathFromProperties());
	}
}
