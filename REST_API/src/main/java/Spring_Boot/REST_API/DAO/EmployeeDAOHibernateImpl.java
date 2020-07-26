//package Spring_Boot.REST_API.DAO;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import Spring_Boot.REST_API.Entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//
//
//@Repository("employeeDAOHibernateImpl")
//@Transactional
//public class EmployeeDAOHibernateImpl implements EmployeeDAO
//{
//	// Private
//	private EntityManager entityManager;
//
//
//	// Public
//	@Autowired
//	public EmployeeDAOHibernateImpl(EntityManager entityManager)
//	{
//		this.entityManager = entityManager;
//	}
//
//	@Override
//	public List<Employee> list()
//	{
//		Session session = entityManager.unwrap(Session.class);
//		Query<Employee> query = session.createQuery("FROM Employee");
//		List<Employee> employees = query.getResultList();
//
//		return employees;
//	}
//
//	@Override
//	public Employee get(int id)
//	{
//		Session session = entityManager.unwrap(Session.class);
//		Employee employee = session.get(Employee.class, id);
//
//		return employee;
//	}
//
//	@Override
//	public void add(Employee employee)
//	{
//		Session currentSession = entityManager.unwrap(Session.class);
//
//		currentSession.persist(employee);
//	}
//
//	@Override
//	public void update(Employee employee)
//	{
//		Session currentSession = entityManager.unwrap(Session.class);
//
//		currentSession.update(employee);
//	}
//
//	@Override
//	public void delete(int id)
//	{
//		Employee employee = get(id);
//		Session currentSession = entityManager.unwrap(Session.class);
//
//		currentSession.delete(employee);
//	}
//}