package org.ohgiraffers.jpa_practice.user.entity;

import jakarta.persistence.*;

@Entity(name = "user")
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_no;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_name")
    private String user_name;

    public User user_id(String val){
        this.user_id = val;
        return this;
    }

    public User user_password(String val){
        this.user_password = val;
        return this;
    }

    public User user_name(String val){
        this.user_name = val;
        return this;
    }

    public User builder(){
        return new User(user_no, user_id, user_password, user_name);
    }


    protected User (){}

    public User(int user_no, String user_id, String user_password, String user_name) {
        this.user_no = user_no;
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
    }

    public int getUser_no() {
        return user_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_no=" + user_no +
                ", user_id='" + user_id + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
