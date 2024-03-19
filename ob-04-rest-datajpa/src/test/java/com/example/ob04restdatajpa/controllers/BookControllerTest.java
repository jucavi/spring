package com.example.ob04restdatajpa.controllers;

import com.example.ob04restdatajpa.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @BeforeEach
    void setUp() {

        restTemplateBuilder = restTemplateBuilder
                .rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<List> response = testRestTemplate.getForEntity("/api/books", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void findById() {
        //ResponseEntity<List> response = testRestTemplate.getForEntity("/api/books/1", List.class);

        //assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "La victoria de la luna",
                    "author": "Desconocido",
                    "pages": 218,
                    "price": 12.5,
                    "release": "2001-09-03",
                    "online": false
                }
                """;

        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        ResponseEntity<Book> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, requestEntity, Book.class);

        Book result = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, result.getId());
        assertEquals(218, result.getPages());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }

}