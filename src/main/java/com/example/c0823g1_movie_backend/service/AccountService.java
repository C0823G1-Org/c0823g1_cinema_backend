package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.model.Role;
import com.example.c0823g1_movie_backend.repository.AccountRepository;
import com.example.c0823g1_movie_backend.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Account save(Account account) {
        Optional<Role> role = rolesRepository.findById(1L);
        if (role.isPresent()) {
            account.setRole(role.get());
        }
        return accountRepository.save(account);
    }

    @Override
    public Account create(Account account) {
        return null;
    }

    @Override
    public boolean checkLogin(Account account) {
        Optional<IAccountDTO> accountDTO = accountRepository.findByAccountNameDTO(account.getAccountName());
        if (!accountDTO.isPresent()) {
            return false;
        }
        if (passwordEncoder.matches(account.getPassword(), accountDTO.get().getPassword())) {
            System.out.println(account.getPassword());
            System.out.println(accountDTO.get().getPassword());
            return true;
        }
        return false;
    }

    @Override
    public boolean checkLoginByFB(Account account) {
        Optional<IAccountDTO> accountDTO = accountRepository.findByAccountNameDTOFB(account.getFacebookId());
        return accountDTO.isPresent();
    }

    @Override
    public String getRoleUser(Account account) {
        Optional<IAccountDTO> iAccountDTO = accountRepository.findByAccountNameDTO(account.getAccountName());
        return iAccountDTO.map(IAccountDTO::getRole).orElse(null);
    }

    @Override
    public String getRoleUserFB(Account account) {
        Optional<IAccountDTO> iAccountDTO = accountRepository.findByAccountNameDTOFB(account.getFacebookId());
        return iAccountDTO.map(IAccountDTO::getRole).orElse(null);
    }

    @Override
    public boolean checkLoginByGg(Account account) {
        Optional<IAccountDTO> iAccountDTO = accountRepository.findByAccountNameDTOGG(account.getGoogleId());
        return iAccountDTO.isPresent();
    }

    @Override
    public String getRoleUserGG(Account account) {
        Optional<IAccountDTO> iAccountDTO = accountRepository.findByAccountNameDTOGG(account.getGoogleId());
        return iAccountDTO.map(IAccountDTO::getRole).orElse(null);
    }

    @Override
    public Optional<IAccountDTO> findByFacebookId(String facebookId) {
        return accountRepository.findByAccountNameDTOFB(facebookId);
    }

    @Override
    public Optional<IAccountDTO> findByAccountName(String accountName) {
        return accountRepository.findByAccountNameDTO(accountName);
    }

    @Override
    public Optional<IAccountDTO> findByGoogleID(String googleId) {
        return accountRepository.findByAccountNameDTOGG(googleId);
    }

    @Override
    public List<Account> getAccountStatistic() {
        return null;
    }
}