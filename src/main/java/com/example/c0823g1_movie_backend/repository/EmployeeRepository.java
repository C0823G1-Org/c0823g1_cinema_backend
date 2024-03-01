package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Account,Long> {
    @Query(value = "select * from account where account.full_name like :name and is_deleted = 0", nativeQuery = true)
    Page<Account> searchByName(@Param("name") String name, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update account set account.is_deleted = 1 where account.id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Long id );
    @Query(value = "select a.id as id, a.full_name as fullName,\n" +
            "\t\ta.member_code as memberCode,\n" +
            "        a.email as email,\n" +
            "        a.phone_number as phoneNumber,\n" +
            "        a.id_number as idNumber,\n" +
            "        a.address as address\n" +
            " from account a where a.id = :id and is_deleted = 0", nativeQuery = true)
    Optional<IAccountDTO> findEmployeeById(@Param("id") Long id);

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
