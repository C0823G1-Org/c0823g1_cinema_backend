package com.example.c0823g1_movie_backend.controller;

/**
 * The EmployeeController class is responsible for handling HTTP requests related to employee data.
 * It provides endpoints to retrieve add employees and update employees by their IDs.
 * This controller class is annotated with Spring's @RestController and @RequestMapping annotations
 * to define the base URL path for handling employee-related requests.
 *
 * @author [HieuHTV]
 * @version 1.0
 * @since 1.0
 */

import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")

public class RestEmployeeController {
    @Autowired
    private IEmployeeService employeeService;


    /**
     * Add an employee with an auto_increment ID.
     * @return a ResponseEntity with an HTTP status indicating success or failure of the operation
     */
    @PostMapping("/add")
    public ResponseEntity<?> save(@Valid @RequestBody Account account){
        if (account == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.createEmployee(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Update an employee with the specified ID.
     * @param id the ID of the employee to update
     * @return a ResponseEntity with an HTTP status indicating success or failure of the operation
     */

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Account account){
        Account account1 = employeeService.findAccountById(id);
        if (account1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        account1.setId(account.getId());
        employeeService.updateEmployee(id, account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
