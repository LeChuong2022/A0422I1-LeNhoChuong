package com.bookss09.service;

import com.bookss09.entity.Book;

import java.util.List;

public interface IBookService {
    void update(Book book, int changNumberBook);
    void create(Book book);

    List<Book> findAll();

    Book findById(Long id);

    void updateAfterLoan(Long id, String option);
}
