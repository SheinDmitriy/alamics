package shein.dmitriy.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.book.repositories.CatalogRepository;

@Service
public class CatalogService {

    private CatalogRepository catalogRepository;

    @Autowired
    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }
}
