package no.jlwcrews.jpa_with_sanity.author;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        var result = authorService.getAuthor(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAuthors() {
        var result = authorService.getAuthors();
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Author " + id + " deleted.");
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        var result = authorService.createAuthor(author);
        return ResponseEntity.ok(result);
    }
}
