package com.bookss09.entity;

import javax.persistence.*;

@Entity
public class BookBorrowCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer borrowCode;
    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book bookClass;

    public BookBorrowCard() {
    }

    public BookBorrowCard(Integer borrowCode, Book bookClass) {
        this.borrowCode = borrowCode;
        this.bookClass = bookClass;
    }

    public BookBorrowCard(Long id, Integer borrowCode, Book bookClass) {
        this.id = id;
        this.borrowCode = borrowCode;
        this.bookClass = bookClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(Integer borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBookClass() {
        return bookClass;
    }

    public void setBookClass(Book bookClass) {
        this.bookClass = bookClass;
    }
}
