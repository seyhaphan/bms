package com.kshrd.bms.rest.response;

import com.kshrd.bms.utilities.Pagination;

public class BaseApiResponse<T> {

    private Pagination pagination;
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

    public BaseApiResponse(Pagination pagination, T data, String message, boolean status) {
        this.pagination = pagination;
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
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
