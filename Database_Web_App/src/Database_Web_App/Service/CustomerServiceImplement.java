package Database_Web_App.Service;


import Database_Web_App.DAO.CustomerDAO;
import Database_Web_App.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class CustomerServiceImplement implements CustomerService
{
	// Private
	@Autowired
	private CustomerDAO customerDAO;


	// Public

	// Retrieve a list of Customers
	@Override
	@Transactional
	public List<Customer> getCustomers()
	{
		return customerDAO.getCustomers();
	}

	// Add a new customer
	@Override
	@Transactional
	public void saveCustomer(Customer customer)
	{
		customerDAO.saveCustomer(customer);
	}

	// Get a customer from the database
	@Override
	@Transactional
	public Customer getCustomer(int id)
	{
		return customerDAO.getCustomer(id);
	}

	// Delete a customer from the database
	@Override
	@Transactional
	public void deleteCustomer(int id)
	{
		customerDAO.deleteCustomer(id);
	}

	// Search for matched customers
	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchName) 
	{

		return customerDAO.searchCustomers(searchName);
	}
}