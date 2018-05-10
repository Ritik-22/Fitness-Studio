CREATE DATABASE  IF NOT EXISTS `company` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `company`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: company
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `circle`
--

DROP TABLE IF EXISTS `circle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circle` (
  `cicle_id` varchar(6) DEFAULT NULL,
  `circle_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circle`
--

LOCK TABLES `circle` WRITE;
/*!40000 ALTER TABLE `circle` DISABLE KEYS */;
INSERT INTO `circle` VALUES ('01','janjeerwala square'),('02','palasia square');
/*!40000 ALTER TABLE `circle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cid` varchar(6) DEFAULT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `joindate` date DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `main_phno` int(10) DEFAULT NULL,
  `alternate_phno` int(10) DEFAULT NULL,
  `mon_discount` float DEFAULT NULL,
  `pack_id` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('c01','shashank','king','1996-12-09','2010-07-09','new palasia','indore','madhya_pradesh',998898997,887986880,25,'21'),('c02','shashi','jain','1995-12-09','2012-07-09',' palasia','banglore','uttar_pradesh',998898920,887986380,45,'28'),('c03','prashnt','gupta','1994-12-09','2011-07-09',' palasia','banglore','karnataka',998898970,889868380,15,'38'),('c04','ritik','gupta','1993-12-09','2012-07-09','old palasia','pune','goa',918898970,887986180,50,'14'),('c05','anurag','gupta','1994-12-09','2005-07-09',' palasia','banglore','karnataka',998989270,887986380,15,'14');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dept_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `E_id` varchar(20) DEFAULT NULL,
  `E_name` varchar(20) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `hometown` varchar(20) DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `E_salary` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('ss0001','Rohit Patel','1996-12-13',30,'Jabalpur','Malik',2000000),('ss0002','Anurag Agrawal','1967-09-09',50,'Satna','Badelog',1500000),('ss0003','Shreyash Jain','1996-09-06',20,'Harda','Maalik ka Nokar',1750000),('ss0004','Shivam Somani','1997-03-07',20,'Mandsaur','Maalik ka Nokar',1750000);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packages`
--

DROP TABLE IF EXISTS `packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packages` (
  `pac_id` varchar(6) DEFAULT NULL,
  `pname` varchar(20) DEFAULT NULL,
  `speed` varchar(10) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `mon_payment` float DEFAULT NULL,
  `circle_id` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packages`
--

LOCK TABLES `packages` WRITE;
/*!40000 ALTER TABLE `packages` DISABLE KEYS */;
INSERT INTO `packages` VALUES ('21','silver','2Mbps','2017-07-01',775,'01'),('28','silver+','3Mbps','2017-07-02',875,'01'),('30','gold','4Mbps','2017-06-02',975,'02'),('14','gold+','5Mbps','2017-05-01',1075,'02');
/*!40000 ALTER TABLE `packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saloon`
--

DROP TABLE IF EXISTS `saloon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saloon` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `booked_chair` varchar(5) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `service` varchar(20) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saloon`
--

LOCK TABLES `saloon` WRITE;
/*!40000 ALTER TABLE `saloon` DISABLE KEYS */;
/*!40000 ALTER TABLE `saloon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-10 17:30:49
