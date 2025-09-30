create table location(
    id bigint primary key,
    address varchar(200),
    room varchar(20),
    shelf varchar(10)
);

create sequence location_seq increment 1 start with 1;