package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.AccountStatisicDTO;
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

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO account (account_name, full_name, phone_number, address, gender, password, role_id, facebook_id, google_id, id_number, profile_picture, birthday, email, member_code, point, is_deleted)\n" +
            "VALUES (:#{#account.accountName}, :#{#account.fullName}, :#{#account.phoneNumber}, :#{#account.address}, :#{#account.gender}, :#{#account.password}, :role, :#{#account.facebookId}, :#{#account.googleId}, :#{#account.idNumber}, :#{#account.profilePicture}, :#{#account.birthday}, :#{#account.email}, :#{#account.memberCode}, 0, 0)", nativeQuery = true)
    void register(@Param("account") Account account, @Param("role") Long role);

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
    @Query(value = "SELECT a.id as ma_thanh_vien, a.account_name as ten_thanh_vien, " +
            "COUNT(t.id) as so_luong_ve, " +
            "SUM(t.ticket_price) as tong_tien, " +
            "SUM(a.point) as diem_tich_luy " +
            "FROM account a " +
            "JOIN ( " +
            "   SELECT b.account_id, " +
            "   COUNT(t.id) AS ticket_count, " +
            "   SUM(ticket_price) AS total_ticket_price " +
            "   FROM booking b " +
            "   JOIN ticket t ON b.id = t.booking_id " +
            "   JOIN schedule s ON t.schedule_id = s.id " +
            "   JOIN movie m ON m.id = s.movie_id " +
            "   WHERE b.is_deleted = 0 AND t.is_deleted = 0 AND s.is_deleted = 0 AND m.is_deleted = 0 " +
            "   GROUP BY b.account_id " +
            ") t ON a.id = t.account_id " +
            "WHERE a.is_deleted = 0 " +
            "GROUP BY a.id, a.account_name, t.ticket_count, t.total_ticket_price " +
            "ORDER BY t.ticket_count DESC, t.total_ticket_price DESC",
            countQuery = "SELECT COUNT(*) FROM (SELECT DISTINCT a.id " +
                    "FROM account a " +
                    "JOIN ( " +
                    "   SELECT b.account_id " +
                    "   FROM booking b " +
                    "   JOIN ticket t ON b.id = t.booking_id " +
                    "   JOIN schedule s ON t.schedule_id = s.id " +
                    "   JOIN movie m ON m.id = s.movie_id " +
                    "   WHERE b.is_deleted = 0 AND t.is_deleted = 0 AND s.is_deleted = 0 AND m.is_deleted = 0 " +
                    "   GROUP BY b.account_id " +
                    ") t ON a.id = t.account_id " +
                    "WHERE a.is_deleted = 0) AS countQuery",
            nativeQuery = true)
    Page<AccountStatisicDTO> getTop50Account(Pageable pageable);

}
