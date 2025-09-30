package no.jlwcrews.jpa_with_sanity.book;

public record BookDto (
    Long id,
    String title,
    String author,
    Long locationId
){}
