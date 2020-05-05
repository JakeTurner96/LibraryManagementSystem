package org.jake.library.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class BookLoan extends BaseEntity {

    private Date dateOut;
    private Date dateDue;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    private Patron patron;
}
