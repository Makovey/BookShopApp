package org.makovej.bookshopapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
@Api(description = "Entity representing a book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id generated automatically")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JsonIgnore
    private Author author;

    @Column(name = "pub_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @ApiModelProperty("date of book publication")
    private Date pubDate;

    @Column(nullable = false)
    private String title;

    @Column(name = "price")
    @JsonProperty("price")
    @ApiModelProperty("book price without discount")
    private Integer priceOld;

    @Column(name = "discount", nullable = false)
    @JsonProperty("discount")
    @ApiModelProperty("book price discount")
    private Integer price;

    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ApiModelProperty("mnemonic identity sequence of characters")
    private String slug;

    @Column(name = "is_bestseller")
    @ColumnDefault("0")
    @ApiModelProperty("if isBestseller - 1 so this book is considered to be bestseller")
    private Integer isBestseller;

    @ColumnDefault("0")
    private float rating;

    @OneToMany(mappedBy = "book")
    private List<Tag> tags;

    @OneToMany(mappedBy = "book")
    private List<BookReview> bookReviews;

    @OneToMany(mappedBy = "book")
    private List<Genre> genres;

}
