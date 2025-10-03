create table if not exists author(
    id bigint not null,
    first_name varchar(200),
    last_name varchar(200),
    email varchar(50)
);

create sequence author_seq
start with 1 increment 1;

create table if not exists book_author(
    book_id bigint not null,
    author_id bigint not null
);