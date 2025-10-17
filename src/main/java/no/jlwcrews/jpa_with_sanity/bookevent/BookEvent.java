package no.jlwcrews.jpa_with_sanity.bookevent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import no.jlwcrews.jpa_with_sanity.book.Book;

import java.time.LocalDateTime;

@Entity
public class BookEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_event_gen")
    @SequenceGenerator(name = "book_event_gen", sequenceName = "book_event_seq", allocationSize = 1)
    private Long id;
    private BookEventType eventType;
    private Long userId;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BookEvent(BookEventType eventType, Long userId, Book book) {
        this.eventType = eventType;
        this.userId = userId;
        this.timestamp = LocalDateTime.now();
        this.book = book;
    }

    public BookEvent() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookEventType getEventType() {
        return eventType;
    }

    public void setEventType(BookEventType eventType) {
        this.eventType = eventType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
