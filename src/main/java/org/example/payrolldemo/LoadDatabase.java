package org.example.payrolldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation in Spring is used to declare a class as a configuration class. A configuration class is responsible for defining and configuring the beans required for the application.
// In the context of Spring Boot, @Configuration is often used in conjunction with other annotations like @Bean to define beans and their dependencies.
@Configuration
public class LoadDatabase {
    
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // A  "bean" is a Java object that is managed by the Spring IoC (Inversion of Control) container. 
    // Beans are the basic building blocks of a Spring application, and they are typically Java objects that form the backbone of your application's business logic.
    // The CommandLineRunner bean is a common interface in Spring Boot for components that should run code after the application context has been loaded.
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Sven Schröder", "coder")));
            log.info("Preloading " + repository.save(new Employee("Anke Mauser", "mum")));
        };
    }
}
