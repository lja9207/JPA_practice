package org.ohgiraffers.jpa_practice.user.dto;

public class UserDTO {

    private int user_no;
    private String user_id;
    private String user_password;
    private String user_name;

    public UserDTO() {
    }

    public UserDTO(int user_no, String user_id, String user_password, String user_name) {
        this.user_no = user_no;
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "userDTO{" +
                "user_no=" + user_no +
                ", user_id='" + user_id + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
