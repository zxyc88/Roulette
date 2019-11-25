CREATE TABLE roulette."dealers"
(
    id int auto_increment,
	name varchar(255) NOT NULL,
)

CREATE TABLE roulette."view_data"
(
    id int auto_increment,
	  dealer_id int(11) NOT NULL,
    start_at numeric(5) ,
    finish_at numeric(5) ,
)