package org.makovej.bookshopapp.services;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.dto.Author;
import org.makovej.bookshopapp.dto.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final JdbcTemplate jdbcTemplate;

    public List<Author> getAllAuthors() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int row) -> {
            Author author = new Author();
            author.setBookId(rs.getLong("bookId"));
            author.setName(rs.getString("name"));
            return author;
        });
        return new ArrayList<>(authors);
    }

}
