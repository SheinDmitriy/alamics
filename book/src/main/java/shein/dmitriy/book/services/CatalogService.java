package shein.dmitriy.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import shein.dmitriy.book.entitys.Catalog;
import shein.dmitriy.book.exception.CatalogNotFoundException;
import shein.dmitriy.book.repositories.CatalogRepository;

import java.util.List;

@Service
public class CatalogService {

    private CatalogRepository catalogRepository;

    @Autowired
    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<Catalog> findAll() {
       return catalogRepository.findAll();
    }

    public Catalog findByName(String name){
       return catalogRepository.findByName(name).orElseThrow(()-> new CatalogNotFoundException(name));
    }
}
