package com.example.c0823g1_movie_backend.dto;

import com.example.c0823g1_movie_backend.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    Integer id;
    @NotBlank(message = "Tài Khoản không được để rỗng")
    @Size(min = 6,max = 35,message = "Tài Khoản có độ dài từ 6-35 kí tự")
    @Pattern(regexp = "^[a-z0-9_-]+$",message = "Tài Khoản Vui Lòng Nhập Đúng Định Dạng")
    String accountName;
    @NotBlank(message = "Địa chỉ không được để rỗng")
    String address;
//    @NotBlank(message = "Ngày Sinh không được để rỗng")
    LocalDate birthday;
    @NotBlank(message = "Email Không được để rỗng")
    @Pattern(regexp = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$",message = "Email vui lòng nhập đúng định dạng")
    String email;
    Boolean gender;
    String idNumber;
    Boolean isDeleted;
    String memberCode;
    @NotBlank(message = "Họ Và Tên không được để rỗng")
    @Pattern(regexp = "^[A-Za-zÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:\\s+[A-Za-zÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*\\s*$" ,message = "Họ Và Tên vui lòng nhập đúng định dạng" )
    @Size(max = 45 ,message = "Họ và Tên Dưới 40 Kí Tự")
    String fullName;
    @NotBlank(message = "Mật Khẩu không được để rỗng")
    @Size(min = 6,max = 20,message = "Mật Khẩu độ dài từ 6-20 kí tự")
    String password;
    Role role;
    String facebookId;
    String googleId;
    String profilePicture;
    Integer point;
    @NotBlank(message = "Số Điện Thoại không được để rỗng")
    @Pattern(regexp = "^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$",message = "Số điện thoại vui lòng nhập đúng định dạng")
    String phoneNumber;
    @NotBlank(message = "Mã Xác Minh không được rỗng")
    String verificationCode;

    public AccountDTO(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public AccountDTO(String email) {
        this.email = email;
    }
}
