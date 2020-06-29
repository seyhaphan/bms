package com.kshrd.bms.rest.response;

public class ErrorResponse {
    private String Error;

    public ErrorResponse() {
    }

    public ErrorResponse(String Error) {
        this.Error = Error;
    }

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        this.Error = error;
    }
}
