package com.example.c0823g1_movie_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public interface IAccountDTO {
    Integer getId();

    String getAccountName();
    String getAddress();
    LocalDate getBirthday();
    String getEmail();
    Boolean getGender();
    String getIdNumber();
    Boolean getIsDeleted();
    String getMemberCode();

    String getFullName();
    String getPassword();

    String getRole();
    String getFacebookId();
    String getGoogleId();
}
