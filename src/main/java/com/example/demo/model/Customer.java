package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document
public class Customer {
 @Id
  private int id;
  public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Long getSalary() {
	return Salary;
}
public void setSalary(Long salary) {
	Salary = salary;
}
private String Name;
  private Long Salary;
  
}
