package com.inweo.rpn.handler;

import com.inweo.rpn.model.RPNResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SystemPrintResponseHandlerTest {

    private SystemPrintResponseHandler underTest = new SystemPrintResponseHandler();

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreDefaults() {
        System.setOut(System.out);
    }

    @Test
    public void should_print_success_message() {
        //when
        underTest.handle(prepareSuccessResult());

        //test
        assertEquals("Result for expression: InputExpression is 5.67", outContent.toString());
    }

    @Test
    public void should_print_error_message() {
        //when
        underTest.handle(prepareErrorResult());

        //test
        assertEquals("Error. For expression: InputExpression, error message: ErrorMessage", outContent.toString());
    }

    private RPNResult prepareSuccessResult() {
        RPNResult result = new RPNResult("InputExpression");

        result.setResult(5.67);

        return result;
    }

    private RPNResult prepareErrorResult() {
        RPNResult result = prepareSuccessResult();

        result.setException(new Exception("ErrorMessage"));

        return result;
    }
}