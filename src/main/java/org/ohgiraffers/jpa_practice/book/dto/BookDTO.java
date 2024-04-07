package org.ohgiraffers.jpa_practice.book.dto;

public class BookDTO {

    private int book_no;
    private String book_title;
    private String book_author;
    private String book_publisher;


    public BookDTO() {
    }

    public BookDTO(int book_no, String book_title, String book_author, String book_publisher) {
        this.book_no = book_no;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_publisher = book_publisher;
    }

    public int getBook_no() {
        return book_no;
    }

    public void setBook_no(int book_no) {
        this.book_no = book_no;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "book_no=" + book_no +
                ", book_title='" + book_title + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_publisher='" + book_publisher + '\'' +
                '}';
    }
}
