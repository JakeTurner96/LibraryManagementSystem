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
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patronID;
    private String name;
    private String email;
    private Date memberSince;
    private Date membershipExpires;
    private boolean patronType;
    @OneToMany
    private Set<BookLoan> patronLoans;
}
