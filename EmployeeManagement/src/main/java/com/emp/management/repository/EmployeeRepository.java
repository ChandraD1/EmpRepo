package com.emp.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.management.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("from Employee e where e.empId=:empId")
	Optional<Employee> getEmpById(@Param("empId") Long empId);
	
	@Query(value="Select * from Employee e where e.department=?",nativeQuery=true)
	List<Employee> getEmpByDept(String department);
	
	@Query(value="Select count(*) from Employee e where e.salary>=?",nativeQuery=true)
	int empCountBySalaryGreathanEqualToValue(Double salary);
}
