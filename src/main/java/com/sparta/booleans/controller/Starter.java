package com.sparta.booleans.controller;

import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.utility.logging.CustomLoggerConfiguration;
import com.sparta.booleans.view.CSVWriter;
import com.sparta.booleans.view.OutputToConsole;
import com.sparta.booleans.view.input.Inputable;
import com.sparta.booleans.view.input.TimeFrameInputter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Starter {

    public void start() {

        // This customises the log , instance is not used.
       CustomLoggerConfiguration startLoggerConfig = CustomLoggerConfiguration.getInstance();

        Logger logger = CustomLoggerConfiguration.myLogger;

        logger.log(Level.INFO, " The simulation has started");

        // Start interface
        Inputable inputter = new TimeFrameInputter();

        int months = inputter.getTotalMonths();
        int choice = inputter.getOutputChoice();

        int frequency = choice == 1 ? months/12 : 1;
        CSVWriter writer = new CSVWriter();
        OutputToConsole outputter = new OutputToConsole();
        logger.log(Level.INFO, "The client has chosen to run the simulation for " + months/12 + " years");


        for (int i = 0 ; i < frequency; i++) {
            MappedDTO currentDTO = Simulator.runSimulation(choice == 1 ? 12 : months);
            outputter.sendOutput(currentDTO);
            writer.sendOutput(currentDTO);

        }

        writer.writeToFile();
        logger.log(Level.INFO, " The simulation has completed");

        logger.log(Level.INFO, " The CSV Report is ready in the resources folder with " + writer.getCSV_FILE_NAME());

    }
}
