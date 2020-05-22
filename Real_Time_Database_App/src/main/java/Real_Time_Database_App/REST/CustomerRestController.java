package Real_Time_Database_App.REST;


import Real_Time_Database_App.Entity.Customer;
import Real_Time_Database_App.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
		Customer customer = customerService.getCustomer(customerId);

		if (customer == null)
		{
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}

		return customer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		customer.setId(0);

		customerService.saveCustomer(customer);

		return customer;
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		customerService.saveCustomer(customer);

		return customer;
	}


}