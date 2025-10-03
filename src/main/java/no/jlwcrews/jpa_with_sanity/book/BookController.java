package no.jlwcrews.jpa_with_sanity.book;

import no.jlwcrews.jpa_with_sanity.testdata.TestData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;
    private final TestData testData;

    public BookController(BookService bookService, TestData testData) {
        this.bookService = bookService;
        this.testData = testData;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        var result = bookService.getBook(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/paged/{page}")
    public ResponseEntity<List<Book>> getAllBooks(@PathVariable int page) {
        return ResponseEntity.ok(bookService.getBooksByPage(page));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        var result = bookService.getBooks();
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book " + id + " deleted.");
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDto book) {
        var result = bookService.createBook(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/init")
    public ResponseEntity<String> init() {
        testData.createTestData();
        return ResponseEntity.ok("Books initialized.");
    }


}
