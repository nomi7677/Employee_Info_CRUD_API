package com.employeemanagement.service;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.errorhandling.EmployeeNotFoundException;

import java.util.List;

public interface EmpServ {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee findById(Long id) throws EmployeeNotFoundException;
//  public Employee findByEmployeeName(String firstName);
    public void deleteEmployeeById(Long id);
    public Employee updateEmployeeById(Long id, Employee employee);
}
