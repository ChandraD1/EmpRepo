package com.emp.management.service;

import java.util.List;
import java.util.Optional;

import com.emp.management.model.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Optional<Employee> getEmpById(Long empId);
	public List<Employee> getEmpByDept(String dept);
	public int empCountBySalaryGreathanEqualToValue(Double salary);
	
}
