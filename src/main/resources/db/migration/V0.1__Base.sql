CREATE SCHEMA IF NOT EXISTS refdata;

CREATE TABLE refdata.users (
    id serial primary key,
    login text not null,
    password text not null,
    first_name text,
    last_name text,
    email text not null,
    activated boolean default false,
    activation_key text,
    reset_key text,
    image_path text,
    country text,
    city text
);

CREATE TABLE refdata.comic_book (
    id serial primary key,
    title text not null,
    publisher text,
    writer text,
    artist text,
    price numeric(18, 6),
    publication_date timestamp with time zone,
    description text,
    condition float
);