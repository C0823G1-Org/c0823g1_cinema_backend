package com.example.c0823g1_movie_backend.dto;

public class TokenDTO {
    private String value;

    public TokenDTO(String value) {
        this.value = value;
    }

    public TokenDTO() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
