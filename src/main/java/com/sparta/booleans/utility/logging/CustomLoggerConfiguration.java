package com.sparta.booleans.utility.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomLoggerConfiguration {

    public static final Logger myLogger = Logger.getLogger("mylogger");
    private static CustomLoggerConfiguration instance = null;

    public static CustomLoggerConfiguration getInstance() {
        if (instance == null) {
            getCustomLoggerConfiguration(myLogger);
            instance = new CustomLoggerConfiguration();
        }
        return instance;
    }

    public static void getCustomLoggerConfiguration(Logger logger) {
        logger.setUseParentHandlers(false);
        logger.addHandler(CustomFileHandler.getFileHandler());
        logger.setLevel(Level.ALL);
    }
}
