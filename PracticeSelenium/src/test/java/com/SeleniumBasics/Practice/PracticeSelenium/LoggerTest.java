package com.SeleniumBasics.Practice.PracticeSelenium;

import org.apache.logging.log4j.*;

public class LoggerTest {
	
	public static Logger log = LogManager.getLogger(LoggerTest.class.getName());
	public static void main(String[] args) {
		log.debug("Debug");
		log.error("This is Error");
		log.info("Successful");
	}
	
}
