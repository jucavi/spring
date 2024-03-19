package com.example.ob04restdatajpa.controllers;

import com.example.ob04restdatajpa.entities.Book;
import com.example.ob04restdatajpa.repositories.BookRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookRepository repository;
    // Definimos el logger para la aplicaión
    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // Necesario para la iyección de dependencias
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    // CRUD sobre la entidad Book
    // Buscar todos los libros

    /**
     * Testing Swagger documentation
     * @return
     */
    @Tag(name="Get all books")
    @GetMapping("/api/books")
    public List<Book> findAll() {
        // recuperar y devolver los libros de la base de datos
        return repository.findAll();
    }

    // Buscar un solo libro en la base de datos según su Id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {

        Optional<Book> bookOpt = repository.findById(id);

        if (bookOpt.isPresent()) {
            return ResponseEntity.ok(bookOpt.get());
        }
        return ResponseEntity.notFound().build();

        // Opción 2
        // return bookOpt.map(ResponseEntity::ok)
        //        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo libro en la baae de datos
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders header) {

        // obtener las cabeceras
        System.out.println("Content-Type: " + header.get("Content-Type"));

        if (book.getId() != null) {
            log.warn("Trying to create a book with ID");
            System.out.printf("Trying to create a book with ID");
            return ResponseEntity.badRequest().build();
        }

        // guardar el libro recibido por parámetros en la base de datos
        Book result = repository.save(book);

        return ResponseEntity.ok(result);
    }

    // Actualizar un libro en la base de datos
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book) {

        if (book.getId() != null && !repository.existsById(book.getId())) {
            log.warn("Trying to update a book with wrong ID");
            return ResponseEntity.notFound().build();
        }

        Book result = repository.save(book);
        return ResponseEntity.ok(result);
    }

    // Borrar un libro de la base de datos
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        log.warn("Trying to delete a book with wrong ID");
        return ResponseEntity.notFound().build();
    }

    // Borrar todos los libros de la base de datos
    @DeleteMapping("/api/books")
    public ResponseEntity deleteAll() {

        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
