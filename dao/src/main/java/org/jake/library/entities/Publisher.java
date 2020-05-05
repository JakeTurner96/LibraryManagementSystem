package org.jake.library.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherID;
    private String name;
    private String headquarters;
    private int yearFounded;
    @OneToMany
    private Set<Book> publishedBooks;
}
