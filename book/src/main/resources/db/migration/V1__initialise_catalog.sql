CREATE TABLE lib.catalogs
(
    catalog_id SERIAL PRIMARY KEY NOT NULL,
    name text
);
CREATE UNIQUE INDEX catalogs_id_uindex ON lib.catalogs (catalog_id);