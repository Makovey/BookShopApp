package org.makovej.bookshopapp.repositories;

import org.makovej.bookshopapp.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
