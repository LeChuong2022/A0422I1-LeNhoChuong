package com.example.blogexpanse.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String contentSummary;
    @Column(length = 10000)
    private String content;
    private Date datePublish;
    @ManyToOne
//            (cascade = CascadeType.ALL) - thêm cái này thì xóa luôn bên bảng quan hệ kia
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category categoryName;

    public Blog() {
    }

    public Blog(String author, String title, String contentSummary, String content, Date datePublish, Category categoryName) {
        this.author = author;
        this.title = title;
        this.contentSummary = contentSummary;
        this.content = content;
        this.datePublish = datePublish;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentSummary() {
        return contentSummary;
    }

    public void setContentSummary(String contentSummary) {
        this.contentSummary = contentSummary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(Date datePublish) {
        this.datePublish = datePublish;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }
}
