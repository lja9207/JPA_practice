package org.ohgiraffers.jpa_practice.rent.controller;

import lombok.extern.slf4j.Slf4j;
import org.ohgiraffers.jpa_practice.book.dto.BookDTO;
import org.ohgiraffers.jpa_practice.rent.dto.RentDTO;
import org.ohgiraffers.jpa_practice.rent.service.RentService;
import org.ohgiraffers.jpa_practice.user.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/rent")
public class RentController {

    private final RentService rentService;


    public RentController(RentService rentService){
        this.rentService = rentService;
    }


    @GetMapping("/list")
    public String rentList(Model model){

        List<RentDTO> rentList = rentService.findRentList();

        model.addAttribute("rentList", rentList);


        return "rent/list";
    }

    @GetMapping("/rent")
    public void rentPage(){}

    @GetMapping(value = "/book", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<BookDTO> showBookList(){
        return rentService.showBookList();
    }

    @GetMapping("/book/{book_no}")
    @ResponseBody
    public BookDTO getBookInfo(@PathVariable("book_no") int book_no){
        System.out.println("getBookInfo Controller 들어왔다");
        System.out.println("book_no : " + book_no);
        BookDTO bookInfo = rentService.showBookInfo(book_no);
        System.out.println("getBookInfo 서비스 나왔다");

        return bookInfo;
    }


    @PostMapping("/rent")
    public String rentBook(RentDTO rentDTO, @RequestParam("user_id") String id){
        System.out.println("뷰에서 가져온 데이터 : " + rentDTO);


        rentService.rentBook(rentDTO, id);

        return "redirect:/rent/list";
    }

    //미반납 도서 목록
    @GetMapping("/list/noreturn")
    public String findRentByReturn(Model model){
        List<RentDTO> resultRent = rentService.findRentByReturn();
        System.out.println("RentController 미반납 리스트 : " + resultRent);

        model.addAttribute("rentList", resultRent);

        return "rent/list";
    }

    @GetMapping("/return")
    public String goReturn(){
        return "/rent/return";
    }

    @PostMapping("/return")
    public String returnBook(RentDTO rent){
        rentService.updateRent(rent);

        return "redirect:/rent/list";
    }
}
