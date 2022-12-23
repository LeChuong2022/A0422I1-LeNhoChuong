package com.bookss09.service;

import com.bookss09.entity.BookBorrowCard;

import java.util.List;

public interface IBookBorrowCardService {
    void create(BookBorrowCard bookBorrowCard);

    BookBorrowCard findById(Long id);

    List<BookBorrowCard> findByAll();

    boolean remove(BookBorrowCard bookBorrowCard, Integer borrowCode);

    List<Integer> findBorrowCodeByBorrowCode(Integer borrowCode);
}
