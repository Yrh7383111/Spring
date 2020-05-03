package One_to_Many_Uni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class GetCourseAndReviewsDemo
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
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try
		{
			// Start a transaction
			session.beginTransaction();

			// Get the course
			int id = 10;
			Course course = session.get(Course.class, id);
			System.out.println(course);
			
			System.out.println(course.getReviews());
			
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