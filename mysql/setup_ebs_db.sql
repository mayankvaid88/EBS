create database ebs;
use ebs;
create table login_table (login_id varchar(255) primary key, password varchar(255) not null);
insert into login_table values ('ADMIN','$2a$10$KXSEWnLeov3vtEbcA07LQuJQq9bJ3SN6w2Qf6lOJp7ZFN43B0nsBa');
create table user_profile (id int primary key, login_id varchar(255) unique,name varchar(255) not null,role varchar(255) not null);
insert into user_profile values (1,'ADMIN','Mayank Vaid','ADMIN');
CREATE USER 'haproxy_check'@'%' IDENTIFIED WITH mysql_native_password;
FLUSH PRIVILEGES;