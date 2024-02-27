package com.example.c0823g1_movie_backend.model;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;

public class LoginSuccess {
    private String accessToken;
    private String roleUser;
    private IAccountDTO iAccountDTO;

    public LoginSuccess(String accessToken, String roleUser, IAccountDTO iAccountDTO) {
        this.accessToken = accessToken;
        this.roleUser = roleUser;
        this.iAccountDTO = iAccountDTO;
    }

    public LoginSuccess() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public IAccountDTO getiAccountDTO() {
        return iAccountDTO;
    }

    public void setiAccountDTO(IAccountDTO iAccountDTO) {
        this.iAccountDTO = iAccountDTO;
    }
}
