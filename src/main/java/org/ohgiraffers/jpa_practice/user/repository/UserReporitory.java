package org.ohgiraffers.jpa_practice.user.repository;


import org.ohgiraffers.jpa_practice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserReporitory extends JpaRepository<User, Integer> {

    @Query(value = "SELECT user_no, user_id, user_password, user_name FROM USER WHERE user_id =:user_id",
            nativeQuery = true)
    User findUserInfo(@Param("user_id") String id);
}
