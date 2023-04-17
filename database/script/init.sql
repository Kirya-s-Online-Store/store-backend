-- CREATE DATABASE store;
--
-- \connect store

CREATE SCHEMA IF NOT EXISTS online_store;

CREATE TABLE IF NOT EXISTS online_store.products
(
    id    SERIAL,
    name  varchar(100)     not null,
    price double precision not null,
    type  varchar(20),
    brand varchar(50)
);

CREATE TABLE IF NOT EXISTS online_store.users
(
    id       serial,
    username varchar(50) not null,
    email    varchar(50) not null
);

insert into online_store.users(username, email) values ('111', 'email111');
insert into online_store.users(username, email) values ('222', 'email222');
insert into online_store.users(username, email) values ('333', 'email333');
insert into online_store.users(username, email) values ('444', 'email444');
insert into online_store.users(username, email) values ('555', 'email555');