package com.example.c0823g1_movie_backend.config;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountInforAccountDetailService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Optional<IAccountDTO> iAccountDTO = accountRepository.findByAccountNameDTO(accountName);
        System.out.println(iAccountDTO.get().getEmail());
        return iAccountDTO.map(AccountInfoAccountDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found: " + accountName));
    }
}
