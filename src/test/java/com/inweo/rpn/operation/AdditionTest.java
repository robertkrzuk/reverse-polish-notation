package com.inweo.rpn.operation;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class AdditionTest {

    private Addition underTest = new Addition();

    private static final double DELTA = 0.000001;

    @Test
    public void should_applies_correctly_test() {
        //test
        assertTrue(underTest.applies("+"));
    }

    @Test
    public void should_applies_fails_test() {
        //test
        assertFalse(underTest.applies("-"));
    }


    @Test
    public void should_applies_fails_test_2() {
        //test
        assertFalse(underTest.applies("x"));
    }

    @Test
    public void should_correct_calculate_result() {
        //when
        double result = underTest.result(1, 1);

        //test
        Assert.assertEquals(2, result, DELTA);
    }

    @Test
    public void should_correct_calculate_result_2() {
        //when
        double result = underTest.result(1, 7);

        //test
        Assert.assertEquals(8, result, DELTA);
    }

}