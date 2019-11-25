CREATE TABLE public."dealers"
(
    id serial primary key,
	name varchar(255) NOT NULL
);


CREATE TABLE public."view_data"
(
    id serial primary key,
	dealer_id integer NOT NULL REFERENCES dealers (id),
    start_at numeric(5),
    finish_at numeric(5)
);