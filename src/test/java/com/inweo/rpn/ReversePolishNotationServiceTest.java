package com.inweo.rpn;

import com.inweo.rpn.handler.SystemPrintResponseHandler;
import com.inweo.rpn.provider.CommandLineDataProvider;
import org.junit.Test;

public class ReversePolishNotationServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_data_provider_and_response_handler_are_null() {
        new ReversePolishNotationService(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_data_provider_is_null() {
        new ReversePolishNotationService(null, new SystemPrintResponseHandler());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_response_handler_is_null() {
        new ReversePolishNotationService(new CommandLineDataProvider(), null);
    }
}