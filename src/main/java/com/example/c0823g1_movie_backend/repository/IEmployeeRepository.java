package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO account(account_name, address, birthday, email, full_name, gender, id_number, member_code, password, phone_number, point, profile_picture, role_id) " +
            "values (:#{#account.accountName}, :#{#account.address}, :#{#account.birthday}, :#{#account.email}, :#{#account.fullName}, :#{#account.gender}, :#{#account.idNumber}, :#{#account.memberCode}, :#{#account.password}, :#{#account.phoneNumber}, 0 , :#{#account.profilePicture}, 1)")
    void saveEmployee(@Param("account") Account account);

    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE id=:id")
    Account findAccountById(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE account SET account_name=:accountName, address=:address, birthday=:birthday, email=:email, full_name=:fullName, gender=:gender, id_number=:idNumber, member_code=:memberCode, password=:password, phone_number=:phoneNumber, profile_picture=:profilePicture WHERE id=:id")
    void updateEmployee(@Param("id") Long id, @Param("account") Account account);
}
