package com.inweo.rpn.provider;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommandLineDataProviderTest {

    CommandLineDataProvider underTest = new CommandLineDataProvider();

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_null_argument_passed_test() {
        //when
        underTest.provide(null);
    }

    @Test
    public void should_return_one_expression_if_empty_string_passed_test() {
        //when
        List<String> result = underTest.provide("");

        //when
        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }

    @Test
    public void should_return_one_expression_if_one_expression_passed_test() {
        //given
        String INPUT_PARAM = "5 5 +";

        //when
        List<String> result = underTest.provide(INPUT_PARAM);

        //when
        assertEquals(1, result.size());
        assertEquals(INPUT_PARAM, result.get(0));
    }

    @Test
    public void should_return_two_expression_if_advanced_expression_passed_test() {
        //given
        String INPUT_PARAM = "5 5 +;5 7 -";

        //when
        List<String> result = underTest.provide(INPUT_PARAM);

        //when
        assertEquals(2, result.size());
        assertEquals("5 5 +", result.get(0));
        assertEquals("5 7 -", result.get(1));
    }


}