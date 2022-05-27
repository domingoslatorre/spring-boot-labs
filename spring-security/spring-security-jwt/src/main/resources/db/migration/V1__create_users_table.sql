CREATE TABLE users(
    id UUID NOT NULL,
    name VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    password CHAR(60),
    role VARCHAR NOT NULL UNIQUE,
    active BOOLEAN,
    CONSTRAINT users_pk PRIMARY KEY (id)
);