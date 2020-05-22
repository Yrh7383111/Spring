package Real_Time_Database_App.DAO;


import Real_Time_Database_App.Entity.Customer;

import java.util.List;


public interface CustomerDAO
{
	// Retrieve a list of Customers
	public List<Customer> getCustomers();

	// Add a new customer
	public void saveCustomer(Customer customer);

	// Get a customer from the database
	public Customer getCustomer(int id);

	// Delete a customer from the database
	public void deleteCustomer(int id);

	// Search for matched customers
	public List<Customer> searchCustomers(String searchName);
}