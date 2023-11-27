# QuemaDiaria
Quema Diaria grupo .com

Integrantes:
Lara Salcedo Franco
Juan Nicolás Avella
Juan Manuel Sánchez
Andrés Manosalva

Script necesario para la base de datos de MySQL:

/*
Base datos Grupo .com
*/

--TABLA CREDENCIALES
CREATE TABLE `credenciales` (
   `id` int NOT NULL AUTO_INCREMENT,
   `nombreUsuario` varchar(255) DEFAULT NULL,
   `contrasenna` varchar(255) DEFAULT NULL,
   `tipo` int DEFAULT NULL,
   PRIMARY KEY (`id`)
 );

--TABLA EJERCICIO
CREATE TABLE `ejercicio` (
   `id` int NOT NULL AUTO_INCREMENT,
   `nombre` varchar(255) DEFAULT NULL,
   `repeticiones` int DEFAULT NULL,
   `musculo` varchar(255) DEFAULT NULL,
   `descripcion` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
 );

--TABLA RUTINA
CREATE TABLE `rutina` (
   `id` int NOT NULL AUTO_INCREMENT,
   `nombre` varchar(255) DEFAULT NULL,
   `descripcion` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
 );

--TABLA USUARIO
CREATE TABLE `usuario` (
   `id` int NOT NULL AUTO_INCREMENT,
   `nombre` varchar(255) DEFAULT NULL,
   `apellido` varchar(255) DEFAULT NULL,
   `numeroDocumento` varchar(255) DEFAULT NULL,
   `correo` varchar(255) DEFAULT NULL,
   `credenciales_id` int DEFAULT NULL,
   PRIMARY KEY (`id`),
   KEY `credenciales_id` (`credenciales_id`),
   CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`credenciales_id`) REFERENCES `credenciales` (`id`)
 );

--TABLA RUTINA-EJERCICIO
CREATE TABLE `rutina_ejercicio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rutina_id` int DEFAULT NULL,
  `ejercicio_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rutina_id` (`rutina_id`),
  KEY `ejercicio_id` (`ejercicio_id`),
  CONSTRAINT `rutina_ejercicio_ibfk_1` FOREIGN KEY (`rutina_id`) REFERENCES `rutina` (`id`),
  CONSTRAINT `rutina_ejercicio_ibfk_2` FOREIGN KEY (`ejercicio_id`) REFERENCES `ejercicio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--TABLA PROGRAMA
CREATE TABLE `programa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--TABLA PROGRAMA-RUTINA
CREATE TABLE `programa_rutina` (
  `id` int NOT NULL AUTO_INCREMENT,
  `programa_id` int DEFAULT NULL,
  `rutina_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `programa_id` (`programa_id`),
  KEY `rutina_id` (`rutina_id`),
  CONSTRAINT `programa_rutina_ibfk_1` FOREIGN KEY (`programa_id`) REFERENCES `programa` (`id`),
  CONSTRAINT `programa_rutina_ibfk_2` FOREIGN KEY (`rutina_id`) REFERENCES `rutina` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
