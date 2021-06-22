package shein.dmitriy.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shein.dmitriy.book.dto.BookDto;
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
    public ResponseEntity<List<BookDto>> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.addBook(bookDto), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Book> setBook(@RequestBody BookDto bookDto, @PathVariable Long id){
        return new ResponseEntity<>(bookService.setBook(bookDto, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity( HttpStatus.OK);
    }
}
