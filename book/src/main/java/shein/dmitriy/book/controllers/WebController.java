package shein.dmitriy.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shein.dmitriy.book.entitys.Book;
import shein.dmitriy.book.services.BookService;
import shein.dmitriy.book.services.CatalogService;

@Controller
@RequestMapping(value = "/")
public class WebController {

    private BookService bookService;
    private CatalogService catalogService;

    @Autowired
    public WebController(BookService bookService, CatalogService catalogService) {
        this.bookService = bookService;
        this.catalogService = catalogService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("books", bookService.findAll());
        return "main";
    }

    @GetMapping("/{id}")
    public String editBook(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("catalogs", catalogService.findAll());
        return "book_form";
    }

    @GetMapping("/form")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("catalogs", catalogService.findAll());
        return "book_form";
    }

    @PostMapping("/delete")
    public String deleteBook(Book book, BindingResult result) {

        bookService.delete(book);
        return "redirect:/";
    }

    @PostMapping("/form")
    public String saveBook(Book book){
        bookService.save(book);
        return "redirect:/";
    }
}
