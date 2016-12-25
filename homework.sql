-- MySQL dump 10.13  Distrib 5.7.16, for osx10.11 (x86_64)
--
-- Host: localhost    Database: homework
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `hotelid` char(4) NOT NULL,
  `position` char(2) NOT NULL,
  `address` char(2) NOT NULL,
  `hotelname` char(10) NOT NULL,
  `avdachuangfang` char(2) DEFAULT NULL,
  `avsanrenjian` char(2) DEFAULT NULL,
  `avshuangrenfang` char(2) DEFAULT NULL,
  `dachuangfangprice` char(2) DEFAULT NULL,
  `shuangrenjianprice` char(2) DEFAULT NULL,
  `sanrenjianprice` char(2) DEFAULT NULL,
  `star` char(1) NOT NULL,
  `score` char(4) NOT NULL,
  `assess` char(20) NOT NULL,
  `description` char(20) NOT NULL,
  `scorenum` char(2) DEFAULT NULL,
  UNIQUE KEY `hotel_hotelid_uindex` (`hotelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES ('2210','仙林','南京','酒店','30','40','50','30','40','50','4','3.12','我勒个擦','掉渣天',NULL);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` char(4) NOT NULL,
  `password` char(20) NOT NULL,
  `online` char(1) DEFAULT NULL,
  UNIQUE KEY `login_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('1023','def','0'),('2210','abc','0'),('3130','123','0'),('4444','345','0');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `orderid` char(4) NOT NULL,
  `userid` char(4) NOT NULL,
  `hotelid` char(4) NOT NULL,
  `createtime` char(8) NOT NULL,
  `executetime` char(8) NOT NULL,
  `delaytime` char(8) NOT NULL,
  `endtime` char(8) DEFAULT NULL,
  `value` char(5) NOT NULL,
  `status` char(1) NOT NULL,
  `roomnum` char(2) DEFAULT NULL,
  `roomstyle` char(1) DEFAULT NULL,
  `assess` char(20) DEFAULT NULL,
  `discount` char(4) DEFAULT NULL,
  `score` char(1) DEFAULT NULL,
  UNIQUE KEY `order_id_uindex` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `id` char(4) NOT NULL,
  `promotionName` char(4) NOT NULL,
  `beginTime` char(20) NOT NULL,
  `endTime` char(20) NOT NULL,
  `discount` char(4) NOT NULL,
  `place` char(5) NOT NULL,
  UNIQUE KEY `promotion_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES ('2','十一','20161220','20170107','0.95','南京_仙林');
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotioner`
--

DROP TABLE IF EXISTS `promotioner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotioner` (
  `id` char(4) NOT NULL,
  `name` char(10) NOT NULL,
  UNIQUE KEY `promotioner_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotioner`
--

LOCK TABLES `promotioner` WRITE;
/*!40000 ALTER TABLE `promotioner` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotioner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` char(4) NOT NULL,
  `name` char(10) NOT NULL,
  `credit` char(4) NOT NULL,
  `number` char(11) NOT NULL,
  `birthday` char(8) DEFAULT NULL,
  `company` char(6) DEFAULT NULL,
  UNIQUE KEY `user_userid_uindex` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1023','名字','20','12345678910','19960101',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-25 14:02:04
