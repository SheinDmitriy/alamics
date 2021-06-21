package shein.dmitriy.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.book.entitys.Book;
import shein.dmitriy.book.exception.UserNotFoundException;
import shein.dmitriy.book.repositories.BookRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll().stream()
                .sorted(Comparator.comparing(Book::getId)).collect(Collectors.toList());
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional
    public void save(Book book) {
         bookRepository.save(book);
    }

    @Transactional
    public void delete(Book book) {
        if(book.getId() != null)
        bookRepository.deleteById(book.getId());
    }

    @Transactional
    public Book addBook(Book book){
        return bookRepository.saveAndFlush(book);
    }

    @Transactional
    public Book setBook(Book book, Long id) {
        if(bookRepository.findById(id).isPresent()){
            book.setId(id);
            return bookRepository.saveAndFlush(book);
        }
        throw new UserNotFoundException(id);
    }

    public void deleteBook(Long id) {
        if(id != null)
        bookRepository.deleteById(id);
    }
}
