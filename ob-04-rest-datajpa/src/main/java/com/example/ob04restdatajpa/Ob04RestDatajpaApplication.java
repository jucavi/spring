package com.example.ob04restdatajpa;

import com.example.ob04restdatajpa.entities.Book;
import com.example.ob04restdatajpa.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

}
