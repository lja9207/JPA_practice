package org.ohgiraffers.jpa_practice.rent.dto;

public class RentDTO {

    private int rent_no;
    private String rent_date;
    private int book_no;
    private int user_no;
    private String return_status;

    public RentDTO() {
    }

    public RentDTO(int rent_no, String rent_date, int book_no, int user_no, String return_status) {
        this.rent_no = rent_no;
        this.rent_date = rent_date;
        this.book_no = book_no;
        this.user_no = user_no;
        this.return_status = return_status;
    }

    public int getRent_no() {
        return rent_no;
    }

    public void setRent_no(int rent_no) {
        this.rent_no = rent_no;
    }

    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public int getBook_no() {
        return book_no;
    }

    public void setBook_no(int book_no) {
        this.book_no = book_no;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getReturn_status() {
        return return_status;
    }

    public void setReturn_status(String return_status) {
        this.return_status = return_status;
    }

    @Override
    public String toString() {
        return "RentDTO{" +
                "rent_no=" + rent_no +
                ", rent_date='" + rent_date + '\'' +
                ", book_no=" + book_no +
                ", user_no=" + user_no +
                ", return_status='" + return_status + '\'' +
                '}';
    }
}
