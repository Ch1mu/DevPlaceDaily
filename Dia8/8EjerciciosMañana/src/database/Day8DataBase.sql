create database dia8;
use dia8;
drop database dia8;


create table personInfo(
idInfo int primary key not null,
firstname varchar(20) not null,
lastname varchar(20) not null,
dni varchar(20) not null,
Address varchar(20) not null,
birth Date not null
);

create table Clients(
idClient int primary key not null,
idInfo int not null,
Foreign key (idInfo) references personInfo(idInfo) ON DELETE CASCADE
);
create table Vendor(
idVendor int primary key not null,
salary double not null,
idInfo int not null,
Foreign key (idInfo) references personInfo(idInfo) ON DELETE CASCADE

);

create table Products(
idProduct int primary key not null,
price double not null,
ammount int not null,
minStock int not null
);
create table Billings(
idBilling int primary key not null,
datesql Date not null,
idClient int not null,
idVendor int not null,
idProd int not null,
Foreign key (idProd) references Products(idProduct) ON DELETE CASCADE,
Foreign key (idClient) references Clients(idClient) ON DELETE CASCADE,
Foreign key (idVendor) references Vendor(idVendor) ON DELETE CASCADE
);

select* from clients;
select * from personInfo;
select * from Products;
select * from Vendor;
