package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Account getEmployeeById(long id);
    void deleteById(long id);
    Page<Account> getAllEmployee(String name, Pageable pageable);

}
