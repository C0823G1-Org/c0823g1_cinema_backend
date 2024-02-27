package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;

import java.util.Optional;

public interface IAccountService extends IGeneralService<Account>{
    boolean checkLogin(Account account);
    boolean checkLoginByFB(Account account);
    String getRoleUser(Account account);
    String getRoleUserFB(Account account);
    boolean checkLoginByGg(Account account);
    String getRoleUserGG(Account account);

    Optional<IAccountDTO> findByFacebookId(String facebookId);

    Optional<IAccountDTO> findByAccountName(String accountName);

    Optional<IAccountDTO> findByGoogleID(String googleId);
}
