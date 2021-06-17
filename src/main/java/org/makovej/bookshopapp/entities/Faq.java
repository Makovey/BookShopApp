package org.makovej.bookshopapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@Entity
@Table(name = "faq", schema = "public")
@NoArgsConstructor
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int sortIndex;

    private String question;

    private String answer;
}
