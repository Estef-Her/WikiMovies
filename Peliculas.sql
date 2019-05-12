DROP table Genero;
DROP table Personas;

Create table Personas (
nombre varchar(100),
apellidos varchar(100),
password varchar(8),
email varchar(100),
edad number,
genero number,
constraint pkPersonas primary key(email)
);

Create table Genero(
persona varchar(100),
descripcion varchar(100),
constraint pkGenero primary key(persona,descripcion),
constraint fkGenero foreign key (persona) references Persona(email)
);

CREATE OR REPLACE PROCEDURE crearPersona (xnombre in VARCHAR, xapellidos in VARCHAR, xpassword in VARCHAR, xemail in VARCHAR, xedad in number, xgenero in number)
    IS
    BEGIN
        INSERT into Personas (nombre,apellidos,password,email,edad,genero) VALUES(xnombre,xapellidos,xpassword,xemail,xedad,xgenero); 
        COMMIT;
    END crearPersona;
    /
	
CREATE OR REPLACE PROCEDURE crearGeneros(xpersona in VARCHAR, xdescripcion in VARCHAR)
    IS
    BEGIN
        INSERT into Genero (persona,descripcion) VALUES(xpersona,xdescripcion); 
        COMMIT;
    END crearGeneros;
    /
	
CREATE OR REPLACE FUNCTION verGustos(xemail in varchar) RETURN SYS_REFCURSOR
    IS 
    c SYS_REFCURSOR;
    BEGIN
        OPEN c FOR SELECT *FROM Genero WHERE persona = xemail;
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