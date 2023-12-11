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
}