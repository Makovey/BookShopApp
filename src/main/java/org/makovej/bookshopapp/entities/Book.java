package org.makovej.bookshopapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "books", schema = "public")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @Column(nullable = false)
    private String title;

    private String priceOld;

    @Column(nullable = false)
    private String price;

    private String image;

    private String description;

    @ColumnDefault("false")
    private boolean bestseller;

    @ColumnDefault("0")
    private float rating;

    @OneToMany(mappedBy = "book")
    private List<Tag> tags;

    @OneToMany(mappedBy = "book")
    private List<BookReview> bookReviews;

    @OneToMany(mappedBy = "book")
    private List<Genre> genres;

}
