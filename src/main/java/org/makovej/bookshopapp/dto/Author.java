package org.makovej.bookshopapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Author {
    private Long id;
    private Long bookId;
    private String firstName;
    private String lastName;
}
