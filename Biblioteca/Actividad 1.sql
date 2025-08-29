drop database if exists Libreria_Datacoins;
create database Libreria_Datacoins;
use Libreria_Datacoins;

create table generos(
	codigo_genero int auto_increment,
    tipo_genero varchar(128),
    
    constraint pk_generos primary key (codigo_genero)
    
);

create table ubicacion(
	codigo_ubicacion int auto_increment,
    edificio varchar(128),
    sala varchar(128),
    estante varchar(128),
    fila varchar(128),
    columna varchar(128),
    
    constraint pk_ubicacion primary key (codigo_ubicacion)
    
);
 
create table libros(
	codigo_libro int auto_increment,
    titulo varchar (64),
    cantidad int,
    autor varchar (16),
	codigo_genero int not null,
    codigo_ubicacion int not null,
    
    constraint pk_libros primary key (codigo_libro),
    
    constraint fk_libros_generos foreign key(codigo_genero)
		references generos(codigo_genero)on delete cascade,
        
	constraint fk_libros_ubicacion foreign key(codigo_ubicacion)
		references ubicacion(codigo_ubicacion)on delete cascade
    
);


insert into generos (tipo_genero) values 
('Ciencia Ficción'),
('Fantasía'),
('Misterio'),
('Historia'),
('Tecnología');


insert into ubicacion (edificio, sala, estante, fila, columna) values
('Edificio A', 'Sala 1', 'Estante 1', 'Fila A', 'Columna 1'),
('Edificio A', 'Sala 2', 'Estante 3', 'Fila B', 'Columna 2'),
('Edificio B', 'Sala 3', 'Estante 2', 'Fila C', 'Columna 3'),
('Edificio C', 'Sala 4', 'Estante 5', 'Fila D', 'Columna 4'),
('Edificio C', 'Sala 5', 'Estante 4', 'Fila E', 'Columna 5');

insert into libros (titulo, cantidad, autor, codigo_genero, codigo_ubicacion) values
('Dune', 10, 'Frank H.', 1, 1),
('El Hobbit', 5, 'Tolkien', 2, 2),
('Sherlock Holmes', 7, 'Arthur C.', 3, 3),
('La Segunda Guerra', 3, 'Max H.', 4, 4),
('Python Pro', 12, 'Ana M.', 5, 5);


select * from libros;


