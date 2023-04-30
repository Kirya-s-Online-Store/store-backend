CREATE SCHEMA IF NOT EXISTS online_store;

CREATE TABLE IF NOT EXISTS online_store.product
(
    id    SERIAL,
    name  varchar(100)     not null,
    price double precision not null,
    type  varchar(20),
    brand varchar(50)
);

CREATE TABLE IF NOT EXISTS online_store.user
(
    id       serial,
    username varchar(50) not null,
    email    varchar(50) not null
);