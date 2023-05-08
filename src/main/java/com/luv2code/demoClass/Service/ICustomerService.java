package com.luv2code.demoClass.Service;

import java.util.List;


import com.luv2code.demoClass.Entity.Customer;
import com.luv2code.demoClass.Handler.RestResponse;

public interface ICustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int customerId) throws Exception;
   
	public String  delCustomer(int customerId) throws Exception;
	
	public RestResponse  addCustomer(Customer customer);
	
	public RestResponse  updCustomer(Customer customer,int customerId) throws Exception;
	   
}
