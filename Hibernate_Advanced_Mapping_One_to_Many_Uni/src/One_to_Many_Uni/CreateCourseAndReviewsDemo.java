package One_to_Many_Uni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateCourseAndReviewsDemo
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
			
			// Create a course
			Course course = new Course("Pacman - How To Score One Million Points");
			
			// Add some reviews
			course.addReview(new Review("Great course ... loved it!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("What a dumb course, you are an idiot!"));
						
			// Save the course ... and leverage the cascade all :-)
			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			
			session.save(course);
			
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