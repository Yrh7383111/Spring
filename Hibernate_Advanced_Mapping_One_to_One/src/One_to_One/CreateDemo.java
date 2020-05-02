package One_to_One;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateDemo
{
	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try
		{
			// Initialization
			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");

//			Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
//			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
//
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
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			factory.close();
		}
	}
}