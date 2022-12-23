package com.bookss09.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer quantity;
    @Column(length = 1000)
    private String describeBook;

    @OneToMany(mappedBy = "bookClass", fetch = FetchType.LAZY)
    private Set<BookBorrowCard> bookBorrowCards;

    public Book() {
    }

    public Book(String title, Integer quantity, String describeBook, Set<BookBorrowCard> bookBorrowCards) {
        this.title = title;
        this.quantity = quantity;
        this.describeBook = describeBook;
        this.bookBorrowCards = bookBorrowCards;
    }

    public Book(Long id, String title, Integer quantity, String describeBook, Set<BookBorrowCard> bookBorrowCards) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.describeBook = describeBook;
        this.bookBorrowCards = bookBorrowCards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescribeBook() {
        return describeBook;
    }

    public void setDescribeBook(String describeBook) {
        this.describeBook = describeBook;
    }

    public Set<BookBorrowCard> getBookBorrowCards() {
        return bookBorrowCards;
    }

    public void setBookBorrowCards(Set<BookBorrowCard> bookBorrowCards) {
        this.bookBorrowCards = bookBorrowCards;
    }
}
