package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"controller", "service", "dao", "entities"})
public class ApplicationConfig {

}
