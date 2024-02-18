package org.example.payrolldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // The CommandLineRunner bean is a common interface in Spring Boot for
    // components that should run code after the application context has been
    // loaded.
    // This runner will request a copy of the EmployeeRepository automatically
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {

        // here two Entities are created and stored in the database
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Sven", "Schröder", "coder")));
            log.info("Preloading " + repository.save(new Employee("Anke", "Mauser", "mum")));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order-> {
                log.info("Preeloaded "+ order);
            });
        };
    }
}
