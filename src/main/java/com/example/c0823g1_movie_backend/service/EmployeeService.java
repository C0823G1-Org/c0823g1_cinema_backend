package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.repository.IEmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void createEmployee( @Param("account") Account account) {
        employeeRepository.saveEmployee(account);
    }

    @Override
    public Account findAccountById(Long id) {
        return employeeRepository.findAccountById(id);
    }

    @Override
    @Transactional
    public void updateEmployee(@Param("id") Long id, @Param("account") Account account) {
        employeeRepository.updateEmployee(id, account);
    }
}
