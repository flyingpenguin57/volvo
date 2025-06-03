package com.example.volvo.utils;

import com.example.volvo.exceptions.BusinessException;

public class AssertUtil {
    public static void isNull(Object o, BusinessException e) throws Exception {
        if (o != null) {
            throw new RuntimeException(e.getErrorMessage());
        }
    }

    public static void notNull(Object o, BusinessException e) {
        if (o == null) {
            throw new RuntimeException(e.getErrorMessage());
        }
    }
}
