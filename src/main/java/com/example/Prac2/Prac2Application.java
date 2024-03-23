package com.example.Prac2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.Prac2"})
@EntityScan("com.example.Prac2.model")
@EnableJpaRepositories("com.example.Prac2.repository")
public class Prac2Application {

	public static void main(String[] args) {
		SpringApplication.run(Prac2Application.class, args);
	}

}
