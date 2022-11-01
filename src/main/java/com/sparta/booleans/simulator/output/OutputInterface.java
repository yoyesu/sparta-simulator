package com.sparta.booleans.simulator.output;

import java.util.Map;

public interface OutputInterface {

     /**
      * @param simulationData  : A Map with String key "Data Name" and Integer value for the data.
      */
     void sendOutput(Map<String, Integer> simulationData);

}

