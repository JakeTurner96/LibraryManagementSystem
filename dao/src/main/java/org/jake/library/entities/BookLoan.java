package org.jake.library.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDue;
    @OneToOne
    private Book book;
    @ManyToOne
    private Patron patron;
}
