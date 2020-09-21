package visitcounter.receiver;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FootFallRecordObjectStorer {
	
	private static List<FootFallModel> footFallRecords = new ArrayList<FootFallModel>();

	public List<FootFallModel> getFootFallRecords(){
		return footFallRecords;
	}
	
	public void storeFootFallRecordAsObject(String record) throws Exception{
		try {
			String [] arrayWithDateTime = UtilityReceiver.splitDatabyComma(record);
			footFallRecords.add(new FootFallModel(UtilityReceiver.convertStringToDate(arrayWithDateTime[0]), UtilityReceiver.convertStringToTime(arrayWithDateTime[1])));
		} 
		catch(DateTimeParseException | ArrayIndexOutOfBoundsException e) {
			throw e;
		}
	}
}
