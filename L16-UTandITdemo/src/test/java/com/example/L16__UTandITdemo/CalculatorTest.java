package com.example.L16__UTandITdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }


    @Test
    public void testAddPositiveNum(){
        Integer a = 4;
        Integer b = 3;
        Integer expected = a+b;
        assertThat(calculator.add(a,b)).isEqualTo(expected);
    }

    @Test
    public void testAddNegativeNum(){
        Integer a = -4;
        Integer b = -3;
        Integer expected = a+b;
        assertThat(calculator.add(a,b)).isEqualTo(expected);
    }

    @Test
    public void testMultiply(){
        Integer a = 4;
        Integer b = 3;
        Integer expected = a*b;
        assertThat(calculator.multiply(a,b)).isEqualTo(expected);
    }

}
