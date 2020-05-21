package Spring_REST_POJO_to_JSON.REST;

import Spring_REST_POJO_to_JSON.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api")
public class StudentRestController 
{
	@GetMapping("/students")
	public List<Student> getStudents() 
	{
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Poornima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));		
			
		return students;
	}
}