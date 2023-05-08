package com.luv2code.demoClass.Controller;

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

import com.luv2code.demoClass.Entity.Customer;
import com.luv2code.demoClass.Handler.RestResponse;
import com.luv2code.demoClass.Service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
  
	@Autowired
	private ICustomerService  customerService;
	
	public CustomerController() {
		
	}

	@GetMapping("/Customers")
    public List<Customer> getCustomers() {
		return customerService.getCustomers();		    
    }

	
	@GetMapping("/Customers/{customerId}")
	// @PathVariable：接收路徑變數
    public Customer getCustomer(@PathVariable("customerId") int customerId) throws Exception{
		return customerService.getCustomer(customerId);		    
    }
	

	
	
	@PostMapping("/Customers")
	// @RequestBody：主要用來接收前端傳遞給後端的JSON字串
    public RestResponse AddStudent(@RequestBody Customer customer){
		return customerService.addCustomer(customer); 
    }
	
	
	@PutMapping("/Customers/{customerId}")
    public RestResponse updStudent(@RequestBody Customer customer,
    		                 @PathVariable("customerId") int customerId) throws Exception{
		return customerService.updCustomer(customer,customerId);
    }
	
	
	@DeleteMapping("/Customers/{customerId}")
    public String DelStudent(@PathVariable("customerId") int customerId) throws Exception{
		return customerService.delCustomer(customerId);		    
    }
	
}
