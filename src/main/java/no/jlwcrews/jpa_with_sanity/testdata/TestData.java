package no.jlwcrews.jpa_with_sanity.testdata;

import com.github.javafaker.Faker;
import no.jlwcrews.jpa_with_sanity.author.Author;
import no.jlwcrews.jpa_with_sanity.author.AuthorRepo;
import no.jlwcrews.jpa_with_sanity.book.Book;
import no.jlwcrews.jpa_with_sanity.book.BookRepo;
import no.jlwcrews.jpa_with_sanity.bookevent.BookEvent;
import no.jlwcrews.jpa_with_sanity.bookevent.BookEventRepository;
import no.jlwcrews.jpa_with_sanity.bookevent.BookEventType;
import no.jlwcrews.jpa_with_sanity.location.Location;
import no.jlwcrews.jpa_with_sanity.location.LocationRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TestData {

    private final LocationRepo locationRepo;
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final BookEventRepository bookEventRepo;
    private final Faker faker = new Faker();

    public TestData(LocationRepo locationRepo, BookRepo bookRepo, AuthorRepo authorRepo, BookEventRepository bookEventRepo) {
        this.locationRepo = locationRepo;
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.bookEventRepo = bookEventRepo;
    }

    public void createTestData(){
        var location = locationRepo.save(new Location("Building G", "Room 5", "Shelf 3"));
        var authors = createAuthors();
        for (int i = 0; i < 1000; i++) {
            var numAuthors = new Random().nextInt(3) + 1;
            var bookAuthors = new ArrayList<Author>();
            for (int j = 0; j < numAuthors; j++) {
                var randomAuthor = new Random().nextInt(authors.size());
                bookAuthors.add(authors.get(randomAuthor));
            }
            var book = bookRepo.save(
                    new Book(
                            faker.book().title(),
                            location,
                            bookAuthors
                    )
            );
            bookEventRepo.save(new BookEvent(
                    BookEventType.ACQUIRED,
                    5L,
                    book
            ));

        }
    }

    private List<Author> createAuthors() {
        var authorList = new ArrayList<Author>();
        for (int i = 0; i < 250; i++) {
            authorList.add(authorRepo.save(new Author(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.internet().emailAddress(),
                    null
            )));
        }
        return authorList;
    }


}
