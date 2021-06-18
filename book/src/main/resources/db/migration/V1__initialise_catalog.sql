CREATE TABLE lib.catalogs
(
    id SERIAL PRIMARY KEY NOT NULL,
    name TEXT
);
CREATE UNIQUE INDEX catalogs_id_uindex ON lib.catalogs (id);