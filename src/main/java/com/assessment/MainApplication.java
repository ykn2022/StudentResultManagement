package com.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@CrossOrigin
public class MainApplication {

    public static void main( String[] args ) {
        SpringApplication.run(MainApplication.class, args);
    }

}
