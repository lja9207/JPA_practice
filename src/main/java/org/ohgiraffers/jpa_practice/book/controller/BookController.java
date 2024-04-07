package org.ohgiraffers.jpa_practice.book.controller;

import lombok.extern.slf4j.Slf4j;
import org.ohgiraffers.jpa_practice.book.dto.BookDTO;
import org.ohgiraffers.jpa_practice.book.service.BookService;
import org.ohgiraffers.jpa_practice.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    @GetMapping("/list")
    public String bookList(Model model){

        System.out.println("BookController 진입함");

        List<BookDTO> bookList = bookService.showBookList();

        model.addAttribute("bookList", bookList);

        return "book/list";
    }

    @GetMapping("/delete")
    public String goDelete(){
        return "/book/delete";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("book_no") int book_no,
                             @RequestParam("user_id") String user_id,
                             @RequestParam("user_password") String user_password, Model model){

        try {

            UserDTO user = bookService.findUserByInfo(user_id);
            if(user.getUser_password() == user_password || user.getUser_password().equals(user_password)){
                bookService.deleteBook(book_no);
            }

        }catch(NullPointerException e)
        {
            e.printStackTrace();
        }

        return "redirect:/book/list";
    }
}
