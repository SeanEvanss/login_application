create database if not exists user_authentication_db;

use  user_authentication_db;

drop table if exists user_auth_data;

create table user_auth_data(
	id int auto_increment,
    userName varchar(50),
    userPassword varchar(200),
    primary key(id)
);

insert into user_auth_data(userName, userPassword)
values ('sean', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');

-- update user_auth_data set userPassword = '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5' where id = 1;
-- select userName, userPassword from user_auth_data;