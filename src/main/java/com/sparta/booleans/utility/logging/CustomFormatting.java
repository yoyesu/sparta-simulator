package com.sparta.booleans.utility.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatting extends Formatter {

    @Override
    public String format(LogRecord record) {
        return (LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                + " " + record.getSourceClassName().substring(record.getSourceClassName().lastIndexOf(".") + 1)
                + " " + record.getSourceMethodName()
                + " " + record.getLevel()
                + " " + record.getMessage()
                + "\n";
    }
}
