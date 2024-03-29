package com.example.c0823g1_movie_backend.dto;


import java.time.LocalDate;

public interface IAccountDTO {
    Long getId();
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
    String getPhoneNumber();
    String getProfilePicture();
}
