package com.rmg.SpringDataJPA.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table
public class Product {

/*	
 * ID generator Automatically by choosing any of the one TABLE , IDENTITY, SEQUENCE
 * IDENTITY - Auto increment constrain support on database like MYSQL
 * 
 * 
 * @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;*/
	
	@TableGenerator(name="product",table="product_gen",pkColumnName="gen_name",allocationSize=1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="product")
	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
