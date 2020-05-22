package Real_Time_Database_App.DAO;

import Real_Time_Database_App.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDAOImplement implements CustomerDAO
{
	// Private
	// Dependency injection
	@Autowired
	private SessionFactory sessionFactory;


	// Public

	// Retrieve a list of Customers
	@Override
	public List<Customer> getCustomers()
	{
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// Create a query
		Query<Customer> query = session.createQuery("from Customer order by lastName");

		// Execute query and get result list
		List<Customer> customers = query.getResultList();

		// Return the results
		return customers;
	}

	// Add a new customer
	@Override
	public void saveCustomer(Customer customer)
	{
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// Save the customer
		session.saveOrUpdate(customer);
	}

	// Get a customer from the database
	@Override
	public Customer getCustomer(int id) 
	{
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// Retrieve from database using the primary key
		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	public void deleteCustomer(int id) 
	{
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// Retrieve from database using the primary key
		Customer customer = session.get(Customer.class, id);

		// Delete the customer using the primary key
		session.delete(customer);
	}

	// Search for matched customers
	@Override
	public List<Customer> searchCustomers(String searchName) 
	{
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// Initialize the query
		Query<Customer> query = null;

		// Only search by name if searchName is not empty
		if (searchName != null && searchName.trim().length() > 0)
		{
			// Search for firstName or lastName
			// Case insensitive
			query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name");
			query.setParameter("name", "%" + searchName.toLowerCase() + "%");
		}
		else {
			// Search bar is empty
			query = session.createQuery("from Customer");
		}

		// Execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results		
		return customers;
	}
}