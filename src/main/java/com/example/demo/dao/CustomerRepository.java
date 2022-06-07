package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer>
{
  Customer findById(int id);
}
