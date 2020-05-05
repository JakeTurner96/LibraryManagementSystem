package org.jake.library.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanID;
    private Date dateOut;
    private Date dateDue;
    @OneToOne
    private Book loanedBook;
    @ManyToOne
    private Patron patron;
}
