package com.example.ob04restdatajpa;

import com.example.ob04restdatajpa.entities.Book;
import com.example.ob04restdatajpa.repositories.BookRepository;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class Ob04RestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ob04RestDatajpaApplication.class, args);

		BookRepository repository = context.getBean(BookRepository.class);

		// CRUD
		// crear un libro
		Book book1 = new Book(null, "El paramo en llamas", "Juan Rulfo", 512, 22.5, LocalDate.of(2024, 2, 21), true);
		Book book2 = new Book(null, "El tambor de hojalata", "Gunter Grass", 912, 22.5, LocalDate.of(2004, 3, 22), true);
		System.out.println("Número de libros en la base de datos: " + repository.findAll().size());

		// almacenar un libro
		repository.save(book1);
		repository.save(book2);
		System.out.println("Número de libros en la base de datos: " + repository.findAll().size());

		// recuperar un libro
		Optional b = repository.findById(1L);
		System.out.println("Libro recuperado: " + b);

		// borrar un libro
		// repository.delete(book1);
	}

	// INFORMACIÓN SWAGGER
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Jucavi API")
						.description("This is a sample of API REST. You can find out more about Swagger at [http://swagger.io](http://swagger.io)")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
