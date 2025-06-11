package com.example.volvo.exceptions;

public enum BizError {
    AccountEmailExist("0001", "email already exits!"),
    EmailNotExist("0002", "email not exist!"),
    CardNotExist("0003", "card not exist!");
    ;

    private String errorCode;
    private String errorMessage;

    BizError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
