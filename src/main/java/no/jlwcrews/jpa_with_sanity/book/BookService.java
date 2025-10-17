package no.jlwcrews.jpa_with_sanity.book;

import no.jlwcrews.jpa_with_sanity.author.Author;
import no.jlwcrews.jpa_with_sanity.author.AuthorService;
import no.jlwcrews.jpa_with_sanity.exception.BookNotFoundException;
import no.jlwcrews.jpa_with_sanity.location.LocationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final LocationService locationService;
    private final BookRepo repo;
    private final AuthorService authorService;

    public BookService(LocationService locationService, BookRepo repo, AuthorService authorService) {
        this.locationService = locationService;
        this.repo = repo;
        this.authorService = authorService;
    }

    public Book createBook(BookDto book) {
        var location = locationService.findById(book.locationId());
        List<Author> authors = new ArrayList<>();
        book.authorIds().forEach(a -> authors.add(authorService.getAuthor(a)));
        var newBook = new Book(book.title(), location, authors);
        return repo.save(newBook);
    }

    public Book getBook(Long id) {
        return repo.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
    }

    public List<Book> getBooks() {
        return repo.findAll();
    }

    public List<Book> getBooksByPage(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repo.findAll(pageable).getContent();
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }

}
