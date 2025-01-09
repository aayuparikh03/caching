package com.example.controller;

import com.example.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/cache/{id}")
    public String demonstrateCache(@PathVariable Long id)
    {
        employeeService.demonstrateFirstLevelCache(id);
        return "Result on console of first level cache";
    }
}
