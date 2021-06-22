package shein.dmitriy.book.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import shein.dmitriy.book.dto.BookDto;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@Builder
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "artist")
    private String artist;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    public static Book from(BookDto book){
        return Book.builder()
                .name(book.getName())
                .artist(book.getArtist())
                .releaseDate(book.getReleaseDate())
                .build();
    }
}
