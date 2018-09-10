package com.inweo.rpn.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringDoubleUtilsTest {

    private static final double DELTA = 0.000001;

    @Test
    public void should_detect_proper_double() {
        //test
        assertTrue(StringDoubleUtils.isProperDouble("5"));
    }

    @Test
    public void should_detect_proper_double_2() {
        //test
        assertTrue(StringDoubleUtils.isProperDouble("5.5"));
    }

    @Test
    public void should_detect_incorrect_double() {
        //test
        assertFalse(StringDoubleUtils.isProperDouble("x"));
    }

    @Test
    public void should_detect_incorrect_double_2() {
        //test
        assertFalse(StringDoubleUtils.isProperDouble(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_null_passed() {
        //when
        StringDoubleUtils.convert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_empty_string_passed() {
        //when
        StringDoubleUtils.convert("");
    }

    @Test
    public void should_convert_string_to_double_correctly() {
        //test
        assertEquals(5, StringDoubleUtils.convert("5"), DELTA);
    }

    @Test
    public void should_convert_string_to_double_correctly_2() {
        //test
        assertEquals(5.7, StringDoubleUtils.convert("5.7"), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_convert_string_to_double_correctly_3() {
        //when
        StringDoubleUtils.convert("5,7");
    }

    @Test
    public void should_convert_string_to_double_correctly_4() {
        //test
        assertEquals(-5.7, StringDoubleUtils.convert("-5.7"), DELTA);
    }


}