package org.makovej.bookshopapp.services;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.entities.Author;
import org.makovej.bookshopapp.entities.Book;
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
            book.setAuthor(getAuthorByAuthorId(rs.getInt("author_id")));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("price_old"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

    private String getAuthorByAuthorId(int authorId) {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors WHERE id=" + authorId, (ResultSet rs, int row) -> {
            Author author = new Author();
            author.setId(rs.getLong("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        });
        return authors.get(0).toString();
    }

}
