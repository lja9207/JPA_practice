package org.ohgiraffers.jpa_practice.rent.service;

import org.modelmapper.ModelMapper;
import org.ohgiraffers.jpa_practice.book.dto.BookDTO;
import org.ohgiraffers.jpa_practice.book.entity.Book;
import org.ohgiraffers.jpa_practice.book.repository.BookRepository;
import org.ohgiraffers.jpa_practice.rent.builder.RentBuilder;
import org.ohgiraffers.jpa_practice.rent.dto.RentDTO;
import org.ohgiraffers.jpa_practice.rent.entity.Rent;
import org.ohgiraffers.jpa_practice.rent.repository.RentRepository;
import org.ohgiraffers.jpa_practice.user.entity.User;
import org.ohgiraffers.jpa_practice.user.repository.UserReporitory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentService {

    private final RentRepository rentRepository;
    private final BookRepository bookRepository;

    private final UserReporitory userRepository;

    private final ModelMapper modelMapper;

    public RentService(RentRepository rentRepository, BookRepository bookRepository, UserReporitory userRepository, ModelMapper modelMapper){
        this.rentRepository = rentRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<RentDTO> findRentList(){

        List<Rent> rentList = rentRepository.findAllRent();

        return rentList.stream()
                .map(rent -> modelMapper.map(rent, RentDTO.class))
                .collect(Collectors.toList());
    }

    public List<BookDTO> showBookList() {
        List<Book> bookList = bookRepository.findAll();

        return bookList.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    public BookDTO showBookInfo(int book_no) {
        System.out.println("book_no : " + book_no);
        Book bookInfo = bookRepository.findBookInfo(book_no);
        System.out.println("showBookInfo : bookNo에 따른 책 정보 : " + bookInfo);

        BookDTO bookDTO = modelMapper.map(bookInfo, BookDTO.class);

        return bookDTO;
    }

    @Transactional
    public void rentBook(RentDTO rentDTO, String id) {
        System.out.println("rentBook 컨트롤러에서 넘어온 데이터 : " + rentDTO);

        User userInfo = userRepository.findUserInfo(id);
        System.out.println("rentBook 유저 아이디로 찾은 유저 정보 : " + userInfo);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sdf.format(new Date());

        Rent rent = new RentBuilder()
                .book_no(rentDTO.getBook_no())
                .user_no(userInfo.getUser_no())
                .rent_date(currentDate)
                .returnStatus("N")
                .builder();


        rentRepository.save(rent);
    }

    public List<RentDTO> findRentByReturn() {
        String returnStatus = "N";

        List<Rent> rentList = rentRepository.findByReturnStatus(returnStatus);
        System.out.println("미반납 리스트 : " + rentList);

        return rentList.stream()
                .map(rent -> modelMapper.map(rent, RentDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateRent(RentDTO rent) {
        Rent returnBook = rentRepository.findById(rent.getRent_no()).orElseThrow(IllegalArgumentException::new);

        returnBook = returnBook.return_status("Y").builder();
    }
}
