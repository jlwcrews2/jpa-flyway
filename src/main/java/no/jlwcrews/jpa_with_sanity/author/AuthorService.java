package no.jlwcrews.jpa_with_sanity.author;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    
    private final AuthorRepo repo;

    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }

    public Author createAuthor(Author author) {
        return repo.save(author);
    }

    public Author getAuthor(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Author> getAuthors() {
        return repo.findAll();
    }

    public void deleteAuthor(Long id) {
        repo.deleteById(id);
    }
}
