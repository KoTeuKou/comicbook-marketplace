CREATE SCHEMA IF NOT EXISTS refdata;

CREATE TABLE refdata.users (
    id bigint not null,
    login text not null,
    password text not null,
    firstName text,
    lastName text,
    email text not null,
    activate boolean default false,
    imageUrl text,
    activationKey text,
    resetKey text,
    country text,
    city text
);

CREATE TABLE refdata.comic_book (
    id bigint not null,
    tittle text not null,
    publisher text,
    writer text,
    artist text,
    price numeric(18, 6),
    publicationDate timestamp with time zone,
    description text,
    condition float
);