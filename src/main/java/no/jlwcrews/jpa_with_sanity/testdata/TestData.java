package no.jlwcrews.jpa_with_sanity.testdata;

import com.github.javafaker.Faker;
import no.jlwcrews.jpa_with_sanity.book.Book;
import no.jlwcrews.jpa_with_sanity.book.BookRepo;
import no.jlwcrews.jpa_with_sanity.location.Location;
import no.jlwcrews.jpa_with_sanity.location.LocationRepo;
import org.springframework.stereotype.Service;

@Service
public class TestData {

    private final LocationRepo locationRepo;
    private final BookRepo bookRepo;
    private final Faker faker = new Faker();

    public TestData(LocationRepo locationRepo, BookRepo bookRepo) {
        this.locationRepo = locationRepo;
        this.bookRepo = bookRepo;
    }

    public void createTestData(){
        var location = locationRepo.save(new Location("Building G", "Room 5", "Shelf 3"));
        for (int i = 0; i < 10; i++) {
            bookRepo.save(new Book(
                    faker.book().title(),
                    faker.book().author(),
                    location));
        }
    }


}
