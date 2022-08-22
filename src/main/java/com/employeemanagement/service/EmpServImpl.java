package com.employeemanagement.service;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.errorhandling.EmployeeNotFoundException;
import com.employeemanagement.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpServImpl implements EmpServ{

    // create object of EmpRepo
    @Autowired
    EmpRepo empRepo;

    @Override
    public Employee createEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee findById(Long id) throws EmployeeNotFoundException{
        Optional<Employee> employeeOptional = empRepo.findById(id);
        if(!employeeOptional.isPresent()){
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employeeOptional.get();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        empRepo.deleteById(id);
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Employee employee1 = empRepo.findById(id).get();
        if(Objects.nonNull(employee.getFirstName())&&!"".equalsIgnoreCase(employee1.getFirstName())){
            employee1.setFirstName(employee.getFirstName());
        }
        if(Objects.nonNull(employee.getLastName())&&!"".equalsIgnoreCase(employee1.getLastName())) {
            employee1.setLastName(employee.getLastName());

        }
        if(Objects.nonNull(employee.getEmailId())&&!"".equalsIgnoreCase(employee1.getEmailId())) {
            employee1.setEmailId(employee.getEmailId());
        }

        return empRepo.save(employee1);
    }

//    @Override
//    public Employee findByEmployeeName(String firstName) {
//
//        return empRepo.findByFirstNameIgnoreCase(firstName);
//    }




}
