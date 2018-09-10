package com.inweo.rpn;

import com.inweo.rpn.handler.SystemPrintResponseHandler;
import com.inweo.rpn.provider.CommandLineDataProvider;

public class ReversePolishNotation {

    public static void main(String args[]) {

        if (args.length > 0) {
            ReversePolishNotationService reversePolishNotationService = new ReversePolishNotationService(new CommandLineDataProvider(), new SystemPrintResponseHandler());

            reversePolishNotationService.handleExpression(args[0]);
        }
    }
}
