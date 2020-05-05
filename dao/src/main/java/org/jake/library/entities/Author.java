package org.jake.library.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorID;
    private String name;
    private Date dob;
    @OneToMany
    private Set<Book> authorBooks;
}
