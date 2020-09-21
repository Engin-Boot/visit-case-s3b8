package visitcounter.sender;

import java.util.ResourceBundle;

public class UtilitySender {

	public static ResourceBundle rb = ResourceBundle.getBundle("filepath");
	public static String readCsvFileNameFromProperties(String key) {	
		String path = rb.getString(key);
		return path;
	}
	
	public static String checkIfValidKey(String args[]) {
		String key = "filename";
		if(args.length!=0 && args[0].equals("test_invalidfile")) {
			key="filename_invalid";
		}
		return key;
	}
}
