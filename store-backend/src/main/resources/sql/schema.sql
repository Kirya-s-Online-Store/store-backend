CREATE SCHEMA IF NOT EXISTS online_store;

CREATE TABLE IF NOT EXISTS online_store.types
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE
);

CREATE TABLE IF NOT EXISTS online_store.brands
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE
);

CREATE TABLE IF NOT EXISTS online_store.products
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(100)     NOT NULL,
    price    DOUBLE PRECISION NOT NULL,
    type_id  SERIAL           REFERENCES online_store.types (id) ON DELETE SET NULL,
    brand_id SERIAL           REFERENCES online_store.brands (id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS online_store.users
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULl,
    email      VARCHAR(50)  NOT NULL UNIQUE CHECK (email ~* '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'),
    password   VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS online_store.tokens
(
    id         SERIAL PRIMARY KEY,
    token      VARCHAR(255) NOT NULL UNIQUE,
    token_type VARCHAR(63),
    revoked    BOOLEAN,
    expired    BOOLEAN,
    user_id    SERIAL REFERENCES online_store.users (id) ON DELETE CASCADE
);