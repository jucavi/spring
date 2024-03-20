package com.example.ob06springsecuritycifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class Ob06SpringSecurityCifradoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ob06SpringSecurityCifradoApplication.class, args);

		UserRepository repository = context.getBean(UserRepository.class);

		// Creamos un bean de password encoder
		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

		User user = new User(null, "user", encoder.encode("password"));

		repository.save(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
