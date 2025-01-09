package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @PersistenceContext
    private EntityManager entityManager;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void demonstrateFirstLevelCache(Long empId)
    {
        Employee employee=entityManager.find(Employee.class,empId);
        System.out.println("First Fetch:"+employee.getName());

        Employee employee1=entityManager.find(Employee.class,empId);
        System.out.println("Second fetch:"+employee1.getName());
    }
}
