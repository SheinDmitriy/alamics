package shein.dmitriy.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.book.dto.BookDto;
import shein.dmitriy.book.entitys.Book;
import shein.dmitriy.book.exception.UserNotFoundException;
import shein.dmitriy.book.repositories.BookRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private CatalogService catalogService;

    @Autowired
    public BookService(BookRepository bookRepository, CatalogService catalogService) {
        this.bookRepository = bookRepository;
        this.catalogService = catalogService;
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
    public Book addBook(BookDto bookDto){
        Book book =  Book.from(bookDto);
        book.setCatalog(catalogService.findByName(bookDto.getCatalog()));
        return bookRepository.saveAndFlush(book);
    }

    @Transactional
    public Book setBook(BookDto bookDto, Long id) {
        if(bookRepository.findById(id).isPresent()){
            Book book = Book.from(bookDto);
            book.setId(id);
            book.setCatalog(catalogService.findByName(bookDto.getCatalog()));
            return bookRepository.saveAndFlush(book);
        }
        throw new UserNotFoundException(id);
    }

    @Transactional
    public void deleteBook(Long id) {
        if(id != null)
        bookRepository.deleteById(id);
    }

    public List<BookDto> getAllBook() {
        return bookRepository.findAll()
                .stream()
                .map(BookDto::from)
                .collect(Collectors.toList());
    }

    public BookDto getBook(Long id) {
        return BookDto.from(bookRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id)));
    }
}
