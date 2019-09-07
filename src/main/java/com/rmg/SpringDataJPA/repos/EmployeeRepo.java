package com.rmg.SpringDataJPA.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmg.SpringDataJPA.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
