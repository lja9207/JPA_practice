package org.ohgiraffers.jpa_practice.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "book")
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_no")
    private int book_no;

    @Column(name = "book_title")
    private String book_title;

    @Column(name = "book_author")
    private String book_author;

    @Column(name = "book_publisher")
    private String book_publisher;

    public Book book_title(String val){
        this.book_title = val;
        return this;
    }

    public Book book_author(String val){
        this.book_author = val;
        return this;
    }

    public Book book_publisher(String val){
        this.book_publisher = val;
        return this;
    }

    public Book builder(){
        return new Book(book_no, book_title, book_author, book_publisher);
    }

    protected Book() {}


    public Book(int book_no, String book_title, String book_author, String book_publisher) {
        this.book_no = book_no;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_publisher = book_publisher;
    }

    public int getBook_no() {
        return book_no;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_no=" + book_no +
                ", book_title='" + book_title + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_publisher='" + book_publisher + '\'' +
                '}';
    }
}
