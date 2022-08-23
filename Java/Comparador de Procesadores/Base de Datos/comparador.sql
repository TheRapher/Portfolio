-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: comparador_cpu
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cpu_defecto`
--

DROP TABLE IF EXISTS `cpu_defecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpu_defecto` (
  `Nombre` varchar(50) NOT NULL,
  `Marca` varchar(10) NOT NULL,
  `Frecuencia` double(3,2) NOT NULL,
  `FrecuenciaMAX` double(3,2) NOT NULL,
  `Nucleos` int(10) NOT NULL,
  `Memoria` int(10) NOT NULL,
  `Enlace` varchar(255) NOT NULL,
  `Hilos` int(10) NOT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu_defecto`
--

LOCK TABLES `cpu_defecto` WRITE;
/*!40000 ALTER TABLE `cpu_defecto` DISABLE KEYS */;
INSERT INTO `cpu_defecto` VALUES ('AMD Ryzen 3 3100 ','AMD',3.60,3.90,4,18,'https://www.pccomponentes.com/amd-ryzen-3-3100-wraith-stealth-36ghz',8),('AMD Ryzen 5 3600','AMD',3.60,4.20,6,35,'https://www.pccomponentes.com/amd-ryzen-5-3600-36ghz-box',12),('AMD Ryzen 5 5600G','AMD',3.90,4.40,6,19,'https://www.pccomponentes.com/amd-ryzen-5-5600g-440ghz',12),('AMD Ryzen 5 5600X','AMD',3.70,4.60,6,18,'https://www.pccomponentes.com/amd-ryzen-5-5600x-37ghz',12),('AMD Ryzen 7 3800X','AMD',3.90,4.50,8,36,'https://www.pccomponentes.com/amd-ryzen-7-3800x-39ghz-box',16),('AMD Ryzen 7 5700G','AMD',3.80,4.60,8,20,'https://www.pccomponentes.com/amd-ryzen-7-5700g-46ghz',16),('AMD Ryzen 9 5900X','AMD',3.00,4.00,12,64,'https://www.pccomponentes.com/amd-ryzen-9-5900x-37-ghz',24),('AMD Ryzen 9 5950X','AMD',3.00,4.00,16,64,'https://www.pccomponentes.com/amd-ryzen-9-5950x-34-ghz',32),('Intel Core i3-10100','INTEL',3.60,4.30,4,6,'https://www.pccomponentes.com/intel-core-i3-10100-360-ghz',8),('Intel Core i3-10105','INTEL',3.70,4.20,4,6,'https://www.pccomponentes.com/intel-core-i3-10105-37-ghz',8),('Intel Core i5-10400','INTEL',2.90,4.30,6,12,'https://www.pccomponentes.com/intel-core-i5-10400-290-ghz',12),('Intel Core i5-10400F','INTEL',2.90,4.30,6,12,'https://www.pccomponentes.com/intel-core-i5-10400f-290-ghz',12),('Intel Core i5-12600K','INTEL',3.00,4.90,10,20,'https://www.pccomponentes.com/intel-core-i5-12600k-49-ghz',16),('Intel Core i7-10700K','INTEL',3.80,5.10,8,16,'https://www.pccomponentes.com/intel-core-i7-10700k-380-ghz',16),('Intel Core i7-12700','INTEL',3.60,4.90,12,25,'https://www.pccomponentes.com/intel-core-i7-12700-49-ghz',20),('Intel Core i7-12700K','INTEL',3.00,4.90,12,25,'https://www.pccomponentes.com/intel-core-i7-12700k-50-ghz',20),('Intel Core i9-10850K','INTEL',3.00,5.00,10,20,'https://www.pccomponentes.com/intel-core-i9-10850k-36ghz',20),('Intel Core i9-10900KF','INTEL',3.70,5.30,10,20,'https://www.pccomponentes.com/intel-core-i9-10900kf-370-ghz',20),('Intel Core i9-12900K','INTEL',3.00,5.20,16,30,'https://www.pccomponentes.com/intel-core-i9-12900k-52-ghz',24);
/*!40000 ALTER TABLE `cpu_defecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cpu_usuarios`
--

DROP TABLE IF EXISTS `cpu_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpu_usuarios` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Marca` varchar(10) NOT NULL,
  `Frecuencia` double(3,2) NOT NULL,
  `FrecuenciaMAX` double(3,2) NOT NULL,
  `Nucleos` int(10) NOT NULL,
  `Memoria` int(10) NOT NULL,
  `Enlace` varchar(255) NOT NULL,
  `Hilos` int(10) NOT NULL,
  `idUsuario` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `cpu_usuarios_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpu_usuarios`
--

LOCK TABLES `cpu_usuarios` WRITE;
/*!40000 ALTER TABLE `cpu_usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `cpu_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usuario` varchar(10) NOT NULL,
  `contraseña` text NOT NULL,
  `correo` text NOT NULL,
  `Tipo` varchar(10) NOT NULL,
  `Verificacion` varchar(5) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('admin','SGVyMjAwOTAwLg==','comparadorcpu@gmail.com','PREMIUM','Si'),('Rafa','SGVyMjAwOTAwLg==','rafahermocabe@gmail.com','PREMIUM','No');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoraciones_usuarios`
--

DROP TABLE IF EXISTS `valoraciones_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones_usuarios` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `id_usuario` varchar(10) NOT NULL,
  `valoracion` varchar(255) NOT NULL,
  `cpu1` varchar(50) DEFAULT NULL,
  `cpu2` varchar(50) DEFAULT NULL,
  `cpu1_usuario` int(255) DEFAULT NULL,
  `cpu2_usuario` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `cpu1` (`cpu1`,`cpu2`),
  KEY `cpu2` (`cpu2`),
  KEY `cpu1_usuario` (`cpu1_usuario`,`cpu2_usuario`),
  KEY `cpu2_usuario` (`cpu2_usuario`),
  CONSTRAINT `valoraciones_usuarios_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `valoraciones_usuarios_ibfk_2` FOREIGN KEY (`cpu1`) REFERENCES `cpu_defecto` (`Nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `valoraciones_usuarios_ibfk_3` FOREIGN KEY (`cpu2`) REFERENCES `cpu_defecto` (`Nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `valoraciones_usuarios_ibfk_4` FOREIGN KEY (`cpu1_usuario`) REFERENCES `cpu_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `valoraciones_usuarios_ibfk_5` FOREIGN KEY (`cpu2_usuario`) REFERENCES `cpu_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones_usuarios`
--

LOCK TABLES `valoraciones_usuarios` WRITE;
/*!40000 ALTER TABLE `valoraciones_usuarios` DISABLE KEYS */;
INSERT INTO `valoraciones_usuarios` VALUES (6,'admin','d',NULL,NULL,NULL,NULL),(7,'admin','Hola','AMD Ryzen 3 3100 ','Intel Core i3-10100',NULL,NULL),(8,'admin','Hola','AMD Ryzen 3 3100 ','Intel Core i3-10100',NULL,NULL),(10,'admin','asasa','AMD Ryzen 3 3100 ','Intel Core i3-10100',NULL,NULL),(11,'admin','hEHEHE','AMD Ryzen 3 3100 ','Intel Core i3-10100',NULL,NULL),(13,'admin','Ejemplo','AMD Ryzen 5 5600G','Intel Core i7-10700K',NULL,NULL);
/*!40000 ALTER TABLE `valoraciones_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-05 17:57:36
