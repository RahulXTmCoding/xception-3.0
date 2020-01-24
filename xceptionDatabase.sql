drop table if exists exception;
drop table if exists team;
drop table if exists event_register_mapping,events,register;
drop table if exists sponsers;
drop table if exists xcepion_social_media;
drop table if exists faq;
drop table if exists feedback;

create table exception
(
version decimal primary key,
about varchar(1000) not null,
theme varchar(1000) not null,
from_date DATE not null,
to_date DATE NOT NULL
);
create table team
(
name varchar(50) primary key,
head_name varchar(30) not null,
contact_number varchar(55) not null,
members varchar(255) not null, 
image longblob not null,
profile_link varchar(1000) not null
);

create table events
(
event_id int auto_increment primary key,
event_name varchar(100) not null,
event_date date not null,
about varchar(1000) not null,
event_type varchar(50) not null,
event_venue varchar(100) not null,
head_name varchar(30) not null,
head_contact_number varchar(51) not null,
seats int 
);
create table register
(
r_id int auto_increment primary key,
name varchar(50) not null,
contact_number varchar(55) not null,
college varchar(100) not null,
city varchar(30) not null,
current_year varchar(10) not null,
gender varchar(10) not null,
email_id varchar(100) not null
);
create table event_register_mapping
(
event_id int ,
r_id int ,
primary key (event_id,r_id),
FOREIGN KEY(event_id) 
       REFERENCES events(event_id),
   FOREIGN KEY(r_id) 
       REFERENCES register(r_id)

);
create table sponsers
(
s_id int auto_increment primary key,
name varchar(51) not null,
logo longblob not null,
category varchar(100) not null,
contact_number varchar(55) not null,
link varchar(1000) not null
);
create table xcepion_social_media
(
name varchar(30) not null primary key,
link varchar(1000) not null,
logo longblob not null
);
create table faq
(
question varchar(500),
answer varchar(1000)
);
create table feedback
(
message varchar(1000)
);





