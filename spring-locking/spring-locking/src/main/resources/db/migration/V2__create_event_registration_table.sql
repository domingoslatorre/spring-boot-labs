CREATE TABLE event_registration(
    id UUID NOT NULL,
    event_id UUID NOT NULL,
    CONSTRAINT event_registration_pk PRIMARY KEY (id),
    CONSTRAINT event_fk FOREIGN key (event_id) REFERENCES event(id)
);