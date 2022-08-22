package com.employeemanagement.repository;

import com.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {
//public Employee findByName(String firstName);
   // public Employee findByFirstNameIgnoreCase(String firstName);
}
