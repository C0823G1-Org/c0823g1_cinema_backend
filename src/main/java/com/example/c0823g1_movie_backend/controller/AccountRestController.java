package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.AccountDTO;
import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.model.LoginSuccess;
import com.example.c0823g1_movie_backend.model.Role;
import com.example.c0823g1_movie_backend.service.IAccountService;
import com.example.c0823g1_movie_backend.service.IRoleService;
import com.example.c0823g1_movie_backend.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountRestController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IRoleService iRoleService;

    @PostMapping("/login")
    public ResponseEntity<LoginSuccess> login(HttpServletRequest request, @RequestBody Account account) {
        String accessToken = "";
        String roleUser = "";
        HttpStatus httpStatus = null;
        LoginSuccess loginSuccess;
        try {
            if (iAccountService.checkLogin(account)) {
                roleUser = iAccountService.getRoleUser(account);
                accessToken = jwtService.generateTokenLogin(account.getAccountName());
                Optional<IAccountDTO> iAccountDTO = iAccountService.findByAccountName(account.getAccountName());
                if (!iAccountDTO.isPresent()){
                    httpStatus = HttpStatus.BAD_REQUEST;
                    return new ResponseEntity<>(httpStatus);
                }
                loginSuccess = new LoginSuccess(accessToken, roleUser,iAccountDTO.get());
                httpStatus = HttpStatus.OK;
                return new ResponseEntity<LoginSuccess>(loginSuccess, httpStatus);
            } else {
                httpStatus = HttpStatus.BAD_REQUEST;
                return new ResponseEntity<>(httpStatus);
            }
        } catch (Exception ex) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }
//
    @PostMapping("/login-by-fb")
    public ResponseEntity<LoginSuccess> loginByFacebook(HttpServletRequest request, @RequestBody Account account) {
        String accessToken = "";
        String roleUser = "";
        LoginSuccess loginSuccess;
        HttpStatus httpStatus = null;
        createAccountFB(account);
        try {
            if (iAccountService.checkLoginByFB(account)) {
                roleUser = iAccountService.getRoleUserFB(account);
                accessToken = jwtService.generateTokenLogin(account.getAccountName());
                Optional<IAccountDTO> iAccountDTO = iAccountService.findByFacebookId(account.getFacebookId());
                if (!iAccountDTO.isPresent()){
                    httpStatus = HttpStatus.BAD_REQUEST;
                    return new ResponseEntity<>(httpStatus);
                }
                if (iAccountDTO.get().getIsDeleted()){
                    httpStatus = HttpStatus.BAD_REQUEST;
                    return new ResponseEntity<>(httpStatus);
                }
                loginSuccess = new LoginSuccess(accessToken, roleUser, iAccountDTO.get());
                httpStatus = HttpStatus.OK;
                return new ResponseEntity<LoginSuccess>(loginSuccess, httpStatus);
            } else {
                httpStatus = HttpStatus.BAD_REQUEST;
                return new ResponseEntity<>(httpStatus);
            }
        } catch (Exception ex) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }

    @PostMapping("/login-by-gg")
    public ResponseEntity<LoginSuccess> loginByGoogle(HttpServletRequest request, @RequestBody Account account) {
        String accessToken = "";
        String roleUser = "";
        LoginSuccess loginSuccess;
        HttpStatus httpStatus = null;
        createAccountGG(account);
        try {
            if (iAccountService.checkLoginByGg(account)) {
                roleUser = iAccountService.getRoleUserGG(account);
                accessToken = jwtService.generateTokenLogin(account.getAccountName());
                Optional<IAccountDTO> iAccountDTO = iAccountService.findByGoogleID(account.getGoogleId());
                if (!iAccountDTO.isPresent()){
                    httpStatus = HttpStatus.BAD_REQUEST;
                    return new ResponseEntity<>(httpStatus);
                }
                if (iAccountDTO.get().getIsDeleted()){
                    httpStatus = HttpStatus.BAD_REQUEST;
                    return new ResponseEntity<>(httpStatus);
                }
                loginSuccess = new LoginSuccess(accessToken, roleUser,iAccountDTO.get());
                httpStatus = HttpStatus.OK;
                return new ResponseEntity<LoginSuccess>(loginSuccess, httpStatus);
            } else {
                httpStatus = HttpStatus.BAD_REQUEST;
                return new ResponseEntity<>(httpStatus);
            }
        } catch (Exception ex) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(httpStatus);
    }

    private void createAccountGG(Account account) {
        if(!iAccountService.checkLoginByGg(account)){
            account.setAccountName(account.getEmail());
            iAccountService.save(account);
        }
    }
    private void createAccountFB(Account account) {
        if(!iAccountService.checkLoginByFB(account)){
           if (Objects.equals(account.getEmail(), "")){
               account.setAccountName(account.getFacebookId());
           } else {
               account.setAccountName(account.getEmail());
           }
            iAccountService.save(account);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<Account> createAccount(@RequestBody @Valid AccountDTO accountDTO , BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            Account account = new Account();
            BeanUtils.copyProperties(accountDTO,account);
            Account account1 = iAccountService.getLastUser();
            account.setPoint(0);
            int randomMemberCode = 1;
            account.setMemberCode("TV-" + account1.getMemberCode());
            iAccountService.register(account, 2L);
            System.out.println("Success");
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
    @GetMapping("/detailUser")
    public ResponseEntity<Account> detailAccountUser(){
        Account account1 = iAccountService.getAllInfoUser("tuan12345");
        return new ResponseEntity<>(account1,HttpStatus.OK);
    }


}
