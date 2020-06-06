create database ebs;
use ebs;
create table login_table (login_id varchar(255) primary key, password varchar(255) not null, role varchar(20) not null);