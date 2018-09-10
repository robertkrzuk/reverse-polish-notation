package com.inweo.rpn.provider;

import java.util.List;

public interface DataProvider {
    List<String> provide(String inputExpression);
}
