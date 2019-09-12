package com.rmg.SpringDataJPA.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rmg.SpringDataJPA.entities.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{

	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndSalary(String name,double salary);
	
	List<Employee> 	findBySalaryGreaterThanEqual(double salary);
	
	List<Employee> 	findByNameStartingWith(String letter);
	
}
