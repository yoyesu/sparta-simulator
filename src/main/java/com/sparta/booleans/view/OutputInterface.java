package com.sparta.booleans.view;

import com.sparta.booleans.model.MappedDTO;

public interface OutputInterface {

     /**
      * @param simulationData  : A DTO object containing the reported simulation data.
      */
     void sendOutput(MappedDTO simulationData);

}

