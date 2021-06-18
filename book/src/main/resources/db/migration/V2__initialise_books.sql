CREATE TABLE lib.books
(
    id SERIAL PRIMARY KEY NOT NULL,
    name TEXT,
    artist TEXT,
    release_date timestamp,
    catalog_id serial,
    constraint books_catalog_id_fk foreign key (catalog_id)
        references catalogs (id)
);
CREATE UNIQUE INDEX books_id_uindex ON lib.books (id);