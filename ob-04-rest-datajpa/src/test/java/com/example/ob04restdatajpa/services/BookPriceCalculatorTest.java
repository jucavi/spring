package com.example.ob04restdatajpa.services;

import com.example.ob04restdatajpa.entities.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    @DisplayName(value = "Cálculo del precio del libro")
    void calculatePrice() {

        // Configuración de la prueba
        Book book = new Book(1L, "Título1", "a1", 500, 50.0, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // Ejecución del elemento a probar
        double price = calculator.calculatePrice(book);

        // Comprobación de aserciones
        assertTrue(price > 0);
        assertEquals(50.5, price);
    }

    @Test
    void calculateNullPriceTest() {
        Book book = new Book(1L, "Título1", "a1", 500, null, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // Ejecución del elemento a probar
        double price = calculator.calculatePrice(book);
        assertEquals(0, price);
    }
}