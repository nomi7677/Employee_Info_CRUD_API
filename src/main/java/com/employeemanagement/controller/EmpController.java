package com.employeemanagement.controller;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.errorhandling.EmployeeNotFoundException;
import com.employeemanagement.service.EmpServ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees") // common api endpoint
// for front end add this annotation... @CrossOrigin("*") or add localhost:port#

public class EmpController {
    @Autowired
    EmpServ empServ;

    private final Logger logger = LoggerFactory.getLogger(EmpController.class);

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        logger.info("created employee inside createEmployee");
        return empServ.createEmployee(employee);

    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        logger.info("getting all employees info in getAllEmployees");
        return empServ.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) throws EmployeeNotFoundException{
        return empServ.findById(id);
    }

//    @GetMapping("/{firstName}")
//    public Employee findEmpByFirstName(@PathVariable String firstName){
//        return empServ.findByEmployeeName(firstName);
//    }

@DeleteMapping("/{id}")
    public String deleteEmpById(@PathVariable Long id){
        empServ.deleteEmployeeById(id);
        return "Employee deleted successfully";
}
@PutMapping("/{id}")
    public Employee updateById(@PathVariable Long id, @RequestBody Employee employee){
        // find by id and use body to update it (2 variables)
    return empServ.updateEmployeeById(id, employee);
}

}
