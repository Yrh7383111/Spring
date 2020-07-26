//package Spring_Boot.REST_API.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//import Spring_Boot.REST_API.DAO.EmployeeRepository;
//import Spring_Boot.REST_API.Entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@Transactional
//public class EmployeeServiceImpl implements EmployeeService
//{
//	// Private
//	private EmployeeRepository employeeRepository;
//
//	// Public
//	@Autowired
//	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
//	{
//		this.employeeRepository = employeeRepository;
//	}
//
//	@Override
//	public List<Employee> list()
//	{
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public Employee get(int id)
//	{
//		Optional<Employee> result = employeeRepository.findById(id);
//		Employee employee = new Employee();
//
//		if (result.isPresent())
//			employee = result.get();
//
//		return employee;
//	}
//
//	@Override
//	public void add(Employee employee)
//	{
//		employeeRepository.save(employee);
//	}
//
//	@Override
//	public void update(Employee employee)
//	{
//		employeeRepository.save(employee);
//	}
//
//	@Override
//	public void delete(int id)
//	{
//		employeeRepository.deleteById(id);
//	}
//}