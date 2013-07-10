CREATE TABLE users (
    id serial not null,
    name text DEFAULT ''::character varying,
    email text not null,
    image text,
    PRIMARY KEY(id)
);