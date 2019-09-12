package com.rmg.SpringDataJPA;

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

	/**
	 * TOPIC : Generators
	 * Save product on Database with Auto generated ID - different types  like AUTO,SEQUENCE,TABLE,IDENTITY
	 * Reference docs - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	 */
	@Test
	public void saveData() {
		Product product = new Product();
		product.setName("Laptop");
		productRepo.save(product);
	}

	/**
	 * TOPIC : Generators
	 * Save different Employees on Database using generation type - CUSTOM ID generation
	 * Reference docs - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	 */
	@Test
	public void saveEmpData() {
		Employee employee = new Employee();
		employee.setName("Jhon");
		employee.setSalary(35000d);

		Employee employee1 = new Employee();
		employee1.setName("Arun");
		employee1.setSalary(13000d);

		Employee employee2 = new Employee();
		employee2.setName("Kevin");
		employee2.setSalary(25000d);

		employeeRepo.save(employee);
		employeeRepo.save(employee1);
		employeeRepo.save(employee2);
	}

	/**
	 *  TOPIC : Finder Methods 
	 *  To Fetch All Employee based on different conditions
	 *  Reference docs - https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	 */
	@Test
	public void fetchEmployee() {
		employeeRepo.findAll().forEach(employee -> System.out.println(employee.toString()));
		employeeRepo.findByName("Jhon")
				.forEach(employee -> System.out.println("findByName(\"Jhon\")>>" + employee.toString()));
		employeeRepo.findByNameAndSalary("Arun", 13000d).forEach(
				employee -> System.out.println("findByNameAndSalary(\"Arun\", 13000d)>>" + employee.toString()));
		employeeRepo.findByNameStartingWith("K")
				.forEach(employee -> System.out.println("findByNameStartingWith(\"K\")>>" + employee.toString()));
		employeeRepo.findBySalaryGreaterThanEqual(20000d).forEach(
				employee -> System.out.println("findBySalaryGreaterThanEqual(20000d)>>" + employee.toString()));
	}

}
