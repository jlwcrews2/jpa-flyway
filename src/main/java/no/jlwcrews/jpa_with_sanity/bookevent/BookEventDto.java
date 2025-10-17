package no.jlwcrews.jpa_with_sanity.bookevent;

public record BookEventDto(
        BookEventType bookEventType,
        Long userId,
        Long bookId
) {
}
