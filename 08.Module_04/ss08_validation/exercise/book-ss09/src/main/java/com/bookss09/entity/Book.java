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
    private long quantity;
    private String describe;
    private Long bookLoanCode;

    public Book() {
    }

    public Book(long quantity, String describe, Long bookLoanCode) {
        this.quantity = quantity;
        this.describe = describe;
        this.bookLoanCode = bookLoanCode;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Long getBookLoanCode() {
        return bookLoanCode;
    }

    public void setBookLoanCode(Long bookLoanCode) {
        this.bookLoanCode = bookLoanCode;
    }
}
