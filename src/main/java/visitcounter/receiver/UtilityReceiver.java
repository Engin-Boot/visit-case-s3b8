package visitcounter.receiver;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class UtilityReceiver {
	
	public static final ResourceBundle rb = ResourceBundle.getBundle("outputpaths");
	
	public static String[] splitDatabyComma(String record)throws Exception {
		String splitted_Record[] = record.split(",");
		if(splitted_Record.length == 2) {
			return splitted_Record;
		}
		else {
			throw new Exception("Splitted array record does not contain 2 entries");
		}
	}

	public static LocalDate convertStringToDate(String string_date) {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date = LocalDate.parse(string_date, format);
		return date;

	}

//	public static LocalTime getTimeFromString(String string, DateTimeFormatter format) {
//		LocalTime date = LocalTime.parse(string, format);
//		return date;
//	}

	public static LocalTime convertStringToTime(String string_time) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime time = LocalTime.parse(string_time, format);
		return time;
	}
	
	
	public static String getCsvOutputFilePathFromProperties(String key) {	
		String path = rb.getString(key);
		return path;
	}
	
	public static int [] getWorkingHourOFaDay() {
		int opening_Hour = 5;
		int closing_Hour = 18;
		
		int [] working_hour = new int[2];
		working_hour[0] = opening_Hour;
		working_hour[1] = closing_Hour;
		return working_hour;		
	}
	
}