create database dia7RecordCompany;
use dia7RecordCompany;

create table Album(
id int primary key not null,
albumName varchar(20) not null
);

create table Artist(
id int primary key not null,
musicStyle varchar(20) not null,
idInfo int,
band int,
FOREIGN KEY (idInfo) references personalInfo(id)
ON DELETE CASCADE
);


create table personalInfo(
id int primary key not null,
firstname varchar(20) not null,
lastname varchar(20) not null,
dni varchar(20) not null
);
insert into album(id, albumName) values(?,?);
insert into personalInfo(id, firstname, lastname, dni) values (?,?,?,?);
insert into  Artist(id, musicStyle, idInfo, band) values (?,?,?,?);

