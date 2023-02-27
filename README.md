# prueba2
Create database Fechas;

use Fechas;



create table dia( id int auto_increment not null, num_dia int(35) not null, primary key(id) );

Insert into dia(id, num_dia) values (null,1), (null,2), (null,3), (null,4),
(null,5), (null,6), (null,7), (null,8),
(null,9), (null,10), (null,11), (null,12),
(null,13), (null,14), (null,15), (null,16),
(null,17), (null,18), (null,19), (null,20),
(null,21), (null,22), (null,23), (null,24),
(null,25), (null,26), (null,27), (null,28),
(null,29), (null,30), (null,31), (null,32)
; 

SELECT * FROM dia;

create table mes( id int primary key auto_increment not null, Nombre_Mes varchar(10) );

INSERT INTO mes (id, Nombre_Mes) values (null, "Enero"), (null, "Febrero"),
(null, "Marzo"), (null, "Abril"),
(null, "Mayo"), (null, "Junio"),
(null, "Julio"), (null, "Agosto"),
(null, "Septiembre"), (null, "Octubre"),
(null, "Noviembre"), (null, "Diciembre")
; 

create table año( id int primary key auto_increment not null, Nombre_Anio int(4) );

INSERT INTO año (id, Nombre_Anio) values (null, 1980), (null, 1981),
(null, 1982), (null, 1983),
(null, 1984), (null, 1985),
(null, 1986), (null, 1987),
(null, 1988), (null, 1989),
(null, 1990), (null, 1991),
(null, 1992), (null, 1993),
(null, 1994), (null, 1995),
(null, 1996), (null, 1997),
(null, 1998), (null, 1999),
(null, 2001), (null, 2002),
(null, 2003), (null, 2004),
(null, 2005), (null, 2006),
(null, 2007), (null, 2008),
(null, 2009), (null, 2010),
(null, 2011), (null, 2012),
(null, 2013), (null, 2014),
(null, 2015), (null, 2016),
(null, 2017), (null, 2018),
(null, 2019), (null, 2020),
(null, 2021), (null, 2022),
(null, 2023)
; 

create table datos( resgistro int primary key not null, guardado date);
create table fin( id int primary key not null, dia int(2) not null, mes varchar (25) not null, anio int(4) not null);
create table fin2(dia int(2) not null, mes varchar (25) not null, anio int(4) not null);
select * from fin2;
Select * from dia ;	
Select * from mes ;
Select * from año;
