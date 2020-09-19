package visitcounter.receiver;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class FootFallModelTest {
	
	@Test
	public void whenFootFallModelCreatedThenThrowNoException() {
		
		LocalDate expectedDate = LocalDate.now();
		LocalTime expectedTime = LocalTime.now();
		FootFallModel model = new FootFallModel(expectedDate, expectedTime);
		
		Assert.assertEquals(expectedDate, model.getDate());
		Assert.assertEquals(expectedTime, model.getTime());		
	}

}
