CREATE TABLE users (
    email varchar(100) not null primary key,
    name varchar(100) DEFAULT ''::character varying,
    password varchar(100) not null,
    image text,
    enabled boolean NOT NULL DEFAULT false,
    created_at timestamp(0) with time zone NOT NULL,
    updated_at timestamp(0) with time zone NOT NULL
);