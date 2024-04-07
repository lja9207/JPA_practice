package org.ohgiraffers.jpa_practice.rent.repository;

import org.ohgiraffers.jpa_practice.rent.entity.Rent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {


    @Query(value = "SELECT rent_no, rent_date, book_no, user_no, return_status FROM rent ORDER BY rent_no",
            nativeQuery = true)
    List<Rent> findAllRent();


    List<Rent> findByReturnStatus(String returnStatus);
}
