package Params_and_Mappings;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello")
public class HelloWorldController
{

	// Need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
		
	// Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}

	// New a controller method to read form data and
	// Add data to the model
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name,
										  Model model) 
	{
		// Convert the data to all caps
		name = name.toUpperCase();

		// Create the message
		String result = "Hey My Friend from v3! " + name;

		// Add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}
}