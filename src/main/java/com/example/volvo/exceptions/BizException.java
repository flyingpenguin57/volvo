package com.example.volvo.exceptions;

public class BizException extends RuntimeException{
    private BizError bizError;

    public BizError getBizError() {
        return bizError;
    }

    public void setBizError(BizError bizError) {
        this.bizError = bizError;
    }

    public BizException(BizError bizError) {
        this.bizError = bizError;
    }
}
