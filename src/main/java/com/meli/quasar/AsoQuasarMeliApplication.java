package com.meli.quasar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.meli.quasar.*")
public class AsoQuasarMeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsoQuasarMeliApplication.class, args);
	}

}
