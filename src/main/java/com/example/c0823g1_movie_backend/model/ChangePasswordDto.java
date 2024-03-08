package com.example.c0823g1_movie_backend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDto implements Validator {
//    private String email;
    private long id;
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
//    private List<Account> accounts;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ChangePasswordDto changePasswordDto = (ChangePasswordDto) target;
//        ((ChangePasswordDto) target).getAccounts();
        if (changePasswordDto.getCurrentPassword() == null || changePasswordDto.getCurrentPassword().trim().equals("")){
            errors.rejectValue("currentPassword","","Mật Khẩu Hiện Tại Không được để rỗng");
        }
        if (changePasswordDto.getNewPassword() == null || changePasswordDto.getNewPassword().trim().equals("")){
            errors.rejectValue("newPassword","","Mật Khẩu Mới không được rỗng");
        }else if (changePasswordDto.getNewPassword().length() < 6){
            errors.rejectValue("newPassword","","Mật Khẩu Mới bao gồm 6-20 kí tự");
        }else if (changePasswordDto.getNewPassword().length() > 20){
            errors.rejectValue("newPassword","","Mật Khẩu Mới bao gồm 6-20 kí tự");
        }
        if (changePasswordDto.getConfirmationPassword() == null || changePasswordDto.getConfirmationPassword().trim().equals("")){
            errors.rejectValue("confirmationPassword","","Xác Nhận Mật Khẩu không được rỗng ");
        }else if (!(changePasswordDto.getConfirmationPassword().equals(changePasswordDto.getNewPassword()))){
            errors.rejectValue("confirmationPassword","","Mật Khẩu không trùng khớp");
        }

    }
}
