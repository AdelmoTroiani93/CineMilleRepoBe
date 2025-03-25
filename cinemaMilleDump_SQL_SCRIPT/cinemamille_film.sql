-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinemamille
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film` (
  `idFilm` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(255) NOT NULL,
  `genere` varchar(50) DEFAULT NULL,
  `dataUscita` date DEFAULT NULL,
  `durata` int DEFAULT NULL,
  PRIMARY KEY (`idFilm`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Inception','Sci-Fi','2010-07-16',148),(2,'La La Land','Musical','2016-12-09',128),(3,'Il Padrino','Crime','1972-03-24',175),(4,'Pulp Fiction','Crime','1994-10-14',154),(5,'Interstellar','Sci-Fi','2014-11-07',169),(6,'Parasite','Thriller','2019-05-30',132),(7,'Il Signore degli Anelli: La Compagnia dell\'Anello','Fantasy','2001-12-19',178),(8,'Forrest Gump','Drama','1994-07-06',142),(9,'The Matrix','Sci-Fi','1999-03-31',136),(10,'Titanic','Romance','1997-12-19',195),(11,'The Dark Knight','Action','2008-07-18',152),(12,'Fight Club','Drama','1999-10-15',139),(13,'Joker','Thriller','2019-10-04',122),(14,'Avatar','Sci-Fi','2009-12-18',162),(15,'Gladiator','Action','2000-05-05',155),(16,'The Shawshank Redemption','Drama','1994-09-23',142),(17,'Schindler\'s List','Biography','1993-12-15',195),(18,'The Godfather: Part II','Crime','1974-12-20',202),(19,'The Green Mile','Fantasy','1999-12-10',189),(20,'Saving Private Ryan','War','1998-07-24',169),(21,'The Revenant','Adventure','2015-12-25',156),(22,'The Lion King','Animation','1994-06-24',88),(23,'Up','Animation','2009-05-29',96),(24,'Spirited Away','Animation','2001-07-20',125),(25,'The Incredibles','Animation','2004-11-05',115),(26,'Coco','Animation','2017-11-22',105),(27,'Frozen','Animation','2013-11-27',102),(28,'Inside Out','Animation','2015-06-19',95),(29,'The Grand Budapest Hotel','Comedy','2014-03-28',99),(30,'Django Unchained','Western','2012-12-25',165),(31,'Inglourious Basterds','War','2009-08-21',153),(32,'Deadpool','Action','2016-02-12',108),(33,'Logan','Action','2017-03-03',137),(34,'Black Panther','Action','2018-02-16',134),(35,'Doctor Strange','Sci-Fi','2016-11-04',115),(36,'Thor: Ragnarok','Sci-Fi','2017-11-03',130),(37,'The Avengers','Sci-Fi','2012-05-04',143),(38,'Guardians of the Galaxy','Sci-Fi','2014-08-01',121),(39,'Iron Man','Sci-Fi','2008-05-02',126),(40,'Captain America: The Winter Soldier','Action','2014-04-04',136),(41,'Avengers: Endgame','Sci-Fi','2019-04-26',181),(42,'The Batman','Action','2022-03-04',176),(43,'Dune','Sci-Fi','2021-10-22',155),(44,'Blade Runner 2049','Sci-Fi','2017-10-06',164),(45,'Shutter Island','Thriller','2010-02-19',138),(46,'Gone Girl','Thriller','2014-10-03',149),(47,'Se7en','Crime','1995-09-22',127),(48,'The Prestige','Mystery','2006-10-20',130),(49,'Whiplash','Drama','2014-10-10',107),(50,'The Wolf of Wall Street','Biography','2013-12-25',180);
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-25 12:51:44
