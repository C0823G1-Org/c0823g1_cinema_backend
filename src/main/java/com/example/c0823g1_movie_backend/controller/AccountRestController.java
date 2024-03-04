package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.AccountDTO;
import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.model.ChangePasswordDto;
import com.example.c0823g1_movie_backend.model.LoginSuccess;
import com.example.c0823g1_movie_backend.model.Role;
import com.example.c0823g1_movie_backend.service.IAccountService;
import com.example.c0823g1_movie_backend.service.IRoleService;
import com.example.c0823g1_movie_backend.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.*;

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
    @Autowired
    private PasswordEncoder passwordEncoder;

    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: Receive account information (accountName and password) and check account information
     * @return HttpStatus.BAD_REQUEST if account not found/ access token,role user, account information and HttpStatus.OK if account information is accurate/
     * HttpStatus.INTERNAL_SERVER_ERROR if server error
     */
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

    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: Receive account information (fullName, facebookId, profilePicture, email) and check account information.
     * If account not found create new account.
     * @return HttpStatus.BAD_REQUEST if account has been locked/ access token,role user, account information and HttpStatus.OK if account information is accurate/
     * HttpStatus.INTERNAL_SERVER_ERROR if server error
     */
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

    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: Receive account information (fullName, googleId, profilePicture, email, phoneNumber) and check account information.
     * If account not found create new account.
     * @return HttpStatus.BAD_REQUEST if account has been locked/ access token,role user, account information and HttpStatus.OK if account information is accurate/
     * HttpStatus.INTERNAL_SERVER_ERROR if server error
     */
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

    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: Receive account information (email) and check account information.
     * If account found create an automatic password and update the account then send a notification email to the user.
     * @return HttpStatus.BAD_REQUEST if account not found/ HttpStatus.OK if account is found
     */
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

    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: Receive account information (email and password) and check account information
     * @return HttpStatus.BAD_REQUEST if account not found/ access token,role user, account information and HttpStatus.OK if account information is accurate/
     * HttpStatus.INTERNAL_SERVER_ERROR if server error
     */
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

    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: Receive account information and check account information
     * If account not found create new account.
     */
    private void createAccountGG(Account account) {
        if (!iAccountService.checkLoginByGg(account)) {
            account.setAccountName(account.getEmail());
            iAccountService.register(account);
        }
    }

    /* Create by: TuanTA
     * Date created: 29/02/2024
     * Function: Register New account
     * @Return HttpStatus.BAD_REQUEST If the account creation information is wrong with the format / HttpStatus.OK If the data fields are correct
     */
    @PostMapping("/register")
    public ResponseEntity<?> createAccount(HttpServletRequest request, @RequestBody @Valid AccountDTO accountDTO , BindingResult bindingResult){
        Map<String,String> listError = new HashMap<>();
        if (bindingResult.hasFieldErrors()){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            if (iAccountService.findAccountByEmail(accountDTO.getEmail()) != null){
                      listError.put("email","Email Đã Tồn Tại");
            }
            if (iAccountService.findAccountByPhone(accountDTO.getPhoneNumber()) != null){
                listError.put("phoneNumber","Số Điện Thoại Đã Tồn Tại");
            }
            if (iAccountService.findAccountByAccountName(accountDTO.getAccountName()) != null){
                listError.put("accountName","Tài Khoản Đã Tồn Tại");
            }
            if (listError.size() > 0){
                return new ResponseEntity<>(listError,HttpStatus.BAD_REQUEST);
            }
//            String to = accountDTO.getEmail();
//            String subject = "[C0823G1-Cinema]-Phản hồi yêu cầu cấp lại mật khẩu tài khoản";
//            String templateName = "email-register";
//            org.thymeleaf.context.Context context = new  org.thymeleaf.context.Context();
//            String randomCode = RandomStringUtils.random(6,true,true);
//            System.out.println(randomCode);
//            context.setVariable("fullName",accountDTO.getFullName());
//            context.setVariable("account",accountDTO.getAccountName());
//            context.setVariable("password",accountDTO.getPassword());
//            context.setVariable("randomCode",randomCode);
//            iAccountService.sendEmailWithHtmlTemplate(to,subject,templateName,context);
//            if (!accountDTO.getVerificationCode().equals(randomCode)){
//                listError.add("Mã Xác Nhận không đúng");
//            }
            String encode = passwordEncoder.encode(accountDTO.getPassword());
            Account account = new Account();
            BeanUtils.copyProperties(accountDTO,account);
            account.setPassword(encode);
            Account account1 = iAccountService.getLastUser();
            account.setPoint(0);
            int memberCode = Integer.parseInt(account1.getMemberCode());
            account.setMemberCode(String.valueOf(memberCode + 1));
            iAccountService.register(account, 2L);
            System.out.println("Success");
            return new ResponseEntity<>(account, HttpStatus.OK);
        }

    }
    /* Create by: TuanTA
     * Date created: 29/02/2024
     * Function: Show Detail User Account
     * @Return HttpStatus.NO_CONTENT if userName of User is Null , @Return HttpStatus.OK if userName of User is not Null
     */
    @GetMapping("/detailUser")
    public ResponseEntity<Account> detailAccountUser(Principal principal){
        if (principal.getName() == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Account account1 = iAccountService.getAllInfoUser(principal.getName());
        return new ResponseEntity<>(account1,HttpStatus.OK);
    }
    /* Create by: TuanTA
     * Date created: 29/02/2024
     * Function: Change Infor Of User Account
     * @Return HttpStatus.BAD_REQUEST If the account creation information is wrong with the format / HttpStatus.OK If the data fields are correct
     */
    @PatchMapping("/changeInfoUser")
    public ResponseEntity<?> changeInfoUserAccount(@Valid @RequestBody AccountDTO accountDTO , BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            Account account = new Account();
            BeanUtils.copyProperties(accountDTO,account);
            iAccountService.updateAccount(account,account.getId());
            return new ResponseEntity<>(account,HttpStatus.OK);
        }

    }
    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: Receive account information and check account information
     * If account not found create new account.
     */
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

    /* Create by: BaoNDT
     * Date created: 29/02/2024
     * Function: generated random new password
     */
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

    /* Create by: TuanTA
     * Date created: 29/02/2024
     * Function: Change Password
     * @Return HttpStatus.BAD_REQUEST If the current password is not the same as the current password input and If the new password is not the same as confirming the password
     * HttpStatus.OK if the current password is the same as the current password in the input field and the new password is the same as the new password confirmation
     */
    @PatchMapping("/changePassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDto changePasswordDto,BindingResult bindingResult,Principal principal){
        List<String> listErrors = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        changePasswordDto.setAccounts(accounts);
        changePasswordDto.validate(changePasswordDto,bindingResult);
        if (bindingResult.hasErrors()){
            for (FieldError error : bindingResult.getFieldErrors()){
                listErrors.add(error.getDefaultMessage());
            }
            return new ResponseEntity<>(listErrors,HttpStatus.BAD_REQUEST);
        }
       Account account = iAccountService.findAccountByAccountName("tuan123456");
        if (account.getPassword().equals(changePasswordDto.getCurrentPassword())){
            account.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
            iAccountService.updatePassword(account.getPassword(),principal.getName());
            return new ResponseEntity<>("Đổi Mật Khẩu Thành Công",HttpStatus.OK);
        }else {
            listErrors.add("Mật Khẩu Hiện Tại Không Đúng");
            return new ResponseEntity<>(listErrors,HttpStatus.BAD_REQUEST);
        }
    }

}
