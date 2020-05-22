package Spring_REST_Error_Handling.REST;



public class StudentNotFoundException extends RuntimeException
{
	public StudentNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public StudentNotFoundException(String message)
	{
		super(message);
	}

	public StudentNotFoundException(Throwable cause)
	{
		super(cause);
	}
}