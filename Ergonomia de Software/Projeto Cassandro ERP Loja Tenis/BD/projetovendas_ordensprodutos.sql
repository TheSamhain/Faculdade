CREATE DATABASE  IF NOT EXISTS `projetovendas` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projetovendas`;
-- MySQL dump 10.13  Distrib 5.6.47, for Win64 (x86_64)
--
-- Host: localhost    Database: projetovendas
-- ------------------------------------------------------
-- Server version	5.6.47-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ordensprodutos`
--

DROP TABLE IF EXISTS `ordensprodutos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordensprodutos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idProduto` int(11) unsigned NOT NULL,
  `idOrdem` int(11) unsigned NOT NULL,
  `qtde` double(10,3) NOT NULL,
  PRIMARY KEY (`id`,`idOrdem`,`idProduto`),
  KEY `idProduto_idx` (`idProduto`),
  KEY `ordProd_idOrdem_idx` (`idOrdem`),
  CONSTRAINT `OrdProd_idOrdem` FOREIGN KEY (`idOrdem`) REFERENCES `ordenscompra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `OrdProd_idProduto` FOREIGN KEY (`idProduto`) REFERENCES `produtos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='tabela que liga as ordens de compra com os produtos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordensprodutos`
--

LOCK TABLES `ordensprodutos` WRITE;
/*!40000 ALTER TABLE `ordensprodutos` DISABLE KEYS */;
INSERT INTO `ordensprodutos` VALUES (1,1,1,12.000);
/*!40000 ALTER TABLE `ordensprodutos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-06 19:00:03
