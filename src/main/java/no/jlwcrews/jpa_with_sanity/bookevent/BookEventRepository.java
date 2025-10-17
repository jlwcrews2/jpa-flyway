package no.jlwcrews.jpa_with_sanity.bookevent;

import no.jlwcrews.jpa_with_sanity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookEventRepository extends JpaRepository<BookEvent, Long> {


    List<BookEvent> findAllByBook(Book book);
}
