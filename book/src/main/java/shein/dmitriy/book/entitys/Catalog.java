package shein.dmitriy.book.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    Long id;

    @Column(name = "name")
    String name;
}
