package no.jlwcrews.jpa_with_sanity.bookevent;

import no.jlwcrews.jpa_with_sanity.book.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookEventService {

    private final BookEventRepository bookEventRepository;
    private final BookService bookService;

    public BookEventService(BookEventRepository bookEventRepository, BookService bookService) {
        this.bookEventRepository = bookEventRepository;
        this.bookService = bookService;
    }

    public BookEvent save(BookEventDto bookEvent) {
        var book = bookService.getBook(bookEvent.bookId());
        return bookEventRepository.save(new BookEvent(
                bookEvent.bookEventType(),
                bookEvent.userId(),
                book
        ));
    }

    public List<BookEvent> findAll() {
        return bookEventRepository.findAll();
    }

    public BookEvent findById(Long id) {
        return bookEventRepository.findById(id).orElse(null);
    }

    public List<BookEvent> findEventsByBookId(Long bookId) {
        var book = bookService.getBook(bookId);
        return bookEventRepository.findAllByBook(book);
    }

    public void delete(BookEvent bookEvent) {
        bookEventRepository.delete(bookEvent);
    }
}
