package com.sparta.booleans.model;

import com.sparta.booleans.model.Client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientTest {
    private Client newClient = new Client(0, 0);
    @Test
    @DisplayName("Testing a requirement can be generated")
    void testGenerateRequirement(){
        newClient.generateRequirement(0, 0, 100);
        Assertions.assertEquals(1, newClient.getRequiredSkills().size());
    }
    private Client anotherClient;
    @Test
    @DisplayName("Testing a new requirement is made")
    void testRenewRequirement(){
        anotherClient = new Client(0, 0);
        anotherClient.generateRequirement(0, 0, 100);
        anotherClient.renewRequirement(1, 0);
        Assertions.assertEquals(2, anotherClient.getRequiredSkills().size());
    }


}

//should leave
//assign trainee?