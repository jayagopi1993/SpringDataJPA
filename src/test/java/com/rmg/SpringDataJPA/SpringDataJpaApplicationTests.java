package com.rmg.SpringDataJPA;

import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rmg.SpringDataJPA.entities.Employee;
import com.rmg.SpringDataJPA.entities.Product;
import com.rmg.SpringDataJPA.repos.EmployeeRepo;
import com.rmg.SpringDataJPA.repos.ProductRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaApplicationTests {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void saveData() {
		Product product = new Product();
		product.setName("Laptop");
		productRepo.save(product);
	}
	
	@Test
	public void saveEmpData() {
		Employee employee = new Employee();
		employee.setName("Gopinath");
		employeeRepo.save(employee);
	}
	
	@Test
	public void loadData() {
		productRepo.findAll().stream().collect(Collectors.toList());
		
	}

}
