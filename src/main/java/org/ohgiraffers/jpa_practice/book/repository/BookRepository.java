package org.ohgiraffers.jpa_practice.book.repository;

import org.ohgiraffers.jpa_practice.book.dto.BookDTO;
import org.ohgiraffers.jpa_practice.book.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    @Query(value = "SELECT book_no, book_title, book_author, book_publisher FROM book ORDER BY book_no",
            nativeQuery = true)
    List<Book> findBookList();

    @Query(value = "SELECT book_no, book_title, book_author, book_publisher FROM book WHERE book_no =:book_no",
            nativeQuery = true)

    Book findBookInfo(@Param("book_no") int book_no);


}
