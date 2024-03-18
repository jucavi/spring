package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Main.class, args);
		CarRepository repository = context.getBean(CarRepository.class);

		System.out.println("Coches en la base de datos: " + repository.count());

		Car car = new Car("ibiza", 95);
		repository.save(car);

		System.out.println("Coches en la base de datos: " + repository.count());
	}

}
