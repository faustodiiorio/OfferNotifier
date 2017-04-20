CREATE DATABASE  IF NOT EXISTS `offer_notifier` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `offer_notifier`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: offer_notifier
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_CATEGORIA` varchar(95) NOT NULL,
  `ID_CATEGORIA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domande`
--

DROP TABLE IF EXISTS `domande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domande` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITOLO` varchar(100) NOT NULL,
  `TESTO` tinytext NOT NULL,
  `ID_UTENTE` int(11) NOT NULL,
  `DATA` date NOT NULL,
  `ID_PRODOTTO` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_domande_prodotti_idx` (`ID_PRODOTTO`),
  KEY `fk_domande_utenti_idx` (`ID_UTENTE`),
  CONSTRAINT `fk_domande_prodotti` FOREIGN KEY (`ID_PRODOTTO`) REFERENCES `prodotti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_domande_utenti` FOREIGN KEY (`ID_UTENTE`) REFERENCES `utenti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domande`
--

LOCK TABLES `domande` WRITE;
/*!40000 ALTER TABLE `domande` DISABLE KEYS */;
/*!40000 ALTER TABLE `domande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prodotti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIPOLOGIA_VENDITA` varchar(45) NOT NULL,
  `PREZZO` varchar(45) NOT NULL,
  `NOME_PRODOTTO` varchar(100) DEFAULT NULL,
  `NOME_INSERZIONE` varchar(300) NOT NULL,
  `DESCRIZIONE` mediumtext,
  `QUANTITA` int(11) DEFAULT NULL,
  `RESTITUZIONE` varchar(145) NOT NULL,
  `ID_VENDITORE` int(11) NOT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_venditore_idx` (`ID_VENDITORE`),
  KEY `fk_categoria_idx` (`ID_CATEGORIA`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categorie` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_venditore` FOREIGN KEY (`ID_VENDITORE`) REFERENCES `venditori` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti`
--

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti_spedizioni`
--

DROP TABLE IF EXISTS `prodotti_spedizioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prodotti_spedizioni` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PRODOTTO` int(11) DEFAULT NULL,
  `ID_SPEDIZIONE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_prodotto_idx` (`ID_PRODOTTO`),
  KEY `fk_spedizione_idx` (`ID_SPEDIZIONE`),
  CONSTRAINT `fk_prodotto_spedizione` FOREIGN KEY (`ID_PRODOTTO`) REFERENCES `prodotti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_spedizione` FOREIGN KEY (`ID_SPEDIZIONE`) REFERENCES `spedizioni` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti_spedizioni`
--

LOCK TABLES `prodotti_spedizioni` WRITE;
/*!40000 ALTER TABLE `prodotti_spedizioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodotti_spedizioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recensioni`
--

DROP TABLE IF EXISTS `recensioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recensioni` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITOLO_RECENSIONE` varchar(45) NOT NULL,
  `FEEDBACK` decimal(3,2) DEFAULT NULL,
  `DESCRIZIONE` mediumtext NOT NULL,
  `ID_PRODOTTO` int(11) NOT NULL,
  `ID_UTENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_recesioni_utenti_idx` (`ID_UTENTE`),
  KEY `fk_recensioni_prodotti_idx` (`ID_PRODOTTO`),
  CONSTRAINT `fk_recensioni_prodotti` FOREIGN KEY (`ID_PRODOTTO`) REFERENCES `prodotti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_recesioni_utenti` FOREIGN KEY (`ID_UTENTE`) REFERENCES `utenti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensioni`
--

LOCK TABLES `recensioni` WRITE;
/*!40000 ALTER TABLE `recensioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `recensioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risposte`
--

DROP TABLE IF EXISTS `risposte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `risposte` (
  `ID` int(11) NOT NULL,
  `TESTO` mediumtext NOT NULL,
  `ID_DOMANDA` int(11) NOT NULL,
  `DATA` date NOT NULL,
  `ID_UTENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_risposte_domande_idx` (`ID_DOMANDA`),
  KEY `fk_risposte_utenti_idx` (`ID_UTENTE`),
  CONSTRAINT `fk_risposte_domande` FOREIGN KEY (`ID_DOMANDA`) REFERENCES `domande` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_risposte_utenti` FOREIGN KEY (`ID_UTENTE`) REFERENCES `utenti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risposte`
--

LOCK TABLES `risposte` WRITE;
/*!40000 ALTER TABLE `risposte` DISABLE KEYS */;
/*!40000 ALTER TABLE `risposte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spedizioni`
--

DROP TABLE IF EXISTS `spedizioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spedizioni` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIPOLOGIA_SPEDIZIONE` varchar(145) NOT NULL,
  `COSTO_SPEDIZIONE` varchar(45) NOT NULL,
  `TEMPO_IMPIEGATO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spedizioni`
--

LOCK TABLES `spedizioni` WRITE;
/*!40000 ALTER TABLE `spedizioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `spedizioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utenti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `BANNATO` varchar(5) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti_prodotti`
--

DROP TABLE IF EXISTS `utenti_prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utenti_prodotti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_UTENTE` int(11) NOT NULL,
  `ID_PRODOTTO` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_persona_idx` (`ID_UTENTE`),
  KEY `fk_prodotto_idx` (`ID_PRODOTTO`),
  CONSTRAINT `fk_persona` FOREIGN KEY (`ID_UTENTE`) REFERENCES `utenti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_prodotto` FOREIGN KEY (`ID_PRODOTTO`) REFERENCES `prodotti` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti_prodotti`
--

LOCK TABLES `utenti_prodotti` WRITE;
/*!40000 ALTER TABLE `utenti_prodotti` DISABLE KEYS */;
/*!40000 ALTER TABLE `utenti_prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venditori`
--

DROP TABLE IF EXISTS `venditori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venditori` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_VENDITORE` varchar(65) NOT NULL,
  `FEEDBACK` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venditori`
--

LOCK TABLES `venditori` WRITE;
/*!40000 ALTER TABLE `venditori` DISABLE KEYS */;
/*!40000 ALTER TABLE `venditori` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-20 16:16:10
