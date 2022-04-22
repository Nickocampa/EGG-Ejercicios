DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda CHARACTER SET utf8mb4;
USE tienda;

CREATE TABLE fabricante (
  codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE producto (
  codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  precio DOUBLE NOT NULL,
  codigo_fabricante INT UNSIGNED NOT NULL,
  FOREIGN KEY (codigo_fabricante) REFERENCES fabricante(codigo)
);

INSERT INTO fabricante VALUES(1, 'Asus');
INSERT INTO fabricante VALUES(2, 'Lenovo');
INSERT INTO fabricante VALUES(3, 'Hewlett-Packard');
INSERT INTO fabricante VALUES(4, 'Samsung');
INSERT INTO fabricante VALUES(5, 'Seagate');
INSERT INTO fabricante VALUES(6, 'Crucial');
INSERT INTO fabricante VALUES(7, 'Gigabyte');
INSERT INTO fabricante VALUES(8, 'Huawei');
INSERT INTO fabricante VALUES(9, 'Xiaomi');

INSERT INTO producto VALUES(1, 'Disco duro SATA3 1TB', 86.99, 5);
INSERT INTO producto VALUES(2, 'Memoria RAM DDR4 8GB', 120, 6);
INSERT INTO producto VALUES(3, 'Disco SSD 1 TB', 150.99, 4);
INSERT INTO producto VALUES(4, 'GeForce GTX 1050Ti', 185, 7);
INSERT INTO producto VALUES(5, 'GeForce GTX 1080 Xtreme', 755, 6);
INSERT INTO producto VALUES(6, 'Monitor 24 LED Full HD', 202, 1);
INSERT INTO producto VALUES(7, 'Monitor 27 LED Full HD', 245.99, 1);
INSERT INTO producto VALUES(8, 'Portátil Yoga 520', 559, 2);
INSERT INTO producto VALUES(9, 'Portátil Ideapd 320', 444, 2);
INSERT INTO producto VALUES(10, 'Impresora HP Deskjet 3720', 59.99, 3);
INSERT INTO producto VALUES(11, 'Impresora HP Laserjet Pro M26nw', 180, 3);

/*1*/ SELECT nombre from PRODUCTO;
/*2*/ SELECT NOMBRE, PRECIO FROM PRODUCTO;
/*3*/ SELECT * FROM PRODUCTO;
/*4*/ SELECT NOMBRE, round(PRECIO) FROM PRODUCTO;
/*10*/ SELECT CODIGO_FABRICANTE from PRODUCTO GROUP by CODIGO_FABRICANTE;
/*11*/ select NOMBRE FROM FABRICANTE order by NOMBRE ASC;
/*12*/ SELECT NOMBRE, PRECIO FROM PRODUCTO order by NOMBRE ASC , PRECIO DESC;
/*13*/ SELECT * FROM FABRICANTE LIMIT 5;
/*14*/ SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY PRECIO ASC LIMIT 1;
/*15*/ SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY PRECIO DESC LIMIT 1;
/*16*/ SELECT NOMBRE, PRECIO FROM PRODUCTO WHERE PRECIO<=120 ORDER BY PRECIO;
/*17*/ SELECT NOMBRE, PRECIO FROM PRODUCTO WHERE PRECIO between 60 AND 200;
/*18*/ SELECT NOMBRE, CODIGO FROM PRODUCTO where CODIGO in (1,3,5);
/*23*/ SELECT NOMBRE FROM PRODUCTO WHERE NOMBRE LIKE '%Portátil%';

/*MULTITABLA*/
/*1*/ SELECT p.nombre,p.codigo,f.nombre,f.codigo FROM PRODUCTO p, FABRICANTE f where f.codigo=p.codigo_fabricante;
/*2*/ select p.nombre, p.precio, f.nombre from producto p, fabricante f where f.codigo=p.codigo_fabricante order by f.nombre asc;
/*3*/ select p.nombre, p.precio, f.nombre from producto p, fabricante f where f.codigo=p.codigo_fabricante order by p.precio asc limit 1;
/*4*/ select p.nombre, f.nombre from producto p, fabricante f where f.codigo=p.codigo_fabricante and f.nombre like 'LENOVO';
/*5*/ select p.nombre, f.nombre from producto p, fabricante f where f.codigo=p.codigo_fabricante and f.nombre = 'crucial' and p.precio>200;
/*6*/ select p.nombre, f.nombre from producto p, fabricante f where f.codigo=p.codigo_fabricante and f.nombre In ('ASUS','Hewlett-Packard');
/*7*/ select p.nombre, p.precio, f.nombre from producto p, fabricante f where f.codigo=p.codigo_fabricante and p.precio>=180 order by p.precio desc, p.nombre asc;

/*CONSULTAS MULTITABLAS*/
/*1*/ SELECT DISTINCT F.NOMBRE FROM FABRICANTE F LEFT JOIN PRODUCTO P ON F.CODIGO = P.CODIGO_FABRICANTE;
/*2*/ SELECT DISTINCT F.NOMBRE FROM FABRICANTE F LEFT JOIN PRODUCTO P ON F.CODIGO = P.CODIGO_FABRICANTE WHERE P.NOMBRE IS NULL;

/*SUBCONSULTAS*/
/*1*/ select P.NOMBRE FROM PRODUCTO P WHERE P.codigo_fabricante = (SELECT F.CODIGO FROM FABRICANTE F WHERE F.NOMBRE = 'LENOVO');
	UPDATE PRODUCTO
		SET PRECIO = 599
		WHERE CODIGO = 11;
  
  select max(P.PRECIO) FROM PRODUCTO P WHERE P.codigo_fabricante = (SELECT F.CODIGO FROM FABRICANTE F WHERE F.NOMBRE = 'LENOVO');
  SELECT * FROM PRODUCTO;
  
/*2*/SELECT * FROM PRODUCTO P WHERE P.PRECIO = (select max(P.PRECIO) FROM PRODUCTO P WHERE P.codigo_fabricante = (SELECT F.CODIGO FROM FABRICANTE F WHERE F.NOMBRE = 'LENOVO')) ORDER BY P.NOMBRE;


