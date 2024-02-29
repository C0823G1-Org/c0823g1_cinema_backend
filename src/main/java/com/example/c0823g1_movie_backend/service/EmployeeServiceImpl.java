package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Account getEmployeeById(long id) {
        return employeeRepository.findAccountById(id);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Account> getAllEmployee(String name, Pageable pageable) {
        return employeeRepository.searchByName("%" + name + "%", pageable);
    }
}
