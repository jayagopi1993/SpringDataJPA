package com.rmg.SpringDataJPA.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.rmg.SpringDataJPA.entities.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{

	List<Employee> findByName(String name);
	
	List<Employee> findByNameAndSalary(String name,double salary);
	
	List<Employee> 	findBySalaryGreaterThanEqual(double salary);
	
	List<Employee> 	findByNameStartingWith(String letter);
	
	/**
	 * Custom Pageable implementation on finder method
	 * @param salary
	 * @param pageable
	 * @return
	 */
	List<Employee> 	findBySalaryGreaterThanEqual(double salary,Pageable pageable);
	
	/**
	 * Custom Sort implementation on finder method
	 * @param salary
	 * @param sort
	 * @return
	 */
	List<Employee> 	findBySalaryGreaterThanEqual(double salary,Sort sort);
	
}
