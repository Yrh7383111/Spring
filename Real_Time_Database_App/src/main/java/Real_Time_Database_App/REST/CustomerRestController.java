package Real_Time_Database_App.REST;


import Real_Time_Database_App.Entity.Customer;
import Real_Time_Database_App.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/api")
public class CustomerRestController
{
	// Private
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) 
	{
		return customerService.getCustomer(customerId);
	}
}