create database dia7RecordCompany;
use dia7RecordCompany;

create table Album(
id int primary key not null,
albumName varchar(20) not null,
idArtist int not null,
FOREIGN KEY (idArtist) references Artist(ids)
ON DELETE CASCADE
);

create table Artist(
ids int primary key not null,
musicStyle varchar(20) not null,
idInfo int,
FOREIGN KEY (idInfo) references personalInfo(id)
ON DELETE CASCADE
);

create table Song(
id int primary key not null,
title varchar(20) not null,
duration double not null,
albumId int not null,
FOREIGN KEY (albumId) references Album(id)
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
insert into Song(id, title, duration, albumId) values (?,?,?,?);

select * from Artist;
select * from personalInfo;
select * from Album;
select * from Song;

DROP TABLE personalInfo;
DROP TABLE Artist;
DROP TABLE Album;
DROP TABLE Song;
