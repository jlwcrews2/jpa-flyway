package no.jlwcrews.jpa_with_sanity.bookevent;

import no.jlwcrews.jpa_with_sanity.book.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class BookEventController {

    private final BookEventService bookEventService;

    public BookEventController(BookEventService bookEventService) {
        this.bookEventService = bookEventService;

    }

    @GetMapping
    public ResponseEntity<List<BookEvent>> getEvents(){
        return ResponseEntity.ok(bookEventService.findAll());
    }

    @GetMapping("/{eventid}")
    public ResponseEntity<BookEvent> getEvent(@PathVariable Long eventid){
        return ResponseEntity.ok(bookEventService.findById(eventid));
    }

    @GetMapping("/book/{bookid}")
    public ResponseEntity<List<BookEvent>> getBookEvent(@PathVariable Long bookid){
        return ResponseEntity.ok(bookEventService.findEventsByBookId(bookid));
    }

    @PostMapping
    public ResponseEntity<BookEvent> createEvent(@RequestBody BookEventDto bookEvent){
        return ResponseEntity.ok(bookEventService.save(bookEvent));
    }
}
