package org.makovej.bookshopapp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authors", schema = "public")
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @OneToMany
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ToString.Exclude private List<Book> bookList;


}
