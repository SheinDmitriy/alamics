package shein.dmitriy.book.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.catalog.Catalog;
import java.time.LocalDateTime;

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
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "release_date")
    LocalDateTime releaseDate;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    Catalog catalog;
}
