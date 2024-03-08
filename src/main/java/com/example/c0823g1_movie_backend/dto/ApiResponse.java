package com.example.c0823g1_movie_backend.dto;

public class ApiResponse <T>{
    private String flag;
    private T data;
    private String base64;

    public ApiResponse() {
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(String flag) {
        this.flag = flag;
    }

    public ApiResponse(String flag, T data) {
        this.flag = flag;
        this.data = data;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
