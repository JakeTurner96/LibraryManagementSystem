package org.jake.library.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Patron extends NamedEntity {
    private String email;
    private Date memberSince;
    private Date membershipExpires;
    private boolean patronType;
    @OneToMany
    @JoinColumn(name = "patron_id")
    private List<BookLoan> loans;
}
