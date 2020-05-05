package org.jake.library.entities;

import lombok.*;

import javax.persistence.*;

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
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
}
