package org.ohgiraffers.jpa_practice.rent.builder;

import org.ohgiraffers.jpa_practice.rent.entity.Rent;

public class RentBuilder {

    private int rent_no;
    private int book_no;
    private int user_no;
    private String rent_date;
    private String returnStatus;

    public RentBuilder(){}

    public RentBuilder(int book_no, int user_no){
        this.book_no = book_no;
        this.user_no = user_no;
    }

    public RentBuilder(String rent_date){
        this.rent_date = rent_date;
    }

    public RentBuilder(Rent rent) {
        this.rent_no = rent_no;
        this.book_no = book_no;
        this.user_no = user_no;
        this.rent_date = rent_date;
        this.returnStatus = returnStatus;
    }

    public RentBuilder rent_no(int val){
        this.rent_no = val;
        return this;
    }

    public RentBuilder book_no(int val){
        this.book_no = val;
        return this;
    }

    public RentBuilder user_no(int val){
        this.user_no = val;
        return this;
    }

    public RentBuilder rent_date(String val){
        this.rent_date = val;
        return this;
    }

    public RentBuilder returnStatus(String val){
        this.returnStatus = val;
        return this;
    }

    public Rent builder(){
        return new Rent(rent_no, rent_date, book_no, user_no, returnStatus);
    }
}
