package shein.dmitriy.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shein.dmitriy.book.entitys.Book;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    private String name;

    private String artist;

    private Date releaseDate;

    private String catalog;

    public static BookDto from(Book book){
        return BookDto.builder()
                .name(book.getName())
                .artist(book.getArtist())
                .releaseDate(book.getReleaseDate())
                .catalog(book.getCatalog().getName())
                .build();
    }
}
