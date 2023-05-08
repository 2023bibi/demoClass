package com.luv2code.demoClass.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.demoClass.Entity.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
   
}
