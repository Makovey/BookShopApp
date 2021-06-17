package org.makovej.bookshopapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users", schema = "public")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date registrationDate;

    @Column(nullable = false)
    @ColumnDefault("0")
    private double balance;

    @OneToMany(mappedBy = "user")
    private List<BookReview> bookReview;

}
