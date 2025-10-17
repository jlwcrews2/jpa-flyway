package no.jlwcrews.jpa_with_sanity.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import no.jlwcrews.jpa_with_sanity.author.Author;
import no.jlwcrews.jpa_with_sanity.bookevent.BookEvent;
import no.jlwcrews.jpa_with_sanity.location.Location;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    private Long id;
    private String title;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany
    private List<BookEvent> events;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @JsonIgnoreProperties("books")
    private List<Author> authors;

    public Book() {
    }

    public Book(String title, Location location, List<Author> authors) {
        this.title = title;
        this.location = location;
        this.authors = authors;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
