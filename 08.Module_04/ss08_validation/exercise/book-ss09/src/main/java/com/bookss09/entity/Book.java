package com.bookss09.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
//    private long quantity;
    private String describe;
//    private Long bookLoanCode;

    public Book() {
    }

    public Book(String describe) {
        this.describe = describe;
    }

    public Book(Long bookId, String describe) {
        this.bookId = bookId;
        this.describe = describe;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
