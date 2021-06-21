package shein.dmitriy.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shein.dmitriy.book.entitys.Book;
import shein.dmitriy.book.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ApiController {

    private BookService bookService;

    @Autowired
    public ApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addPerson(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Book> setBook(@RequestBody Book book, @PathVariable Long id){
        return new ResponseEntity<>(bookService.setBook(book, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletePerson(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity( HttpStatus.OK);
    }
}
