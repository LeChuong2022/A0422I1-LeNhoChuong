package com.bookss09.service;

import com.bookss09.entity.Book;

import java.util.List;

public interface IBookService {
    void save(Book book);

    void update(Book book);

    List<Book> findAll();

    Book findById(Long id);

    void updateAfterLoan(Book book, String option);


}
