package com.project.anypost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AnypostApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnypostApplication.class, args);
	}

}
