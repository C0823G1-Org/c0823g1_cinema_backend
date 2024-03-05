package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.AccountStatisticDTO;
import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select account.id as id,\n" +
            " account.account_name as accountName, \n" +
            " account.address as address, \n" +
            " account.birthday as birthday, \n" +
            " account.email as email,\n" +
            " account.facebook_id as facebookId,\n" +
            " account.full_name as fullName,\n" +
            " account.gender as gender,\n" +
            " account.google_id as googleId,\n" +
            " account.id_number as idNumber,\n" +
            " account.is_deleted as isDeleted,\n" +
            " account.member_code as memberCode,\n" +
            " account.password as password,\n" +
            " role.name as role from account join role on account.role_id = role.id " +
            "where account.account_name = :accountName and account.facebook_id is null and account.google_id is null", nativeQuery = true)
    Optional<IAccountDTO> findByAccountNameDTO(@Param("accountName") String accountName);

    @Query(value = "select account.id as id,\n" +
            " account.account_name as accountName, \n" +
            " account.address as address, \n" +
            " account.birthday as birthday, \n" +
            " account.email as email,\n" +
            " account.facebook_id as facebookId,\n" +
            " account.full_name as fullName,\n" +
            " account.gender as gender,\n" +
            " account.google_id as googleId,\n" +
            " account.id_number as idNumber,\n" +
            " account.is_deleted as isDeleted,\n" +
            " account.member_code as memberCode,\n" +
            " account.password as password,\n" +
            " role.name as role from account join role on account.role_id = role.id where account.facebook_id = :facebookId", nativeQuery = true)
    Optional<IAccountDTO> findByAccountNameDTOFB(@Param("facebookId") String facebookId);

    @Query(value = " select account.id as id,\n" +
            " account.account_name as accountName, \n" +
            " account.address as address, \n" +
            " account.birthday as birthday, \n" +
            " account.email as email,\n" +
            " account.facebook_id as facebookId,\n" +
            " account.full_name as fullName,\n" +
            " account.gender as gender,\n" +
            " account.google_id as googleId,\n" +
            " account.id_number as idNumber,\n" +
            " account.is_deleted as isDeleted,\n" +
            " account.member_code as memberCode,\n" +
            " account.password as password,\n" +
            " role.name as role from account join role on account.role_id = role.id where account.google_id = :googleId", nativeQuery = true)
    Optional<IAccountDTO> findByAccountNameDTOGG(@Param("googleId") String googleId);
    @Query(value = "select account_name from account",nativeQuery = true)
    List<Account> getAllAccountName();
    @Query(value = "select * from account a where a.account_name like :name limit 1;" ,nativeQuery = true)
    Account getAllInforUser(@Param("name")String name);
    @Query(value = "select * from account order by id desc limit 1",nativeQuery = true)
    Account getLastUser();


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO account (account_name, full_name, phone_number, address, gender, password, role_id, facebook_id, google_id, id_number, profile_picture, birthday, email, member_code, point, is_deleted)\n" +
            "VALUES (:#{#account.accountName}, :#{#account.fullName}, :#{#account.phoneNumber}, :#{#account.address}, :#{#account.gender}, :#{#account.password}, :role, :#{#account.facebookId}, :#{#account.googleId}, :#{#account.idNumber}, :#{#account.profilePicture}, :#{#account.birthday}, :#{#account.email}, :#{#account.memberCode}, 0, 0)", nativeQuery = true)
    void register(@Param("account") Account account, @Param("role") Long role);
