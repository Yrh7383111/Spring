//package Spring_Boot.REST_API.DAO;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import Spring_Boot.REST_API.Entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//
//
//@Repository("employeeDAOJpaImpl")
//public class EmployeeDAOJpaImpl implements EmployeeDAO
//{
//	// Private
//	private EntityManager entityManager;
//
//
//	// Public
//	@Autowired
//	public EmployeeDAOJpaImpl(EntityManager entityManager)
//	{
//		this.entityManager = entityManager;
//	}
//
//	@Override
//	public List<Employee> list()
//	{
//		Query query = entityManager.createQuery("From Employee");
//		List<Employee> employees = query.getResultList();
//
//		return employees;
//	}
//
//	@Override
//	public Employee get(int id)
//	{
//		Employee employee = entityManager.find(Employee.class, id);
//
//		return employee;
//	}
//
//	@Override
//	public void add(Employee employee)
//	{
//		Employee result = entityManager.merge(employee);
//
//		employee.setId(result.getId());
//	}
//
//	@Override
//	public void update(Employee employee)
//	{
//		entityManager.merge(employee);
//	}
//
//	@Override
//	public void delete(int id)
//	{
//		Employee employee = get(id);
//
//		entityManager.remove(employee);
//	}
//}