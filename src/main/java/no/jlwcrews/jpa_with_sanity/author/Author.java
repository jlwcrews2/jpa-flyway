package no.jlwcrews.jpa_with_sanity.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import no.jlwcrews.jpa_with_sanity.book.Book;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @SequenceGenerator(name = "author_seq", sequenceName = "author_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors")
    private List<Book> books;

    public Author(String firstName, String lastName, String email, List<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.books = books;
    }

    public Author() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
