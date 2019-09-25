package edu.eci.arsw.chillparkapi;

/**
 * ChillParkAPIApplication
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.blueprints"})
public class ChillParkAPIApplication {

    public static void main(String[] args) {
		SpringApplication.run(ChillParkAPIApplication.class, args);
    }
    
}