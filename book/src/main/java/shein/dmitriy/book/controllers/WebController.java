package shein.dmitriy.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shein.dmitriy.book.services.BookService;

@Controller
@RequestMapping(value = "/")
public class WebController {

    private BookService bookService;

    @Autowired
    public WebController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("books", bookService.findAll());
        return "main";
    }
}
