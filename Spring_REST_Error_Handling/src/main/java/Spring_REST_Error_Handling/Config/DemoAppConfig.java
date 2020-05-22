package Spring_REST_Error_Handling.Config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
@ComponentScan("Spring_REST_Error_Handling")
public class DemoAppConfig implements WebMvcConfigurer
{

}