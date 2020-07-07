package com.emp.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.management.exception.EmployeeExistException;
import com.emp.management.exception.EmployeeNotFoundException;
import com.emp.management.model.Employee;
import com.emp.management.service.EmployeeService;

@RestController
@RequestMapping(value="/emp", produces="application/json")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@PostMapping("/insertEmployee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
		Optional<Employee> emp=employeeService.getEmpById(employee.getEmpId());
		if(emp.isPresent()) {
			 throw new EmployeeExistException("Employee is already exist in the Database");
		}else {
			employeeService.saveEmployee(employee);
			return ResponseEntity.ok().body("Employee is inserted in the Database");
		}
	
	}
	
	
	@GetMapping("/getAllEmployess")
	public ResponseEntity<Object> getEmployess(){
		List<Employee> empList=employeeService.getAllEmployees();
		if(empList.size()==0) {
			 throw new EmployeeNotFoundException("No Employee exist in the Database");
		}else {
			return ResponseEntity.ok().body(empList);
		}
	}
	
	@GetMapping("/getEmpById/{empid}")
	public ResponseEntity<Object> getEmpById(@PathVariable(value="empid") Long empid){
		Optional<Employee> emp=employeeService.getEmpById(empid);
		if(emp.isPresent()) {
			return ResponseEntity.ok().body(emp.get());
		}else {
			 throw new EmployeeNotFoundException("Employee not found in the Database for the empid:"+empid);
		}
	}
	
	@GetMapping("/getEmpByDept")
	public List<Employee> getEmpByDept(@RequestParam("dept") String dept){
		return employeeService.getEmpByDept(dept);
	}
	
	@GetMapping("/empCountBySalary/{sal}")
	public ResponseEntity<Object> getEmpCountBySalary(@PathVariable(value="sal") Double sal){
		int count=employeeService.empCountBySalaryGreathanEqualToValue(sal);
		
		return ResponseEntity.ok().body("Number of employees whose salary>="+sal+" is :"+count);
	}
	
	
}
