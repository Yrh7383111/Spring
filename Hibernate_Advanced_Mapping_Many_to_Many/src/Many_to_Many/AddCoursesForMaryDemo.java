package Many_to_Many;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class AddCoursesForMaryDemo
{
	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try 
		{			
			// Start a transaction
			session.beginTransaction();
				
			// Get the student mary from database
			int studentId = 2;
			Student student = session.get(Student.class, studentId);
			System.out.println("\nLoaded student: " + student);
			
			System.out.println("Courses: " + student.getCourses());
			
			// Create more courses 
			Course course1 = new Course("Rubik's Cube - How to Speed Cube");
			Course course2 = new Course("Atari 2600 - Game Development");
						
			// add student to courses
			course1.addStudent(student);
			course2.addStudent(student);
						
			// Save the courses
			System.out.println("\nSaving the courses ...");
			
			session.save(course1);
			session.save(course2);
						
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
}