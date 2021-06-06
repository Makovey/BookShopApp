package org.makovej.bookshopapp.services;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.dto.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
         List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int row) -> {
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

}
