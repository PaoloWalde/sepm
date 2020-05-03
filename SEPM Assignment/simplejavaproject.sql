create database simplejavaproject;
use simplejavaproject;
create table users(
    id int(11) not null auto_increment primary key,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    username varchar(50) not null unique key,
    role enum('Assistant', 'Administrator'),
    password varchar(50) not null
);