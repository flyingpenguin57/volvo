package com.example.volvo.utils;

import com.example.volvo.exceptions.BizError;
import com.example.volvo.exceptions.BizException;

public class AssertUtil {
    public static void isNull(Object o, BizError e) throws Exception {
        if (o != null) {
            throw new BizException(e);
        }
    }

    public static void notNull(Object o, BizError e) {
        if (o == null) {
            throw new BizException(e);
        }
    }
}
