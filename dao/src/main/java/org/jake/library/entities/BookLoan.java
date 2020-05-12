package org.jake.library.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookLoan{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDue;
    @NonNull
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @NonNull
    @ManyToOne
    private Patron patron;
}
