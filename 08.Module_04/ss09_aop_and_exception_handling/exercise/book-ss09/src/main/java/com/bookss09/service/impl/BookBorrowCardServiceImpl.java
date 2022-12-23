package com.bookss09.service.impl;

import com.bookss09.entity.Book;
import com.bookss09.entity.BookBorrowCard;
import com.bookss09.repository.IBookBorrowCardRepository;
import com.bookss09.repository.IBookRepository;
import com.bookss09.service.IBookBorrowCardService;
import com.bookss09.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Random;

@Controller
public class BookBorrowCardServiceImpl implements IBookBorrowCardService {
    @Autowired
    IBookBorrowCardRepository bookBorrowCardRepository;

    @Autowired
    IBookService bookService;

    @Override
    public void create(BookBorrowCard bookBorrowCard) {
        bookBorrowCardRepository.save(bookBorrowCard);
        bookService.updateAfterLoan(bookBorrowCard.getBookClass().getId(), "borrow");
    }

    @Override
    public BookBorrowCard findById(Long id) {
        return bookBorrowCardRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookBorrowCard> findByAll() {
        return bookBorrowCardRepository.findAll();
    }

    @Override
    public boolean remove(BookBorrowCard bookBorrowCard, Integer borrowCode) {
       int b = bookBorrowCardRepository.deleteByBorrowCode(bookBorrowCard.getBookClass().getId() , borrowCode);
       if (b == 0)
           return false;
       else
           bookService.updateAfterLoan(bookBorrowCard.getBookClass().getId(), "give-back");
           return true;
    }

    @Override
    public List<Integer> findBorrowCodeByBorrowCode(Integer borrowCode) {
        return bookBorrowCardRepository.findBorrowCodeByBorrowCode(borrowCode);
    }
}
