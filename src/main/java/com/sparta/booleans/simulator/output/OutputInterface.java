package com.sparta.booleans.simulator.output;

import com.sparta.booleans.simulator.model.DTO;

public interface OutputInterface {

     /**
      * @param simulationData  : A DTO object containing the reported simulation data.
      */
     void sendOutput(DTO simulationData);

}

