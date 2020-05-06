package Database_Web_App.Controller;


import Database_Web_App.Entity.Customer;
import Database_Web_App.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("/customer")
public class CustomerController
{
	// Private
	@Autowired
	private CustomerService customerService;


	// Public

	// List all the customers
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		// Get customers from the service
		List<Customer> customers = customerService.getCustomers();

		// Add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}

	// Show the form to add a new customer
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		// Create model attribute to bind form data
		Customer customer = new Customer();

		// Add the customers to the model
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	// Save the customer
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		// Save the customer using our service
		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model)
	{
		// Get the customer from our service
		Customer customer = customerService.getCustomer(id);

		// Set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id)
	{
		// Delete the customer
		customerService.deleteCustomer(id);

		return "redirect:/customer/list";
	}

	@GetMapping("/search")
	public String searchCustomers(@RequestParam("searchName") String searchName, Model model)
	{

		// Search customers from the service
		List<Customer> customers = customerService.searchCustomers(searchName);

		// Add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}
}