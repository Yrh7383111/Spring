package Ordering_Aspect;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@Configuration
@EnableAspectJAutoProxy
@ComponentScan("Ordering_Aspect")
public class DemoConfig
{

}