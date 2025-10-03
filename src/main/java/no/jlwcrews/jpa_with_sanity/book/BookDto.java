package no.jlwcrews.jpa_with_sanity.book;

import java.util.List;

public record BookDto (
    Long id,
    String title,
    List<Long> authorIds,
    Long locationId
){}
