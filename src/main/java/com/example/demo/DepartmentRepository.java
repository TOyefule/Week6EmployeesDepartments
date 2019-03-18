package com.example.demo.repositories;

import com.example.demo.Entitiy.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository <Department, Long>{
}
