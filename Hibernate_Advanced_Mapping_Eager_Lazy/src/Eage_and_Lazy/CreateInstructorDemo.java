package Eage_and_Lazy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo
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
			// Create the objects
			Instructor instructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");
			
			// Associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the instructor
			// Note: this will ALSO save the details object because of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);					
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
}