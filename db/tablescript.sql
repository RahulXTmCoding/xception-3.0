drop table if exists xception;
drop table if exists team_member;
drop table if exists team;
drop table if exists event_register_mapping,event,register;
drop table if exists sponsor;
drop table if exists xception_social_media;
drop table if exists faq;
drop table if exists feedback;
drop table if exists accomodation;
drop table if exists gallery;

create table xception
(
version char(5) primary key,
about varchar(1000) NOT NULL,
theme varchar(1000) NOT NULL,
xception_from date NOT NULL,
xception_to date NOT NULL
);
create table team
(
code int primary key AUTO_INCREMENT,
name varchar(50) NOT NULL,
head_name varchar(30) NOT NULL,
contact_number varchar(55) NOT NULL,
image_path char(100) NOT NULL,
profile_link varchar(1000) NOT NULL
);
create table event
(
code int auto_increment primary key,
name varchar(100) NOT NULL,
event_date date NOT NULL,
about varchar(1000) NOT NULL,
event_type varchar(50) NOT NULL,
event_venue varchar(100) NOT NULL,
head_name varchar(30) NOT NULL,
head_contact_number varchar(51) NOT NULL,
image_path char(100),
seats int 
);
create table register
(
code int auto_increment primary key,
name varchar(50) NOT NULL,
contact_number varchar(55) NOT NULL,
college varchar(100) NOT NULL,
city varchar(30) NOT NULL,
current_year varchar(10) NOT NULL,
gender varchar(10) NOT NULL,
email_id varchar(100) NOT NULL
);
create table event_register_mapping
(
event_code int ,
register_code int ,
primary key (event_code,register_code),
FOREIGN KEY(event_code) REFERENCES event(code),
FOREIGN KEY(register_code) REFERENCES register(code)
);
create table sponsor
(
code int AUTO_INCREMENT primary key,
name varchar(51) NOT NULL,
logo_path char(100) NOT NULL,
category varchar(100) NOT NULL,
contact_number varchar(55) NOT NULL,
link varchar(1000) NOT NULL,
year int not null
);
create table xception_social_media
(
name varchar(30) NOT NULL primary key,
link varchar(1000) NOT NULL,
logo_path char(100) NOT NULL
);
create table faq
(
question varchar(500) NOT NULL,
answer varchar(1000) NOT NULL
);
create table feedback
(
message varchar(1000) NOT NULL
);
create table team_member(
code int primary key AUTO_INCREMENT,
name char(31) NOT NULL,
contact_number char(51) NOT NULL,
team_code int,
FOREIGN KEY(team_code) REFERENCES team(code)
);
create table accomodation(
code int primary key AUTO_INCREMENT,
name char(31) not null,
college char(101) not null,
contact_number char(51) not null
);

create table gallery(
image_src char(200) not null
);