package org.jake.library.entities;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String headquarters;
    @NonNull
    private int yearFounded;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books;
}
