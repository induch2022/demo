package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
     
	
	@Autowired
	private CustomerRepository customerRepository;
	 
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		
		customerRepository.save(customer);
		return "customer has been added with the id"+customer.getId();
		
	}
	
	
	@GetMapping("/getCustomer")
	public List<Customer> getCustomer(){
		
		return customerRepository.findAll();		
	}
	
	
	@PutMapping("/update/{id}")
	public String updatCustomer(@PathVariable int id, @RequestBody Customer customer) {
		boolean exists = customerRepository.existsById(id);
		Customer customer1 = customerRepository.findById(id);
		if(!exists)
			return "the customer doesnt exist with that id";
		customer1.setName(customer.getName());
		customer1.setSalary(customer.getSalary());
		customerRepository.save(customer1);
		return "customer has been updated with the id =  "+id;
		
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerRepository.deleteById(id);
		
		return "customer deleted with the id :"+id;
	}
}
