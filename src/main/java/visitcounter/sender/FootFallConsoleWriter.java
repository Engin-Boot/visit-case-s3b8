package visitcounter.sender;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class FootFallConsoleWriter implements IFootFallConsoleWriter{
	
	//static final Logger logger = LogManager.getLogger(FootFallConsoleWriter.class);
	
	@Override
	public String writeFootFallRecordtoConsole(String record) {
		System.out.println(record);
		//logger.info(record);
		return record;
	}
}
