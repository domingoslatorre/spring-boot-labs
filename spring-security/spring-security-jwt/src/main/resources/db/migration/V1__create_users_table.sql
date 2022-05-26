CREATE TABLE users(
    id UUID NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    name VARCHAR NOT NULL,
    password CHAR(60),
    active BOOLEAN,
    CONSTRAINT users_pk PRIMARY KEY (id)
);