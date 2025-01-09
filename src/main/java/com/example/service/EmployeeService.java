package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee getEmployeeById(Long id)
    {
        System.out.println("Fetching from Database:");
        Optional<Employee> employee=employeeRepository.findById(id);
        return employee.orElse(null);
    }
}
