DROP table Wiki_Generos CASCADE CONSTRAINTS;
DROP table Favoritos CASCADE CONSTRAINTS;
DROP table Usuario CASCADE CONSTRAINTS;

Create table Usuario (
    nombre varchar(100),
    apellidos varchar(100),
    edad number,
    sexo varchar(5),
    password varchar(10),
    email varchar(100) not null,
    rol varchar(40),
    constraint pkUsuario primary key(email)
);

Create table Wiki_Generos(   
    usuario varchar(100) not null,
    descripcion varchar(100) not null,
    constraint pkGenero primary key(usuario,descripcion),
    constraint fkGenero foreign key (usuario) references Usuario(email)
);

Create table Favoritos(
    usuario varchar(50) not null,
    pelicula varchar(80) not null,
    puntuacion number,
    constraint pkFavorito primary key(usuario,pelicula),
	constraint fkFavorito foreign key (usuario) references Usuario(email)
);

insert into Usuario values('Estefany','Hernandez Arce',22,'1','12345678','dh17376334@gmail.com','Usuario');
insert into Wiki_Generos values('dh17376334@gmail.com','Terror');
insert into Wiki_Generos values('dh17376334@gmail.com','Suspense');
insert into Wiki_Generos values('dh17376334@gmail.com','Crimen');
insert into Wiki_Generos values('dh17376334@gmail.com','Documental');

commit;