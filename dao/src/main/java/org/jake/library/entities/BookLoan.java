package org.jake.library.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class BookLoan{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOut;
    @NonNull
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