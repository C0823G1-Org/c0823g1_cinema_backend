package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
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


}
