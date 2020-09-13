package visitcounter.receiver;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utility {
	
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
}