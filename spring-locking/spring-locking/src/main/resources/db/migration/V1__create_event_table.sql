CREATE TABLE event(
    id UUID NOT NULL,
    title VARCHAR NOT NULL,
    number_of_seats INT NOT NULL,
    number_of_reserved_seats INT NOT NULL,
    version INT NOT NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
);


