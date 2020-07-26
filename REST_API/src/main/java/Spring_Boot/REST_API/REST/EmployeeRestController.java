//package Spring_Boot.REST_API.REST;
//
//import java.util.List;
//
//import Spring_Boot.REST_API.Entity.Employee;
//import Spring_Boot.REST_API.Service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeRestController
//{
//	// Private
//	private EmployeeService employeeService;
//
//
//	// Public
//	@Autowired
//	public EmployeeRestController(EmployeeService employeeService)
//	{
//		this.employeeService = employeeService;
//	}
//
//	@GetMapping("/employees")
//	public List<Employee> list()
//	{
//		return employeeService.list();
//	}
//
//	@GetMapping("/employees/{id}")
//	public Employee getEmployee(@PathVariable int id)
//	{
//		Employee employee = employeeService.get(id);
//
//		if (employee == null)
//			throw new RuntimeException("Employee id not found - " + id);
//
//		return employee;
//	}
//
//	@PostMapping("/employees")
//	public Employee addEmployee(@RequestBody Employee employee)
//	{
//		employee.setId(0);
//		employeeService.add(employee);
//
//		return employee;
//	}
//
//	@PutMapping("/employees")
//	public Employee updateEmployee(@RequestBody Employee employee)
//	{
//		employeeService.update(employee);
//
//		return employee;
//	}
//
//	@DeleteMapping("/employees/{id}")
//	public String deleteEmployee(@PathVariable int id)
//	{
//		Employee employee = employeeService.get(id);
//
//		if (employee == null)
//			throw new RuntimeException("Employee id not found - " + id);
//
//		employeeService.delete(id);
//
//		return "Deleted employee id - " + id;
//	}
//}