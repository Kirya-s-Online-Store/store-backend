CREATE SCHEMA IF NOT EXISTS online_store;

CREATE TABLE IF NOT EXISTS online_store.products
(
    id    SERIAL,
    name  VARCHAR(100)     NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    type  VARCHAR(20),
    brand VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS online_store.users
(
    id       SERIAL,
    email    VARCHAR(50) UNIQUE NOT NULL CHECK (email ~* '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'),
    password VARCHAR(255)       NOT NULL,
    role     VARCHAR(255)       NOT NULL,
    address  VARCHAR(255)
);