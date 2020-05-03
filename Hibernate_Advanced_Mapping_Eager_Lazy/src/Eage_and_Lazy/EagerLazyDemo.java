package Eage_and_Lazy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class EagerLazyDemo
{
	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try
		{
			// Start a transaction
			session.beginTransaction();
			
			// Get the instructor from db
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id);
			System.out.println("luv2code: Instructor: " + tempInstructor);
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			// Commit transaction
			session.getTransaction().commit();
			
			// Close the session
			session.close();
			
			System.out.println("\nluv2code: The session is now closed!\n");

			// Option 1: call getter method while session is open
			
			// Get courses for the instructor
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			System.out.println("luv2code: Done!");
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