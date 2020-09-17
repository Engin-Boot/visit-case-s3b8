package visitcounter.sender;

public class FootFallConsoleWriter implements IFootFallConsoleWriter{
	public String writeFootFallRecordtoConsole(String record) {
		System.out.println(record);
		return record;
	}
}
