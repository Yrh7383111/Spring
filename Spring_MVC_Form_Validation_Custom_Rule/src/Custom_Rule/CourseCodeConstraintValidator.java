package Custom_Rule;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>
{
	// Private
	private String[] coursePrefixes;


	// Public
	@Override
	public void initialize(CourseCode courseCode)
	{
		coursePrefixes = courseCode.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext)
	{
		boolean result = false;

		if (code != null)
		{
			for (String element : coursePrefixes)
			{
				if (code.startsWith(element))
				{
					result = true;
					break;
				}
			}
		}
		else {
			result = true;
		}

		return result;
	}
}