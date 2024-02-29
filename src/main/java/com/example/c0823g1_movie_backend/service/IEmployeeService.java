package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Account;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService {
    void createEmployee(@Param("account") Account account);
    Account findAccountById(@Param("id") Long id);

    void updateEmployee(@Param("id") Long id, @Param("account") Account account);
}
