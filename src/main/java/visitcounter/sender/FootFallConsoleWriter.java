package visitcounter.sender;

import org.apache.log4j.Logger;

public class FootFallConsoleWriter implements IFootFallConsoleWriter{
	
	static final Logger logger = Logger.getLogger(FootFallConsoleWriter.class);
	
	@Override
	public String writeFootFallRecordtoConsole(String record) {
		logger.info(record);
		return record;
	}
}
