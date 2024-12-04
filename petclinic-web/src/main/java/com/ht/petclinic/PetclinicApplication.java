package com.ht.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ht.petclinic.repositories")
public class PetclinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetclinicApplication.class, args);
	}

}
