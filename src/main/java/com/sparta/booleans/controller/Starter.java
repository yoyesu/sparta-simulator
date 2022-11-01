package com.sparta.booleans.controller;

import com.sparta.booleans.model.DTO;
import com.sparta.booleans.utility.logging.CustomLoggerConfiguration;
import com.sparta.booleans.view.CSVWriter;
import com.sparta.booleans.view.OutputToConsole;
import com.sparta.booleans.view.input.TimeFrameInputter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Starter {

    public void start() {


        // This customises the log , instance is not used.
       CustomLoggerConfiguration startLoggerConfig = CustomLoggerConfiguration.getInstance();


        Logger logger = CustomLoggerConfiguration.myLogger;

        logger.log(Level.INFO, " The simulation has starter");

        TimeFrameInputter imputter = new TimeFrameInputter();

        DTO currentDTO = Simulator.runSimulation(imputter.getTotalMonths());

        logger.log(Level.INFO, " The simulation has completed");

        OutputToConsole outputter = new OutputToConsole();
        outputter.outPutter(currentDTO);
        CSVWriter writer = new CSVWriter();

        writer.sendOutput(currentDTO);
        writer.writeToFile();

        logger.log(Level.INFO, " The CSV Report is ready in the resources folder");

    }
}
