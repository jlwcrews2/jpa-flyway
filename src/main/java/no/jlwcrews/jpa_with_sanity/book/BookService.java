package no.jlwcrews.jpa_with_sanity.book;

import no.jlwcrews.jpa_with_sanity.location.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final LocationService locationService;
    private final BookRepo repo;

    public BookService(LocationService locationService, BookRepo repo) {
        this.locationService = locationService;
        this.repo = repo;
    }

    public Book createBook(BookDto book) {
        var location = locationService.findById(book.locationId());
        var newBook = new Book(book.title(), book.author(), location);
        return repo.save(newBook);
    }

    public Book getBook(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Book> getBooks() {
        return repo.findAll();
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
