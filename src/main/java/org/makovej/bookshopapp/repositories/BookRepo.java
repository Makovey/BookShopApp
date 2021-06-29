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

    @Query(value = "SELECT b.id, b.description, b.image, b.is_bestseller, b.discount, b.price, b.pub_date, b.rating, b.slug, b.title, b.author_id " +
            "FROM books as b JOIN book_info as bi on b.id = bi.book_id ORDER BY bi.calculate_popular DESC", nativeQuery = true)
    Page<Book> findBooksByCalculatedPopularityDesc(Pageable nextPage);

}
