package shein.dmitriy.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shein.dmitriy.book.entitys.Catalog;

import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    Optional<Catalog> findByName(String name);
}
