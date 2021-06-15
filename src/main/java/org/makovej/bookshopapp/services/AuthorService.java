package org.makovej.bookshopapp.services;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.entities.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final JdbcTemplate jdbcTemplate;

    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int row) -> {
            Author author = new Author();
            author.setId(rs.getLong("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        });
        return authors
                .stream()
                .collect(Collectors.groupingBy((Author a) -> a.getLastName().substring(0,1)));
    }

}
