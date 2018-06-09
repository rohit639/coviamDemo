package com.coviam.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerClass {

	private static Logger logger;
	private static final String fileName = "coviamDemoLogger";
	private static final String dateAndTimeFormat = "MM-dd-yyyy_hh.mm.ss";
	private static final String logProperttFilePath = "/src/main/resources/log4j.properties";
	

	static {
		
		try {
			String dateTime = getFormattedCurrentDateAndTime(dateAndTimeFormat);
			String FileName = fileName + "-" + dateTime + ".log";
				Properties props = new Properties();
				System.out.println(System.getProperty("user.dir"));
				props.load(new FileInputStream(System.getProperty("user.dir")+logProperttFilePath));
				props.setProperty("log4j.appender.File.File", "logs/"
						+ FileName);
				LogManager.resetConfiguration();
				PropertyConfigurator.configure(props);
				System.out.println("Property log4j.appender.File.File = logs/"
						+ FileName);
			
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.print("IO Exception in static method of Logger Class. "
					+ ex.getMessage());
			System.exit(-1);
		}

	}

	/**
	 * This method creates instance of the Logger class coming from log4j jar by
	 * implementing a singelton
	 * 
	 * @return _logger - new instance if no instance exist else an existing
	 *         instance if the method is invoked previously
	 */
	public static Logger createLogger() {
		if (logger == null) {
			logger = LogManager.getLogger(LoggerClass.class);
			logger.setLevel(Level.ALL);
			//	_logger.addHandler(file);

			return logger;
		} else
			return logger;
	}

	private static String getFormattedCurrentDateAndTime(String format) {
        String formattedDateTime = null;
        try {
        	
            formattedDateTime = new SimpleDateFormat(format).format(new Date());
            //logger.info("Formatted(" + format + ")Current Date and Time is " + formattedDateTime);

        } catch (Exception ex) {
        	/*//logger.info(
                    "Exception in getFormattedCurrentDateAndTime() method of DateAndTime Class "
                            + ex.getMessage(), ex);*/
            return null;
        }
        return formattedDateTime;
    }

	
}
