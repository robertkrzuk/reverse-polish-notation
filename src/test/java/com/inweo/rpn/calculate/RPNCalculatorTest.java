package com.inweo.rpn.calculate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RPNCalculatorTest {

    private Calculator rpnCalculatorTest;

    private static final double DELTA = 0.000001;

    @Before
    public void setup() {
        rpnCalculatorTest = new RPNCalculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_empty_string_passed() {
        //when
        rpnCalculatorTest.calculate("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_null_passed() {
        //when
        rpnCalculatorTest.calculate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_no_operation_passed() {
        //when
        rpnCalculatorTest.calculate("5 5");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_throw_exception_if_unsupported_operation_passed() {
        //when
        rpnCalculatorTest.calculate("5 5 &");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_wrong_expression_passed() {
        //when
        rpnCalculatorTest.calculate("* 5 5");
    }

    @Test
    public void should_return_correct_response_if_correct_expression_passed() {
        //when
        double result = rpnCalculatorTest.calculate("5 5 +");

        //test
        assertEquals(result, 10, DELTA);
    }

    @Test
    public void should_return_correct_response_if_correct_expression_passed_2() {
        //when
        double result = rpnCalculatorTest.calculate("5 -6 +");

        //test
        assertEquals(result, -1, DELTA);
    }

    @Test
    public void should_return_correct_response_if_correct_expression_passed_3() {
        //when
        double result = rpnCalculatorTest.calculate("5 5.5 +");

        //test
        assertEquals(result, 10.5, DELTA);
    }

    @Test
    public void should_return_correct_response_if_correct_expression_passed_4() {
        //when
        double result = rpnCalculatorTest.calculate("5 6 -");

        //test
        assertEquals(result, -1, DELTA);
    }

    @Test
    public void should_return_correct_response_if_correct_expression_passed_5() {
        //when
        double result = rpnCalculatorTest.calculate("5 -5 -");

        //test
        assertEquals(result, 10, DELTA);
    }

    @Test
    public void should_return_correct_response_if_correct_expression_passed_6() {
        //when
        double result = rpnCalculatorTest.calculate("5 5.5 -");

        //test
        assertEquals(result, -0.5, DELTA);
    }

}