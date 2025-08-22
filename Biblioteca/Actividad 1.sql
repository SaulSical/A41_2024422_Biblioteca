drop database if exists Libreria_Datacoins;
create database Libreria_Datacoins;
use Libreria_Datacoins;
 
create table libros(
	codigoLibro integer auto_increment,
    titulo varchar (64),
    cantidad int,
    autor varchar (16),
	codigoGenero int not null,
    codigoUbicacion int not null,
    
    constraint pk_libros primary key (codigoLibro),
    
    constraint fk_libros_generos foreign key(codigoGenero)
		references generos (codigoGenero)on delete cascade,
        
	constraint fk_libros_ubicacion foreign key(codigoUbicacion)
		references ubicacion (codigoUbicacion)on delete cascade
    
);

create table generos(
	codigoGenero int auto_increment,
    tipogenero varchar(128),
    
    constraint pk_generos primary key (codigoGenero)
    
);

create table ubicacion(
	codigoUbicacion int auto_increment,
    edificio varchar(128),
    sala varchar(128),
    estante varchar(128),
    fila varchar(128),
    columna varchar(128),
    
    constraint pk_ubicacion primary key (codigoUbicacion)
    
);