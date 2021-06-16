package org.makovej.bookshopapp.repositories;

import org.makovej.bookshopapp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
