package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.model.Role;
import com.example.c0823g1_movie_backend.repository.AccountRepository;
import com.example.c0823g1_movie_backend.repository.RolesRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void register(Account account) {
        Optional<Role> role = rolesRepository.findById(3L);
        if (role.isPresent()) {
            account.setRole(role.get());
            accountRepository.register(account, role.get().getId());
        }
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account getLastUser() {
        return accountRepository.getLastUser();
    }

    @Override
    public Account getAllInfoUser(String name) {
        return accountRepository.getAllInforUser('%'+name+'%');
    }

    @Override
    public List<Account> getAllAccountName() {
        return accountRepository.getAllAccountName();
    }

    @Override
    public void register(Account account, Long role) {
        accountRepository.register(account,role);
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
    public Optional<IAccountDTO> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public void updatePasswordAndSendMail(Long id, String newPassword) {
        Optional<IAccountDTO> account = accountRepository.findByIdAccountDTO(id);
        if (account.isPresent()) {
            accountRepository.updateAccountPassword(id,passwordEncoder.encode(newPassword));
            String to = account.get().getEmail();
            String subject = "[C0823G1-Cinema]-Phản hồi yêu cầu cấp lại mật khẩu tài khoản";
            String templateName = "email-template";
            org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
            context.setVariable("fullName", account.get().getFullName());
            context.setVariable("password", newPassword);
            sendEmailWithHtmlTemplate(to,subject,templateName,context);
        }
    }

    @Override
    public boolean checkLoginByEmail(Account account) {
        Optional<IAccountDTO> accountDTO = accountRepository.findByAccountNameDTOEmail(account.getEmail());
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
    public String getRoleUserEmail(Account account) {
        Optional<IAccountDTO> iAccountDTO = accountRepository.findByAccountNameDTOEmail(account.getEmail());
        return iAccountDTO.map(IAccountDTO::getRole).orElse(null);
    }

    @Override
    public Account findAccountById(Long accountId) {
        return accountRepository.findAccountById(accountId);
    }


    public void sendEmailWithHtmlTemplate(String to, String subject, String templateName, Context context) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
        try {
            helper.setTo(to);
            helper.setSubject(subject);
            String htmlContent = templateEngine.process(templateName, context);
            helper.setText(htmlContent, true);
            emailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}