-- CREATE DATABASE store;
--
-- \connect store
CREATE SCHEMA IF NOT EXISTS online_store;

CREATE TABLE IF NOT EXISTS online_store.products (
    id SERIAL,
    name varchar(100) not null,
    price double precision not null,
    type varchar(20),
    brand varchar(50)
);

CREATE TABLE IF NOT EXISTS online_store.users (
    id serial,
    username varchar(50) not null,
    email varchar(50) not null
);

INSERT INTO
    online_store.users(username, email)
VALUES
    ('handsome', 'handsome@gmail.com');

INSERT INTO
    online_store.users(username, email)
VALUES
    ('kaprizner', 'kaprizner@gmail.com');

INSERT INTO
    online_store.users(username, email)
VALUES
    ('savonchiks', 'egorrr@gmail.com');