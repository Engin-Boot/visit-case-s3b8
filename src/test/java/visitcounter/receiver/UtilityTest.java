package visitcounter.receiver;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.MissingResourceException;

import org.junit.Assert;
import org.junit.Test;

public class UtilityTest {
	
	@Test
	public void whenSplitRecordByCommaThenThowNoException() throws Exception {
		String record = "2020/01/01,10:00:05";
		String[] splitRecord = Utility.splitDatabyComma(record);
		
		Assert.assertEquals("2020/01/01", splitRecord[0]);
		Assert.assertEquals("10:00:05", splitRecord[1]);
	}
	
	@Test(expected = Exception.class)
	public void whenSplitInvalidRecordByCommaThenThowException1() throws Exception {
		String record = "2020/01/01:10:00:05";
		Utility.splitDatabyComma(record);		
	}
	
	@Test
	public void whenConvertStringToDateIsInvokedThenThowNoException() throws Exception {
		LocalDate expectedDate = LocalDate.of(2020, 1, 1);
		String date = "2020/01/01";
		LocalDate actualDate = Utility.convertStringToDate(date);
		
		Assert.assertEquals(expectedDate,actualDate);
	}
	
	@Test(expected = DateTimeParseException.class)
	public void whenConvertStringInInvalidFormatToDateThenThowException() throws Exception {
		String invalid_date = "2020:01:01"; //Should be in yyyy/MM/dd format
		Utility.convertStringToDate(invalid_date);
	}
	
	@Test
	public void whenConvertStringToTimeIsInvokedThenThowNoException() throws Exception {
		LocalTime expectedTime = LocalTime.of(10, 0, 5);
		String time = "10:00:05";
		LocalTime actualTime = Utility.convertStringToTime(time);
		
		Assert.assertEquals(expectedTime,actualTime);
	}
	
	@Test(expected = DateTimeParseException.class)
	public void whenConvertStringInInvalidFormatToTimeThenThowException() throws Exception {
		String invalid_time = "10:0:5";  //Should be in HH:mm:ss format
		Utility.convertStringToDate(invalid_time);
	}
	
	@Test
	public void whenReadCsvFileNameFromPropertiesFileWithValidKeyThenReturnFileNameWithPath(){
		String filePath = Utility.getCsvOutputFilePathFromProperties("filename1");
		Assert.assertEquals("src/test/resources/test1.csv", filePath);
	}
	
	@Test(expected = MissingResourceException.class)
	public void whenReadCsvFileNameFromPropertiesFileWithInvalidKeyThenThrowException(){
		Utility.getCsvOutputFilePathFromProperties("invalidkey");
	}
	
	@Test
	public void whenGetWorkingHoursOfDayThenThrowNoException() {
		int working_hours[] = Utility.getWorkingHourOFaDay();
		Assert.assertEquals(5, working_hours[0]);
		Assert.assertEquals(18, working_hours[1]);
	}
	
	

}
