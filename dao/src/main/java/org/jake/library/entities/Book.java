package org.jake.library.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookID;
    private String title;
    private float price;
    private int pages;
    private int copies;
    private boolean available;
    private int publisherID;
    private int authorID;
}
