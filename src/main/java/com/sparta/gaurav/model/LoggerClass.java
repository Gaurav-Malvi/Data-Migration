package com.sparta.gaurav.model;

import com.sparta.gaurav.view.DataMigrationMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerClass {

    private static final Logger logger = LogManager.getLogger(DataMigrationMain.class);

    public static void logTrace(String message){
        logger.trace(message);
    }
    public static void logError(String message){
        logger.error(message);
    }
}
