package com.bookss09.service.impl;

import com.bookss09.entity.Book;
import com.bookss09.repository.IBookRepository;
import com.bookss09.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public void save(Book book) {
        long min = 10000;
        long max = 99999;
        long randomNumber = (long) Math.floor(Math.random() * (max - min + 1) + min);
        book.setBookLoanCode(randomNumber);
        bookRepository.save(book);

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAfterLoan(Book book, String option) {
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        if (option.equals("loan"))
            book1.get().setQuantity(book1.get().getQuantity() - 1);
        else if (option.equals("return"))
            book1.get().setQuantity(book1.get().getQuantity() + 1);
        bookRepository.save(book1.get());
    }
}
