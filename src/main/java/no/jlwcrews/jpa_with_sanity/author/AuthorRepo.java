package no.jlwcrews.jpa_with_sanity.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
