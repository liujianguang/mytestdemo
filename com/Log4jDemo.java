package com;

import javax.management.RuntimeErrorException;

import org.apache.log4j.Logger;

public class Log4jDemo {
	private static Logger logger = Logger.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		
//		PropertyConfigurator.configure("log4j.properties");
//		logger.debug("This is debug message.");
//		// ��¼info�������Ϣ
//		logger.info("This is info message1.");
		try {
			throw new RuntimeException("test");
		} catch (Exception e2) {
			logger.error(e2,e2.fillInStackTrace());
			e2.printStackTrace();
		}
		
		// logger.info("This is info message2.");
		// logger.info("This is info message3.");
		// logger.info("This is info message4.");
		// logger.info("This is info message5.");
		// ��¼error�������Ϣ
//		logger.error("This is error message.");
	}
}
