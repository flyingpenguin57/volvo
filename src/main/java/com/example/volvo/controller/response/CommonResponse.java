package com.example.volvo.controller.response;

public class CommonResponse<T> {
    private boolean success;
    private String errorMessage;
    private T data;

    public static CommonResponse<?> ok() {
        CommonResponse<?> commonResponse = new CommonResponse<>();
        commonResponse.setSuccess(true);
        return commonResponse;
    }

    public static <T> CommonResponse<T> ok(T data) {
        CommonResponse<T> commonResponse = new CommonResponse<>();
        commonResponse.setSuccess(true);
        commonResponse.setData(data);
        return commonResponse;
    }

    public static CommonResponse<?> error(String message) {
        CommonResponse<?> commonResponse = new CommonResponse<>();
        commonResponse.setSuccess(false);
        commonResponse.setErrorMessage(message);
        return commonResponse;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
