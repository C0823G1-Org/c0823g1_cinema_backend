package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.model.LoginSuccess;
import com.example.c0823g1_movie_backend.service.IAccountService;
import com.example.c0823g1_movie_backend.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountRestController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IAccountService iAccountService;

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
                if (!iAccountDTO.isPresent()) {
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
                if (!iAccountDTO.isPresent()) {
                    httpStatus = HttpStatus.BAD_REQUEST;
                    return new ResponseEntity<>(httpStatus);
                }
                if (iAccountDTO.get().getIsDeleted()) {
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
                if (!iAccountDTO.isPresent()) {
                    httpStatus = HttpStatus.BAD_REQUEST;
                    return new ResponseEntity<>(httpStatus);
                }
                if (iAccountDTO.get().getIsDeleted()) {
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

    @PostMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(HttpServletRequest request, @RequestBody Account account) {
        System.out.println(account.getEmail());
        Optional<IAccountDTO> iAccountDTO = iAccountService.findByEmail(account.getEmail());
        if (!iAccountDTO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String newPassword = generateRandomString();
        iAccountService.updatePasswordAndSendMail(iAccountDTO.get().getId(), newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login-email")
    public ResponseEntity<LoginSuccess> loginByEmail(HttpServletRequest request, @RequestBody Account account) {
        String accessToken = "";
        String roleUser = "";
        LoginSuccess loginSuccess;
        HttpStatus httpStatus = null;
        try {
            if (iAccountService.checkLoginByEmail(account)) {
                roleUser = iAccountService.getRoleUserEmail(account);
                Optional<IAccountDTO> iAccountDTO = iAccountService.findByEmail(account.getEmail());
                if (!iAccountDTO.isPresent()) {
                    httpStatus = HttpStatus.BAD_REQUEST;
                    return new ResponseEntity<>(httpStatus);
                }
                accessToken = jwtService.generateTokenLogin(iAccountDTO.get().getAccountName());
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

    private void createAccountGG(Account account) {
        if (!iAccountService.checkLoginByGg(account)) {
            account.setAccountName(account.getEmail());
            iAccountService.register(account);
        }
    }

    private void createAccountFB(Account account) {
        if (!iAccountService.checkLoginByFB(account)) {
            if (Objects.equals(account.getEmail(), "")) {
                account.setAccountName(account.getFacebookId());
            } else {
                account.setAccountName(account.getEmail());
            }
            iAccountService.register(account);
        }
    }
    private String generateRandomString() {
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }
}
