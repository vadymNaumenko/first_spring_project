--liquibase formatted sql

--changeset vadym:1
ALTER TABLE users
    ADD COLUMN image VARCHAR(64);

--changeset vadym:2
ALTER TABLE users_aud
    ADD COLUMN image VARCHAR(64);
