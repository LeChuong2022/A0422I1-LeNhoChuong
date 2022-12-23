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
    public void update(Book book, int changeNumberBook) {
        book.setQuantity(book.getQuantity() + changeNumberBook);
        bookRepository.save(book);
    }

    @Override
    public void create(Book book) {
        bookRepository.save(book);
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
    public void updateAfterLoan(Long id, String option) {
        Book book = bookRepository.findById(id).orElse(null);
        int quantity = book.getQuantity();
        if (option.equals("borrow"))
            book.setQuantity(quantity - 1);
        else if (option.equals("give-back"))
            book.setQuantity(quantity + 1);
        bookRepository.save(book);
    }
}
