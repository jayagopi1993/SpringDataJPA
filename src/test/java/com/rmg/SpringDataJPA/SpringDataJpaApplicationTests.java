package com.rmg.SpringDataJPA;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		
		/**
		 * Added some product for demo of Paging & Sorting
		 */
		Product product1 = new Product();
		product1.setName("Charger");
		
		Product product2 = new Product();
		product2.setName("PC");
		
		Product product3 = new Product();
		product3.setName("IMac");
		
		Product product4 = new Product();
		product4.setName("Apple IPad");
		
		Product product5 = new Product();
		product5.setName("Note 7 Pro");
		
		productRepo.save(product);
		productRepo.save(product1);
		productRepo.save(product2);
		productRepo.save(product3);
		productRepo.save(product4);
		productRepo.save(product5);
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

	/**
	 * Finding product by pages default methods of PagingAndSortingRepository Interface - PageRequest.of(pageNumber, NumOfItemPerPage) 
	 * productRepo.findAll(Pageable pageable);
	 */
	@Test
	public void fetchWithPaging() {
		System.out.println("Fetch on page 1 : PageRequest.of(0, 2)");
		productRepo.findAll(PageRequest.of(0, 2)).forEach(product->System.out.println(product.toString()));
		System.out.println("Fetch on page 1 : PageRequest.of(1, 2)");
		productRepo.findAll(PageRequest.of(1, 2)).forEach(product->System.out.println(product.toString()));
		System.out.println("Fetch on page 1 : PageRequest.of(2, 2)");
		productRepo.findAll(PageRequest.of(2, 2)).forEach(product->System.out.println(product.toString()));
		
		/**
		 * Custom Paging by passing pageRequest object to finder method.
		 */
		employeeRepo.findBySalaryGreaterThanEqual(20000d,PageRequest.of(0, 1)).forEach(
				employee -> System.out.println("Custom Page request" + employee.toString()));
	}
	
	/**
	 * Finding the product with the sorted order by default methods of PagingAndSortingRepository Interface - Sort.by(order, sortingField)
	 * productRepo.findAll(Sort.by(Direction.ASC, "name"))
	 */
	@Test
	public void fetchWithSorting() {
		System.out.println("Product object : Sorting by name field");
		productRepo.findAll(Sort.by(Direction.ASC, "name")).forEach(product->System.out.println(product.toString()));
		
		/**
		 * Custom Sorting by passing Sort object to finder method
		 */
		System.out.println("Employee Object : Sorting by salary DESC");
		employeeRepo.findBySalaryGreaterThanEqual(20000d,Sort.by(Direction.DESC,"salary")).forEach(
				employee -> System.out.println(employee.toString()));
		
		/**
		 * Also possible both Paging and sorting on single method
		 */
		System.out.println("Employee Object : Paging & Sorting by salary DESC");
		employeeRepo.findBySalaryGreaterThanEqual(20000d,PageRequest.of(0, 1, Sort.by(Direction.DESC,"salary"))).forEach(
				employee -> System.out.println(employee.toString()));
	}
	
}
