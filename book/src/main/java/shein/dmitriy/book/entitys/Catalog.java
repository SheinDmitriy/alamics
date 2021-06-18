package shein.dmitriy.book.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private Long id;

    @Column(name = "name")
    private String name;
}
