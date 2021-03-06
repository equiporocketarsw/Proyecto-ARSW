package edu.eci.arsw.chillparkapi;

/**
 * ChillParkAPIApplication
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
/*@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})*/
@ComponentScan(basePackages  = {"edu.eci.arsw.chillpark.services","edu.eci.arsw.chillpark.controllers","edu.eci.arsw.chillpark.websocket"})
@EnableJpaRepositories("edu.eci.arsw.chillpark.repository")
@EntityScan("edu.eci.arsw.chillpark.model")
public class ChillParkAPIApplication {

    public static void main(String[] args) {
		SpringApplication.run(ChillParkAPIApplication.class, args);
    }
    
}