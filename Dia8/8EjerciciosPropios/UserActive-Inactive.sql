create database dia8tarde;
use dia8tarde;
drop database dia8tarde;

delimiter $$;
Create Trigger TurnInactive before delete ON Users
for each row
    insert into inactiveUsers(email, pass, idInfo) values (OLD.email, OLD.pass, OLD.idInfo);
delimiter;

delimiter $$;
Create Trigger TurnActive before delete ON inactiveUsers
for each row
    insert into Users(email, pass, idInfo) values (OLD.email, OLD.pass, OLD.idInfo);
delimiter;


delimiter $$;
Create Trigger TurnActive before Update ON Users 
for each row
    update Users u SET pass = NEW.pass where u.email = new.email; 
delimiter;


create table info(
idInfo int primary key auto_increment,
firstname varchar(20) not null,
lastname varchar(20) not null
);

create table Users(
id int primary key auto_increment,
email varchar(20) not null UNIQUE,
pass varchar(20) not null,
idInfo int,
FOREIGN KEY (idInfo) references info(idInfo)
);

create table inactiveUsers(
id int primary key auto_increment,
email varchar(20) not null,
pass varchar(20) not null,
idInfo int not null,
FOREIGN KEY (idInfo) references info(idInfo)
);

insert into info(firstname, lastname) values ("Franco", "luzardi");
insert into info(firstname, lastname) values ("Carlitos", "rodriguez");
insert into Users(email, pass, idInfo) values ("asd", "asd", 1);
insert into Users(email, pass, idInfo) values ("carlitos@gmail.com", "1234", 2);

select * from info
select * from Users;
select * from inactiveUsers;

delete from Users where id = 5;
delete from inactiveUsers where id = 2;


