package Eage_and_Lazy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class FetchJoinDemo
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
			
			// option 2: Hibernate query with HQL
			
			// get the instructor from db
			int id = 1;
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+ "JOIN FETCH i.courses "
															+ "where i.id=:instructorId",
															Instructor.class);

			// Set parameter on query
			query.setParameter("instructorId", id);
			
			// Execute query and get instructor
			Instructor instructor = query.getSingleResult();
			System.out.println("luv2code: Instructor: " + instructor);	
			
			// Commit transaction
			session.getTransaction().commit();
			
			// Close the session
			session.close();
			System.out.println("\nluv2code: The session is now closed!\n");
			
			// get courses for the instructor
			System.out.println("luv2code: Courses: " + instructor.getCourses());
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