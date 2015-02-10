package com.laprasdrum.androidjunit4.helper;

import com.laprasdrum.androidjunit4.Book;

public class BookTestHelper {
    public static Book JUnitPracticeBook() {
        Book book = new Book();
        book.title     = "JUnit実践入門";
        book.author    = "渡辺修司";
        book.price     = 3300;
        book.publisher = "技術評論社";

        return book;
    }
}
