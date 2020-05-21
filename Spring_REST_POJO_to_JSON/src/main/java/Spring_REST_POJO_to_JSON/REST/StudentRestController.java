package Spring_REST_POJO_to_JSON.REST;

import Spring_REST_POJO_to_JSON.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api")
public class StudentRestController 
{
	// Private
	List<Student> students;


	// Public
	@PostConstruct
	public void loadData()
	{
		students = new ArrayList<>();

		students.add(new Student("Poornima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() 
	{
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		return students.get(studentId);
	}
}