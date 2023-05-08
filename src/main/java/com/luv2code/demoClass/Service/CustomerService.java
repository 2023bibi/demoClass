package com.luv2code.demoClass.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.demoClass.Entity.Customer;
import com.luv2code.demoClass.Handler.RestResponse;
import com.luv2code.demoClass.dao.CustomerRepository;


@Service
public class CustomerService implements ICustomerService{

	
	@Autowired
	CustomerRepository customerRepository;
	
	private String rtnStr;
	
	@Override
	public List<Customer> getCustomers() {		
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(int customerId) throws Exception {
		Customer customer ;
		try {
			customer = customerRepository.findById(customerId).get();
	    }catch(NoSuchElementException e) {
	    	throw new NoSuchElementException("客戶編號："+customerId+"，查無資料");
	    }
		
		return customer;
	}

	@Override
	public String delCustomer(int customerId) throws Exception {		
		Customer customer = getCustomer(customerId);;
		customerRepository.delete(customer);
		rtnStr="客戶編號："+customerId+"，刪除成功";
		return rtnStr;
	}

	@Override
	public RestResponse addCustomer(Customer customer) {
		Customer customerObj =customerRepository.save(customer);
		rtnStr="客戶編號："+customerObj.getId()+"，儲存成功";
		return new RestResponse(rtnStr,customer);
	}

	@Override
	public RestResponse updCustomer(Customer customer, int customerId) throws Exception {
		getCustomer(customerId);
		customer.setId(customerId);
		customerRepository.save(customer);
		rtnStr="客戶編號："+customerId+"，更新成功。";
		return new RestResponse(rtnStr,customer);
	}


	
}
