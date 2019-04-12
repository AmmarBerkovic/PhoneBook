create database phonebook;
create table users(
Id integer primary key auto_increment,
Ime varchar(20),
Prezime varchar(20),
Broj varchar(20) unique,
Sifra varchar(20)
);
insert into  users values (default,'Ammar','Berkovic','062179165','testiranje');
insert into  users values (default,'Ammar','Berkovic','062179166','testiranje');
create table user1(
Id integer primary key auto_increment,
Kontakt integer,
foreign key (Kontakt) references users (Id)
);
insert into  user1 values (default,2);
create table user1(
Id integer primary key auto_increment,
Kontakt integer,
foreign key (Kontakt) references users (Id)
);
insert into  user2 values (default,1);