package com.kshrd.bms.rest.response;

public class BaseApiResponse<T> {

    private T data;
    private String message;
    private boolean status;

    public BaseApiResponse() {
    }

    public BaseApiResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public BaseApiResponse(T data, String message, boolean status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
