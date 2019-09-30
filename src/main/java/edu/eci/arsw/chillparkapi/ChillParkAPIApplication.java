package edu.eci.arsw.chillparkapi;

/**
 * ChillParkAPIApplication
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "edu.eci.arsw.chillpark")
public class ChillParkAPIApplication {

    public static void main(String[] args) {
		SpringApplication.run(ChillParkAPIApplication.class, args);
    }
    
}