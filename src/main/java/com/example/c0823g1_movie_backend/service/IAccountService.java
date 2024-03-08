package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.AccountStatisticDTO;
import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.context.Context;

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
    Page<AccountStatisticDTO> getAccountStatistic(Pageable pageable);

    Optional<IAccountDTO> findByEmail(String email);

    void updatePasswordAndSendMail(Long id, String newPassword);

    boolean checkLoginByEmail(Account account);

    String getRoleUserEmail(Account account);

    Account findAccountById(Long accountId);

//    void registerAndSendMail(AccountDTO accountDTO);
    List<Account> getAllAccount();
    Account findAccountByAccountName(String accountName);
    Account findAccountByPhone(String phone);
    Account findAccountByEmail(String email);
    void sendEmailWithHtmlTemplate(String to, String subject, String templateName, Context context);
    void updateAccount(Account account, Long id);
    void updatePassword( String password ,String accountName);
    Account findAccountByPassword(String password);

}
