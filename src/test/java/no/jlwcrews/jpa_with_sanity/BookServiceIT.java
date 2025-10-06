package no.jlwcrews.jpa_with_sanity;

import no.jlwcrews.jpa_with_sanity.author.Author;
import no.jlwcrews.jpa_with_sanity.author.AuthorService;
import no.jlwcrews.jpa_with_sanity.book.BookDto;
import no.jlwcrews.jpa_with_sanity.book.BookService;
import no.jlwcrews.jpa_with_sanity.location.Location;
import no.jlwcrews.jpa_with_sanity.location.LocationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceIT extends BaseIntegrationTest {

    @Autowired private BookService bookService;
    @Autowired private AuthorService authorService;
    @Autowired private LocationService locationService;

    @Test
    void testOfContainer(){
        var newLocation = locationService.save(new Location("Place", "Room", "shelf"));
        var newAuthor = new Author("John", "Doe", "jd@jd.jd", null);
        authorService.createAuthor(newAuthor);
        var newBook = new BookDto(null, "Fishing with John", List.of(newAuthor.getId()), newLocation.getId());
        var result = bookService.createBook(newBook);
        assert result.getAuthors().size() == 1;
    }
}
