package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {

    Optional<IAccountDTO> getEmployeeById(Long id);
    Account getEmp(Long id);
    boolean deleteEmployee(Long id);
    Page<Account> getAllEmployee(String name, Pageable pageable);

}
