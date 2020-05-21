package Spring_REST_POJO_to_JSON.Config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@EnableWebMvc
@ComponentScan("Spring_REST_POJO_to_JSON")
public class DemoAppConfig implements WebMvcConfigurer
{

}