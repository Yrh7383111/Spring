package One_to_Many;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// Annotate the class as an entity and map to db table
@Entity
@Table(name="instructor")
public class Instructor
{
	// Define the fields
	// Annotate the fields with db column names
	// Set up mapping to InstructorDetail entity
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;

	@OneToMany(mappedBy="instructor", cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 				  CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;


	// Public
	public Instructor()
	{
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.instructorDetail = null;
		this.courses = new ArrayList<Course>();
	}

	public Instructor(String firstName, String lastName, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Instructor(String firstName, String lastName, String email, InstructorDetail instructorDetail, List<Course> courses)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetail = instructorDetail;
		this.courses = courses;
	}

	// Generate getter/setter methods
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public InstructorDetail getInstructorDetail()
	{
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail)
	{
		this.instructorDetail = instructorDetail;
	}

	public List<Course> getCourses()
	{
		return courses;
	}

	public void setCourses(List<Course> courses)
	{
		this.courses = courses;
	}

	// Add convenience methods for bi-directional relationship
	public void add(Course course)
	{
		if (courses == null)
		{
			courses = new ArrayList<Course>();
		}
		else {
			courses.add(course);
			course.setInstructor(this);
		}
	}

	// Generate toString() method
	@Override
	public String toString()
	{
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", instructorDetail=" + instructorDetail + "]";
	}
}