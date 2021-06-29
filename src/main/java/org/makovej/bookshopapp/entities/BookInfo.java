package org.makovej.bookshopapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_info", schema = "public")
@NoArgsConstructor
public class BookInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ColumnDefault("0")
    private Integer quantityOfSales;

    @ColumnDefault("0")
    private Integer quantityOfPostponed;

    @ColumnDefault("0")
    private Integer quantityInCart;

    @ColumnDefault("0")
    @Column(name = "calculate_popular")
    private Double calculatePopular;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

}
