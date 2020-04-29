package Number_and_Regex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController
{
	@RequestMapping("/")
	public String showPage()
	{
		return "main-menu";
	}
}
