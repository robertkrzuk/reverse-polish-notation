package com.inweo.rpn.utils;

public class StringDoubleUtils {

    public static double convert(String input) {
        if (isProperDouble(input)) {
            return Double.valueOf(input);
        }

        throw new IllegalArgumentException("Unable to convert input to Double");
    }

    public static boolean isProperDouble(String input) {

        try {

            if (input != null) {
                Double.valueOf(input);

                return true;
            }

        } catch (NumberFormatException exception) {
            return false;
        }

        return false;
    }
}
