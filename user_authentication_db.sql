create database if not exists user_authentication_db;

use  user_authentication_db;

drop table if exists user_auth_data;

create table user_auth_data(
	id int auto_increment,
    userName varchar(50),
    userPassword varchar(50),
    primary key(id)
);

insert into user_auth_data(userName, userPassword)
values ('sean', '12345');

select userName, userPassword from user_auth_data;