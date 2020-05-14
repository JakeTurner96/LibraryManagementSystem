package org.jake.library.entities;

import com.sun.istack.NotNull;
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
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate memberSince;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate membershipExpires;
    @NotNull
    private String password;

    public enum PatronType {
        ADMIN,
        PATRON,
        LIBRARIAN
    }

    @NonNull
    @Enumerated(EnumType.STRING)
    private PatronType patronType;
    @OneToMany
    @JoinColumn(name = "patron_id")
    private List<BookLoan> loans;
}
