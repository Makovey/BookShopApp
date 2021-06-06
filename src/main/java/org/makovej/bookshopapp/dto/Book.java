package org.makovej.bookshopapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private Long id;
    private String author;
    private String title;
    private String priceOld;
    private String price;
}
