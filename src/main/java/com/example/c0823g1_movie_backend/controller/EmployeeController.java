/**
 * The EmployeeController class is responsible for handling HTTP requests related to employee data.
 * It provides endpoints to retrieve paginated lists of employees and delete employees by their IDs.
 * This controller class is annotated with Spring's @RestController and @RequestMapping annotations
 * to define the base URL path for handling employee-related requests.
 * This class was created on: February 29, 2024
 * @author [HungVXK]
 * @version 1.0
 * @since 1.0
 */
package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.IAccountDTO;
import com.example.c0823g1_movie_backend.model.Account;
import com.example.c0823g1_movie_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Retrieves a paginated list of employees based on the provided search name and page number.
     * @param searchName the name to search for among employees (default is an empty string)
     * @param page the page number for pagination (default is 0)
     * @return a ResponseEntity containing the paginated list of employees and an HTTP status code
     */
    @GetMapping("/employee")
    public ResponseEntity<Page<Account>> getPage(@RequestParam(defaultValue = "") String searchName,
                                                 @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Account> accountPage = employeeService.getAllEmployee(searchName, pageable);
        return ResponseEntity.ok(accountPage);
    }

    /**
     * Deletes an employee with the specified ID.
     * @param id the ID of the employee to delete
     * @return a ResponseEntity with an HTTP status indicating success or failure of the operation
     */

//    @GetMapping("/employee/{id}")
//    public ResponseEntity<Optional<IAccountDTO>> findById(@PathVariable Long id) {
//        Optional<IAccountDTO> account = employeeService.getEmployeeById(id);
//        return new ResponseEntity<>(account,HttpStatus.OK);
//    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<IAccountDTO> account = employeeService.getEmployeeById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(account.get().getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}