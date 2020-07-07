package com.emp.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.management.model.Employee;
import com.emp.management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmpById(Long empId) {
		return employeeRepository.getEmpById(empId);
	}

	@Override
	public List<Employee> getEmpByDept(String dept) {
		return employeeRepository.getEmpByDept(dept);
	}

	@Override
	public int empCountBySalaryGreathanEqualToValue(Double salary) {
		return employeeRepository.empCountBySalaryGreathanEqualToValue(salary);
	}

}
