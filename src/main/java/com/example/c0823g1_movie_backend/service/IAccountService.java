package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService extends IGeneralService<Account>{
    Account getLastUser();
    Account getAllInfoUser(String name);
    List<Account> getAllAccountName();
    void register (Account account,Long role);
    boolean checkLogin(Account account);
    boolean checkLoginByFB(Account account);
    String getRoleUser(Account account);
    String getRoleUserFB(Account account);
    boolean checkLoginByGg(Account account);
    String getRoleUserGG(Account account);

    void register(Account account);

    Optional<IAccountDTO> findByFacebookId(String facebookId);

    Optional<IAccountDTO> findByAccountName(String accountName);

    Optional<IAccountDTO> findByGoogleID(String googleId);

    Optional<IAccountDTO> findByEmail(String email);

    void updatePasswordAndSendMail(Long id, String newPassword);

    boolean checkLoginByEmail(Account account);

    String getRoleUserEmail(Account account);
}
