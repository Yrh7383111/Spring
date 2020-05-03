package One_to_Many_Uni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo
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
			// Start a transaction
			session.beginTransaction();

			// Get instructor by primary key / id
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Found instructor: " + instructor);
			
			// Delete the instructors
			if (instructor != null)
			{
				System.out.println("Deleting: " + instructor);
				
				// Note: will ALSO delete associated "details" object because of CascadeType.ALL
				session.delete(instructor);				
			}
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}
}