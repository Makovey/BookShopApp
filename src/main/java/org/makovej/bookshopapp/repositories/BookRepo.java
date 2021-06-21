package org.makovej.bookshopapp.repositories;

import org.makovej.bookshopapp.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findBooksByAuthorFirstNameContaining(String authorFirstName);

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceOldBetween(Integer min, Integer max);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findBooksByTitleContaining(String bookTitle, Pageable nextPage);

    Page<Book> findBooksByOrderByPubDateDesc(Pageable nextPage);

    Page<Book> findBooksByOrderByRatingDesc(Pageable nextPage);

    Page<Book> findBooksByPubDateBetween(Date from, Date to, Pageable nextPage);

}
