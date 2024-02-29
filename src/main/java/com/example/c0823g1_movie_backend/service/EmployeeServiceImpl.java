package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
        public Optional<IAccountDTO> getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Account getEmp(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        try {
            employeeRepository.deleteEmployee(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Page<Account> getAllEmployee(String name, Pageable pageable) {
        return employeeRepository.searchByName("%" + name + "%", pageable);
    }
}