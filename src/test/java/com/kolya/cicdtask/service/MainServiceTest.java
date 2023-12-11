package com.kolya.cicdtask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainServiceTest {

    @Test
    void getSum() {
        MainService service = new MainService();
        int[] aArray = {1,15,103,-1,0,0, -15};
        int[] bArray = {3,-7,218,9,0, 7, -14};
        int[] expectedResults = {4, 8, 321, 8,0,7,-29};
        for (int i=0; i<aArray.length; i++){
            int actualResult = service.getSum(aArray[i],bArray[i]);
            Assertions.assertEquals(expectedResults[i],actualResult);
        }
    }
}