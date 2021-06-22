package shein.dmitriy.book.exception;

public class CatalogNotFoundException extends RuntimeException{

    public CatalogNotFoundException(String name){
        super("Catalog name = " + name + " not found");
    }
}
