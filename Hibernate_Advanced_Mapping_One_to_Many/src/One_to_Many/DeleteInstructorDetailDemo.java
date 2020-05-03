package One_to_Many;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo
{
	public static void main(String[] args)
	{
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try
		{
			// Start a transaction
			session.beginTransaction();

			// Get the instructor detail object
			int id = 4;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			System.out.println("instructorDetail: " + instructorDetail);
			System.out.println("the associated instructor: " + instructorDetail.getInstructor());
			
			// Now let's delete the instructor detail
			System.out.println("Deleting instructorDetail: " + instructorDetail);

			// Remove the associated object reference
			// Break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			
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