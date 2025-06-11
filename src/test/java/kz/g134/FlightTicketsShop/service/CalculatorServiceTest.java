package kz.g134.FlightTicketsShop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    private CalculatorService calculatorService=new CalculatorService();

    @Test
    void addTest(){
        Assertions.assertEquals(calculatorService.add(5,3),8);
    }

    @Test
    void multipleTest(){
        Assertions.assertEquals(calculatorService.multiple(5,3),15);
    }

    @Test
    void divideTest(){
        Assertions.assertEquals(calculatorService.divide(10,5),2);
        Assertions.assertThrows(ArithmeticException.class,()->{
            calculatorService.divide(10,0);
        });
    }

}
