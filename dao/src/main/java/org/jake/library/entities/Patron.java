package org.jake.library.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
}
