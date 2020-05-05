package org.jake.library.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Publisher extends NamedEntity {
    private String headquarters;
    private int yearFounded;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books;
}
