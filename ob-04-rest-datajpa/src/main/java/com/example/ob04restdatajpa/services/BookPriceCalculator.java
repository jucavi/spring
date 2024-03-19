package com.example.ob04restdatajpa.services;

import com.example.ob04restdatajpa.entities.Book;

public class BookPriceCalculator {

    public Double calculatePrice(Book book) {
        Double price = book.getPrice();

        if (price == null) return 0.0;

        return book.isOnline() ? price + price * 0.01 : price;
    }
}
