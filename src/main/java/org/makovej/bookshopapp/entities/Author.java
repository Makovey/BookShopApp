package org.makovej.bookshopapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long id;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String description;

    private String photo;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

}
