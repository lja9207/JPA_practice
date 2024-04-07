package org.ohgiraffers.jpa_practice.rent.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity(name = "rent")
@Table(name = "rent" )
public class Rent {

    @Id
    @Column(name = "rent_no")
    private int rent_no;

    @Column(name = "rent_date")
    private String rent_date;

    @Column(name = "book_no")
    private int book_no;

    @Column(name = "user_no")
    private int user_no;

    @Column(name = "return_status")
    private String returnStatus;

    public Rent rent_date(String val){
        this.rent_date = val;
        return this;
    }

    public Rent book_no(int val){
        this.book_no = val;
        return this;
    }

    public Rent user_no(int val){
        this.user_no = val;
        return this;
    }

    public Rent return_status(String val){
        this.returnStatus = val;
        return this;
    }

    public Rent builder(){
        return new Rent(rent_no, rent_date, book_no, user_no, returnStatus);
    }

    protected Rent(){}

    public Rent(int rent_no, String rent_date, int book_no, int user_no, String return_status) {
        this.rent_no = rent_no;
        this.rent_date = rent_date;
        this.book_no = book_no;
        this.user_no = user_no;
        this.returnStatus = return_status;
    }

    public int getRent_no() {
        return rent_no;
    }

    public String getRent_date() {
        return rent_date;
    }

    public int getBook_no() {
        return book_no;
    }

    public int getUser_no() {
        return user_no;
    }

    public String getReturn_status() {
        return returnStatus;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rent_no=" + rent_no +
                ", rent_date='" + rent_date + '\'' +
                ", book_no=" + book_no +
                ", user_no=" + user_no +
                ", return_status='" + returnStatus + '\'' +
                '}';
    }
}
