package org.ohgiraffers.jpa_practice.book.service;


import org.modelmapper.ModelMapper;
import org.ohgiraffers.jpa_practice.book.dto.BookDTO;
import org.ohgiraffers.jpa_practice.book.entity.Book;
import org.ohgiraffers.jpa_practice.book.repository.BookRepository;
import org.ohgiraffers.jpa_practice.user.dto.UserDTO;
import org.ohgiraffers.jpa_practice.user.entity.User;
import org.ohgiraffers.jpa_practice.user.repository.UserReporitory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserReporitory userRepository;

    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, UserReporitory userRepository, ModelMapper modelMapper){
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookDTO> showBookList(){
        System.out.println("BookService 진입함");
        List<Book> bookList = bookRepository.findBookList();

        return bookList.stream()
                        .map(book -> modelMapper.map(book, BookDTO.class))
                        .collect(Collectors.toList());
    }

    public UserDTO findUserByInfo(String userId) {

            User user = userRepository.findUserInfo(userId);

            return modelMapper.map(user, UserDTO.class);

    }

    @Transactional
    public void deleteBook(int bookNo) {

        bookRepository.deleteById(bookNo);
    }
}
