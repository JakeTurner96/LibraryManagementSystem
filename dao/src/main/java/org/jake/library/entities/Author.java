package org.jake.library.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Book> books;
}
