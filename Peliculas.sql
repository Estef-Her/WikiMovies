DROP table Wiki_Generos;
DROP table Usuario;
DROP table Favoritos;


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
    constraint fkFavorito foreign key (pelicula) references Pelicula(nombre)
);



/*CREATE SEQUENCE NUMERO_SEQ START WITH 1 INCREMENT BY 1 CACHE 20;
CREATE OR REPLACE TRIGGER peli_det_seq
  BEFORE INSERT ON Pelicula
  referencing old as old new as new
  FOR EACH ROW
BEGIN
  :new.codigo := NUMERO_SEQ.nextval;
END peli_det_seq;
/*/
commit;


CREATE OR REPLACE PROCEDURE crearUsuario (xnombre in Usuario.nombre%TYPE, xapellidos in Usuario.apellidos%TYPE, xpassword in Usuario.password%TYPE, xemail in Usuario.email%TYPE, xedad in Usuario.edad%TYPE, xsexo in Usuario.sexo%TYPE)
    IS
    BEGIN
        INSERT into Usuario (nombre,apellidos,password,email,edad,sexo) VALUES(xnombre,xapellidos,xpassword,xemail,xedad,xsexo); 
        COMMIT;
    END;
    /
	
CREATE OR REPLACE PROCEDURE crearGeneros(xpersona in VARCHAR, xdescripcion in VARCHAR)
    IS
    BEGIN
        INSERT into Genero (usuario,descripcion) VALUES(xpersona,xdescripcion); 
        COMMIT;
    END crearGeneros;
    /
	
CREATE OR REPLACE FUNCTION verGustos(xemail in varchar) RETURN SYS_REFCURSOR
    IS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT *FROM Genero WHERE usuario = xemail;
         RETURN c; 
         CLOSE c;  
    END;
    /
	
	CREATE OR REPLACE FUNCTION verUsuarioXGenero(xdescripcion in varchar) RETURN SYS_REFCURSOR
    IS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT *FROM Genero WHERE descripcion = xdescripcion;
         RETURN c; 
         CLOSE c;  
    END;
    /