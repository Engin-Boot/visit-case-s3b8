package visitcounter.receiver;

import java.time.format.DateTimeParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FootFallRecordObjectStorerTest {
	
	@Test
	public void whenValidFootFallRecordStoredThenNoException() throws Exception
	{
		String record_one = "2020/01/01,10:00:05";
		String record_two = "2020/01/02,11:10:05";
		FootFallRecordObjectStorer footFallRecordObjectStorer = new FootFallRecordObjectStorer();
		footFallRecordObjectStorer.storeFootFallRecordAsObject(record_one);
		footFallRecordObjectStorer.storeFootFallRecordAsObject(record_two);
		List<FootFallModel> records = footFallRecordObjectStorer.getFootFallRecords();
		Assert.assertEquals(2, records.size());
	}
	
	@Test(expected = DateTimeParseException.class)
	public void whenFootFallRecordStoredWithInvalidDateTimeFormatThenThrowException() throws Exception
	{
		String record_one = "2020-01/01,10:00:05"; //invalid record as format is not correct
		FootFallRecordObjectStorer footFallRecordObjectStorer = new FootFallRecordObjectStorer();
		footFallRecordObjectStorer.storeFootFallRecordAsObject(record_one);
	}
	
	@Test(expected = Exception.class)
	public void whenFootFallRecordStoredWithNoCommaSeperatorThenThrowException() throws Exception
	{
		String record_one = "2020-01/0110:00:05"; //invalid record as format is not correct
		FootFallRecordObjectStorer footFallRecordObjectStorer = new FootFallRecordObjectStorer();
		footFallRecordObjectStorer.storeFootFallRecordAsObject(record_one);
	}

}
