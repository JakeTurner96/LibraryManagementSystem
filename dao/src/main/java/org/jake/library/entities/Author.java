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
public class Author extends NamedEntity {
    private Date dob;
    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Book> books;
}
