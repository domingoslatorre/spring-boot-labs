CREATE TABLE users(
    id UUID NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    name VARCHAR NOT NULL,
    password VARCHAR,
    is_activated BOOLEAN,
    CONSTRAINT users_pk PRIMARY KEY (id)
);