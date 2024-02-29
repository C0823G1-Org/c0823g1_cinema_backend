package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.AccountStatisicDTO;
import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IAccountService extends IGeneralService<Account>{
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
    Page<AccountStatisicDTO> getAccountStatistic(Pageable pageable);

    Optional<IAccountDTO> findByEmail(String email);

    void updatePasswordAndSendMail(Long id, String newPassword);

    boolean checkLoginByEmail(Account account);

    String getRoleUserEmail(Account account);
}
