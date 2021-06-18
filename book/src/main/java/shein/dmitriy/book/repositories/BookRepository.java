package shein.dmitriy.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shein.dmitriy.book.entitys.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
