package visitcounter.sender;

import java.util.ResourceBundle;

public class Utility {

	public static ResourceBundle rb = ResourceBundle.getBundle("filepath");
	public static String readCsvFileNameFromProperties() {	
		String path = rb.getString("filename");
		return path;
	}
}