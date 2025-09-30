create table book(
    id bigint primary key,
    title varchar(255),
    author varchar(255),
    location varchar(25)
);

create sequence book_seq increment by 1 start with 1;