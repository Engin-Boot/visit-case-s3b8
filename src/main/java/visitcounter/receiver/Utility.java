package visitcounter.receiver;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Utility {
	
	public static final ResourceBundle rb = ResourceBundle.getBundle("outputpaths");
	
	public static String[] splitDatabyComma(String record) {
		String splitted_Record[] = record.split(",");
		return splitted_Record;
	}

	public static LocalDate convertStringToDate(String string_date) {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date = LocalDate.parse(string_date, format);
		return date;

	}

	public static LocalTime getTimeFromString(String string, DateTimeFormatter format) {
		LocalTime date = LocalTime.parse(string, format);
		return date;
	}

	public static LocalTime convertStringToTime(String string_time) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime time = LocalTime.parse(string_time, format);
		return time;
	}
	
	
	public static String getCsvOutputFilePathFromProperties(String filename) {	
		String path = rb.getString(filename);
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