package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"controller", "service", "dao", "entities", "aspect"})
@EnableAspectJAutoProxy
public class ApplicationConfig {

}
