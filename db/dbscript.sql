create database xceptiondb;
create user 'xception'@'localhost' identified by 'xception_uec';
grant all privileges on xceptiondb.* to 'xception'@'localhost' with grant option;