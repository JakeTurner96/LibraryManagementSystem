package org.jake.library.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Book extends NamedEntity {

    private float price;
    private int pages;
    private int copies;
    private boolean available;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
}
