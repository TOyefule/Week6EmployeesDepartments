package com.example.demo.repositories;

import com.example.demo.Entitiy.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
