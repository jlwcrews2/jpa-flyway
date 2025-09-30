package no.jlwcrews.jpa_with_sanity.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import no.jlwcrews.jpa_with_sanity.location.Location;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String author;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private Location location;

    public Book() {
    }

    public Book(String title, String author, Location location) {
        this.title = title;
        this.author = author;
        this.location = location;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