//@Query(value = "INSERT INTO account (accountName, fullName, phoneNumber, address, gender, password, roleId, facebookId, googleId, numberId, profilepic, birthday, email, memberCode, point, isDelete) " +
//        "VALUES (:accountName, :fullName, :phoneNumber, :address, :gender, :password, :roleId, :facebookId, :googleId, :numberId, :profilepic, :birthday, :email, :memberCode, 0, 0)",nativeQuery = true)
//void register(@Param("accountName") String accountName,
//              @Param("fullName") String fullName,
//              @Param("phoneNumber") String phoneNumber,
//              @Param("address") String address,
//              @Param("gender") String gender,
//              @Param("password") String password,
//              @Param("roleId") Long roleId,
//              @Param("facebookId") String facebookId,
//              @Param("googleId") String googleId,
//              @Param("numberId") Long numberId,
//              @Param("profilepic") String profilepic,
//              @Param("birthday") LocalDate birthday,
//              @Param("email") String email,
//              @Param("memberCode") String memberCode);



    @Query(value = " select account.id as id,\n" +
            " account.account_name as accountName, \n" +
            " account.address as address, \n" +
            " account.birthday as birthday, \n" +
            " account.email as email,\n" +
            " account.facebook_id as facebookId,\n" +
            " account.full_name as fullName,\n" +
            " account.gender as gender,\n" +
            " account.google_id as googleId,\n" +
            " account.id_number as idNumber,\n" +
            " account.is_deleted as isDeleted,\n" +
            " account.member_code as memberCode,\n" +
            " account.password as password,\n" +
            " role.name as role from account join role on account.role_id = role.id " +
            " where account.email = :email and account.facebook_id is null and account.google_id is null", nativeQuery = true)
    Optional<IAccountDTO> findByEmail(@Param("email") String email);

    @Query(value = "select account.id as id,\n" +
            " account.account_name as accountName, \n" +
            " account.address as address, \n" +
            " account.birthday as birthday, \n" +
            " account.email as email,\n" +
            " account.facebook_id as facebookId,\n" +
            " account.full_name as fullName,\n" +
            " account.gender as gender,\n" +
            " account.google_id as googleId,\n" +
            " account.id_number as idNumber,\n" +
            " account.is_deleted as isDeleted,\n" +
            " account.member_code as memberCode,\n" +
            " account.password as password,\n" +
            " role.name as role from account join role on account.role_id = role.id " +
            "where account.email = :email and account.facebook_id is null and account.google_id is null", nativeQuery = true)
    Optional<IAccountDTO> findByAccountNameDTOEmail(@Param("email") String email);

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO account (account_name, full_name, phone_number, address, gender, password, role_id, facebook_id, google_id, id_number, profile_picture, birthday, email, member_code, point, is_deleted)\n" +
//            "VALUES (:#{#account.accountName}, :#{#account.fullName}, :#{#account.phoneNumber}, :#{#account.address}, :#{#account.gender}, :#{#account.password}, :role, :#{#account.facebookId}, :#{#account.googleId}, :#{#account.idNumber}, :#{#account.profilePicture}, :#{#account.birthday}, :#{#account.email}, :#{#account.memberCode}, 0, 0)", nativeQuery = true)
//    void register(@Param("account") Account account, @Param("role") Long role);

    @Transactional
    @Modifying
    @Query(value = "update account \n" +
            "set account.password = :password " +
            "where account.id = :id", nativeQuery = true)
    void updateAccountPassword(@Param("id") Long id, @Param("password") String password);

    @Query(value = "select account.id as id,\n" +
            " account.account_name as accountName, \n" +
            " account.address as address, \n" +
            " account.birthday as birthday, \n" +
            " account.email as email,\n" +
            " account.facebook_id as facebookId,\n" +
            " account.full_name as fullName,\n" +
            " account.gender as gender,\n" +
            " account.google_id as googleId,\n" +
            " account.id_number as idNumber,\n" +
            " account.is_deleted as isDeleted,\n" +
            " account.member_code as memberCode,\n" +
            " account.password as password,\n" +
            " role.name as role from account join role on account.role_id = role.id " +
            "where account.id = :id", nativeQuery = true)
    Optional<IAccountDTO> findByIdAccountDTO(@Param("id") Long id);

    /**
     * Created by DuyDD
     * Date Created: 29/02/2024
     * Function: Get a list of accounts that have the highest amount of money spent
     */
    @Query(value = "SELECT " +
            "a.id AS ma_thanh_vien, " +
            "a.account_name AS ten_thanh_vien, " +
            "t.ticket_count AS so_luong_ve, " +
            "t.total_ticket_price AS tong_tien, " +
            "SUM(a.point) AS diem_tich_luy " +
            "FROM " +
            "account a " +
            "JOIN " +
            "(SELECT " +
            "b.account_id, " +
            "COUNT(t.id) AS ticket_count, " +
            "SUM(ticket_price) AS total_ticket_price " +
            "FROM " +
            "booking b " +
            "JOIN ticket t ON b.id = t.booking_id " +
            "JOIN schedule s ON t.schedule_id = s.id " +
            "JOIN movie m ON m.id = s.movie_id " +
            "WHERE " +
            "b.is_deleted = 0 AND t.is_deleted = 0 " +
            "AND s.is_deleted = 0 " +
            "AND m.is_deleted = 0 " +
            "GROUP BY b.account_id) t ON a.id = t.account_id " +
            "WHERE " +
            "a.is_deleted = 0 " +
            "GROUP BY a.id, a.account_name, t.ticket_count, t.total_ticket_price " +
            "ORDER BY t.ticket_count DESC, t.total_ticket_price DESC",
            nativeQuery = true)
    Page<AccountStatisticDTO> getTop50Account(Pageable pageable);

    @Query(value = "select * from account where id = :id",nativeQuery = true)
    Account findAccountById(@Param("id") Long id);

    @Query(value = "select * from account",nativeQuery = true)
    List<Account> getAllAccount();

    @Query(value = "select a.* from account a where a.email = :email limit 1",nativeQuery = true)
    Account findAccountByEmail(@Param("email") String email);
    @Query(value = "select a.* from account a where a.phone_number = :phone limit 1",nativeQuery = true)
    Account findAccountByPhone(@Param("phone") String phone);
    @Query(value = "select a.* from account a where a.account_name = :accountName limit 1",nativeQuery = true)
    Account findAccountByAccountName(@Param("accountName") String accountName);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE account SET address = :#{#account.address}, birthday = :#{#account.birthday}, email = :#{#account.email}, id_number = :#{#account.idNumber}, phone_number = :#{#account.phoneNumber} WHERE id = :id")
    void updateAccount(@Param("account") Account account, @Param("id") Long id);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE  account SET password = :password where account_name = :accountName")
    void updatePassword(@Param("password") String password , @Param("accountName") String accountName);

}
