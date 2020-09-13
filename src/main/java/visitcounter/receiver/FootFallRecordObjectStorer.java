package visitcounter.receiver;

import java.util.ArrayList;
import java.util.List;

public class FootFallRecordObjectStorer {
	public static List<FootFallModel> footFallRecords= new ArrayList<>();
	
	public static void storeFootFallRecordAsObject(String record){
		String [] arrayWithDateTime = Utility.splitDatabyComma(record);
		footFallRecords.add(new FootFallModel(Utility.convertStringToDate(arrayWithDateTime[0]), Utility.convertStringToTime(arrayWithDateTime[1])));
		
	}
}
