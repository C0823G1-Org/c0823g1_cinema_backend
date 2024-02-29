package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Account,Long> {
    @Query(value = "select * from account where account.full_name like :name and is_deleted = 0", nativeQuery = true)
    Page<Account> searchByName(@Param("name") String name, Pageable pageable);
    @Query(value = "update account set account.is_deleted = 1 where id = :id", nativeQuery = true)
    void deleteEmployeeById(@Param("id") long id);
    @Query(value = "select * from account where id = :id", nativeQuery = true)
    Account findAccountById(@Param("id") long id);
}
