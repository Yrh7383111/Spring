package One_to_Many_Uni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo
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
			Instructor instructor = session.get(Instructor.class, id);		
			
			// create some courses
			Course course1 = new Course("Air Guitar - The Ultimate Guide");
			Course course2 = new Course("The Pinball Masterclass");
			
			// add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			// save the courses
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