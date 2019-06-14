DROP table Wiki_Genero CASCADE CONSTRAINTS;
DROP table Favorito CASCADE CONSTRAINTS;
DROP table Usuario CASCADE CONSTRAINTS;


Create table Usuario (
    nombre varchar(100),
    apellidos varchar(100),
    edad number,
    sexo varchar(5),
    password varchar(10),
    email varchar(100) not null,
    constraint pk1Usuario primary key(email)
);

Create table Wiki_Genero(   
    usuario varchar(100) not null,
    descripcion varchar(100) not null,
    constraint pk1Genero primary key(usuario,descripcion),
    constraint fk1Genero foreign key (usuario) references Usuario(email)
);

Create table Favorito(
    usuario varchar(50) not null,
    pelicula varchar(80) not null,
    puntuacion number,
    constraint pk1Favorito primary key(usuario,pelicula),
	constraint fk1Favorito foreign key (usuario) references Usuario(email)
);


INSERT INTO Usuario VALUES ('Roger','Amador',23,'M','admin','addielo.oamvi@gmail.com');
INSERT INTO Usuario VALUES ('Estefany','Hernandez',22,'F','admin','dh17376334@gmail.com');
commit;

--CREATE SEQUENCE NUMERO_SEQ START WITH 1 INCREMENT BY 1 CACHE 20;
--http://localhost:30503/Wiki_Server/doLogin?email=addielo.oamvi@gmail.com&key=admin
--CREATE OR REPLACE TRIGGER peli_det_seq
--  BEFORE INSERT ON Pelicula
--  referencing old as old new as new
--  FOR EACH ROW
--BEGIN
--  :new.codigo := NUMERO_SEQ.nextval;
--END peli_det_seq;
--/



CREATE OR REPLACE PROCEDURE crearUsuario (xnombre in Usuario.nombre%TYPE, xapellidos in Usuario.apellidos%TYPE, xpassword in Usuario.password%TYPE, xemail in Usuario.email%TYPE, xedad in Usuario.edad%TYPE, xsexo in Usuario.sexo%TYPE)
    IS
    BEGIN
        INSERT into Usuario (nombre,apellidos,password,email,edad,sexo) VALUES(xnombre,xapellidos,xpassword,xemail,xedad,xsexo); 
        COMMIT;
    END;
    /

CREATE OR REPLACE PROCEDURE modificarUsuario (xnombre in Usuario.nombre%TYPE, xapellidos in Usuario.apellidos%TYPE, xpassword in Usuario.password%TYPE, xemail in Usuario.email%TYPE, xedad in Usuario.edad%TYPE, xsexo in Usuario.sexo%TYPE)
    IS
    BEGIN
        UPDATE Usuario SET nombre= xnombre, apellidos = xapellidos, password = xpassword, edad = xedad, sexo = xsexo WHERE email = xemail; 
        COMMIT;
    END;
    /

CREATE OR REPLACE PROCEDURE eliminarUsuario (xemail in Usuario.email%TYPE)
    IS
    BEGIN
        DELETE Usuario  WHERE email = xemail; 
        COMMIT;
    END;
    /

	
CREATE OR REPLACE PROCEDURE crearGenero(xemail in VARCHAR, xdescripcion in VARCHAR)
    IS
    BEGIN
        INSERT into Wiki_Genero (usuario,descripcion) VALUES(xemail,xdescripcion); 
        COMMIT;
    END;
    /
	
CREATE OR REPLACE PROCEDURE modificarGenero(xemail in VARCHAR, xdescripcion in VARCHAR)
    IS
    BEGIN
        UPDATE Wiki_Genero SET descripcion = xdescripcion WHERE usuario =  xemail; 
        COMMIT;
    END;
    /	
CREATE OR REPLACE PROCEDURE eliminarGenero(xemail in VARCHAR)
    IS
    BEGIN
        DELETE Wiki_Genero  WHERE usuario =  xemail; 
        COMMIT;
    END;
    /		
	
	
CREATE OR REPLACE PROCEDURE crearFavorito(xemail in VARCHAR, xpelicula in VARCHAR)
    IS
    BEGIN
        INSERT into Favorito (usuario,pelicula) VALUES(xemail,xpelicula); 
        COMMIT;
    END;
    /	
	
CREATE OR REPLACE PROCEDURE modificarFavorito(xemail in VARCHAR, xpelicula in VARCHAR)
    IS
    BEGIN
        UPDATE Favorito SET pelicula = xpelicula WHERE usuario =  xemail; 
        COMMIT;
    END;
    /	
CREATE OR REPLACE PROCEDURE eliminarFavorito(xemail in VARCHAR)
    IS
    BEGIN
        DELETE  Favorito  WHERE usuario =  xemail; 
        COMMIT;
    END;
    /			
	
	
CREATE OR REPLACE FUNCTION verGenerosXusuario(xemail in varchar) RETURN SYS_REFCURSOR
    IS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT * FROM Wiki_Genero WHERE usuario = xemail;
         RETURN c; 
         CLOSE c;  
    END;
    /
	
	CREATE OR REPLACE FUNCTION verFavoritosXusuario(xemail in varchar) RETURN SYS_REFCURSOR
    IS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT * FROM Favorito WHERE usuario = xemail;
         RETURN c; 
         CLOSE c;  
    END;
    /
CREATE OR REPLACE FUNCTION login(xemail IN Usuario.email%TYPE, xpassword IN Usuario.password%TYPE)
    RETURN SYS_REFCURSOR 
    AS 
            c SYS_REFCURSOR; 
    BEGIN 
    OPEN c FOR 
        SELECT COUNT(email) AS exist FROM Usuario WHERE email = xemail AND password = xpassword;
        RETURN c; 
    END;
    /
	
	CREATE OR REPLACE FUNCTION buscar_usuario_email (xemail in Usuario.email%TYPE) RETURN SYS_REFCURSOR
    IS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT *FROM Usuario WHERE email = xemail;
         RETURN c; 
         CLOSE c;  
    END;
    /
commit;