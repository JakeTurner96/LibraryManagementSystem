package org.jake.library.entities;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private float price;
    @NonNull
    private int pages;
    @NonNull
    private int copies;

    private enum Category {
        Fantasy,
        SciFi,
        Mystery,
        Romance,
        Horror,
        Thriller,
        Other
    }

    @NonNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NonNull
    private boolean available;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
}
