DROP DATABASE IF EXISTS superheroes;
CREATE DATABASE superheroes CHARACTER SET utf8mb4;
USE superheroes;

CREATE TABLE creador (
id_creador INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
  nombre VARCHAR(20) NOT NULL
);


CREATE TABLE personajes (
  id_personaje INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre_real VARCHAR(20) NOT NULL,
  personaje VARCHAR(20) NOT NULL,
  inteligencia INT(10) NOT NULL,
  fuerza VARCHAR(10) NOT NULL,
  velocidad INT(11) NOT NULL,
  poder INT(11) NOT NULL,
  aparicion INT(11) NOT NULL,
  ocupacion VARCHAR(30) NULL,
  id_creador INT UNSIGNED NOT NULL,
  FOREIGN KEY (id_creador) REFERENCES creador(id_creador)
  );

INSERT INTO creador VALUES (1,'Marvel');
INSERT INTO creador VALUES (2,'DC COMICS');
insert into	personajes values (1, 'Bruce Banner', 'Hulk',160,'600 mil',75,98,1962,'Fisico Nuclear',1);
insert into	personajes values (2, 'Tony Stark', 'Iron Man',170,'200 mil',70,123,1963,'Inventor Industrial',1);
insert into	personajes values (3, 'Thor Odinson', 'Thor',145,'infinita',100,235,1962,'Rey de Asgard',1);
insert into	personajes values (4, 'Wanda Maximoff', 'Bruja Escarlata',170,'100 mil',90,345,1964,'Bruja',1);
insert into	personajes values (5, 'Carol Danvers', 'Captain Marvel',157,'250 mil',85,128,1968,'Oficial de inteligencia',1);
insert into	personajes values (6, 'Tanos', 'Mad Titan',170,'Infinita',40,306,1973,'Adorador de la muerte',1);
insert into	personajes values (7, 'Clark Ken', 'Superman',165,'Infinita',120,182,1948,'Reportero',2);
insert into	personajes values (8, 'Bruce Wayne', 'Batman',170,'500',32,47,1939,'Millonario',2);

select * from creador;
select * from personajes;

update personajes 
	set aparicion = 1938
    where id_personaje = 7;





