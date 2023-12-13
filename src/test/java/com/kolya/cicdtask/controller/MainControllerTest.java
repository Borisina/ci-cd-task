package com.kolya.cicdtask.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainControllerTest {

    @Test
    void parseNum() {
        MainController controller = new MainController();
        String[] numStrArr = {"4", "14", "0", "-2", "-104","007", "-00005"};
        int[] expectedResult = {4, 14, 0, -2, -104,7,-5};
        for (int i=0; i< numStrArr.length;i++){
            int actualResult = controller.parseNum(numStrArr[i]);
            Assertions.assertEquals(expectedResult[i],actualResult);
        }
    }

    @Test()
    void parseNumWithExceptions() {
        MainController controller = new MainController();
        String[] numStrArr = {"", "w", "hello", "2j", "k08","-34y"};
        for (int i=0; i< numStrArr.length;i++){
            int ind = i;
            Assertions.assertThrows(
                    NumberFormatException.class,
                    () -> controller.parseNum(numStrArr[ind])
            );
        }
    }

    @Test
    void createStr() {
        MainController controller = new MainController();
        int[] aArr = {1,2,3};
        int[] bArr = {2,0,-6};
        int[] result = {3,2,-3};
        String[] expected = {"1+2=3", "2+0=2", "3-6=-3"};
        for (int i=0; i< aArr.length;i++){
            String actualResult = controller.createStr(aArr[i],bArr[i],result[i]);
            Assertions.assertEquals(expected[i],actualResult);
        }
    }
}