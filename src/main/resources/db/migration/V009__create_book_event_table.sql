create table if not exists book_event(
    id bigint primary key,
    book_id bigint not null,
    event_type varchar(25) not null,
    user_id bigint,
    timestamp timestamp not null
);

create sequence book_event_seq
increment by 1 start with 1;