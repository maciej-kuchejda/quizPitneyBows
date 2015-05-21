CREATE DATABASE  IF NOT EXISTS `quizdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quizdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: quizdb
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Person_Login` varchar(45) NOT NULL,
  `Person_Password` varchar(45) NOT NULL,
  `FirstName` varchar(64) NOT NULL,
  `LastName` varchar(64) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Person_Login_UNIQUE` (`Person_Login`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='This table contains information''s about user''s';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'user','user123','Andrzej','Kowalski'),(2,'maciej','maciej123','Maciej','Kuchejda');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_attribute`
--

DROP TABLE IF EXISTS `person_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_attribute` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table contains person attribute''s';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_attribute`
--

LOCK TABLES `person_attribute` WRITE;
/*!40000 ALTER TABLE `person_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_attribute_value_link`
--

DROP TABLE IF EXISTS `person_attribute_value_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_attribute_value_link` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PersonId_FK` int(11) NOT NULL,
  `AttributeId_FK` int(11) NOT NULL,
  `Value` varchar(256) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `PersonAttribute_Person_FK_idx` (`PersonId_FK`),
  KEY `PersonAttribute_PersonAttribute_FK_idx` (`AttributeId_FK`),
  CONSTRAINT `PersonAttribute_PersonAttribute_FK` FOREIGN KEY (`AttributeId_FK`) REFERENCES `person_attribute` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PersonAttribute_Person_FK` FOREIGN KEY (`PersonId_FK`) REFERENCES `person` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_attribute_value_link`
--

LOCK TABLES `person_attribute_value_link` WRITE;
/*!40000 ALTER TABLE `person_attribute_value_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_attribute_value_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_figures`
--

DROP TABLE IF EXISTS `sales_figures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_figures` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PersonId_FK` int(11) NOT NULL,
  `SALE_DATE` date NOT NULL,
  `AMOUNT` decimal(10,0) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `SalesFigures-Person_FK_idx` (`PersonId_FK`),
  CONSTRAINT `SalesFigures-Person_FK` FOREIGN KEY (`PersonId_FK`) REFERENCES `person` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_figures`
--

LOCK TABLES `sales_figures` WRITE;
/*!40000 ALTER TABLE `sales_figures` DISABLE KEYS */;
INSERT INTO `sales_figures` VALUES (1,1,'2012-02-01',100),(2,1,'2012-03-10',20),(3,1,'2012-04-10',30),(4,1,'2012-05-10',40),(5,1,'2012-06-10',80),(6,1,'2012-07-10',21),(7,1,'2012-01-10',312),(8,1,'2012-11-10',21),(9,1,'2012-12-10',1000),(10,1,'2012-08-10',110),(11,2,'2012-01-01',20),(12,2,'2012-02-01',30),(13,2,'2012-03-01',40),(14,2,'2012-04-01',50),(15,2,'2012-05-01',60),(16,2,'2012-06-01',70),(17,2,'2012-07-01',80),(18,2,'2012-08-01',90),(19,2,'2012-09-01',100),(20,2,'2012-10-01',110),(21,2,'2012-11-01',120),(22,2,'2012-12-01',130);
/*!40000 ALTER TABLE `sales_figures` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-20 15:53:04