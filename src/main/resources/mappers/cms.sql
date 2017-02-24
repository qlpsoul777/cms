CREATE DATABASE  IF NOT EXISTS `cms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cms`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: cms
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `t_cms_base_article`
--

DROP TABLE IF EXISTS `t_cms_base_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cms_base_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `title` varchar(150) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `refer_name` varchar(45) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `article_source` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `tag_value` varchar(150) DEFAULT NULL,
  `meta_keyword` varchar(255) DEFAULT NULL,
  `introduction` varchar(1000) DEFAULT NULL,
  `content` text,
  `publish_time` datetime DEFAULT NULL,
  `check_time` datetime DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `is_refer` tinyint(4) DEFAULT NULL,
  `logic_status` tinyint(4) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `need_login` tinyint(4) DEFAULT NULL,
  `can_discuss` tinyint(4) DEFAULT NULL,
  `need_check` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `view_num` bigint(20) DEFAULT NULL,
  `catalog_id` bigint(20) DEFAULT NULL,
  `site_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cms_base_article`
--

LOCK TABLES `t_cms_base_article` WRITE;
/*!40000 ALTER TABLE `t_cms_base_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cms_base_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cms_base_catalog`
--

DROP TABLE IF EXISTS `t_cms_base_catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cms_base_catalog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `alias` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `introduction` varchar(45) DEFAULT NULL,
  `path` varchar(45) DEFAULT NULL,
  `content_type` varchar(45) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `img_path` varchar(45) DEFAULT NULL,
  `site_id` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cms_base_catalog`
--

LOCK TABLES `t_cms_base_catalog` WRITE;
/*!40000 ALTER TABLE `t_cms_base_catalog` DISABLE KEYS */;
INSERT INTO `t_cms_base_catalog` VALUES (1,NULL,'2017-02-21 11:11:31',NULL,'2017-02-21 11:11:31','传统武侠','chtwx',1,'传统武侠世界','/wuxia/chtwx','HTML',1,NULL,1,0),(2,NULL,'2017-02-21 11:37:41',NULL,'2017-02-21 15:42:07','古龙','old_long',1,'古龙','/wuxia/chtwx/old_long','JSP',1,NULL,1,1),(3,NULL,'2017-02-21 14:55:51',NULL,'2017-02-22 16:02:31','新派武侠','xpwx',0,'新派武侠世界','/wuxia/xpwx','HTML',2,NULL,1,0);
/*!40000 ALTER TABLE `t_cms_base_catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cms_base_site`
--

DROP TABLE IF EXISTS `t_cms_base_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cms_base_site` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cms_base_site`
--

LOCK TABLES `t_cms_base_site` WRITE;
/*!40000 ALTER TABLE `t_cms_base_site` DISABLE KEYS */;
INSERT INTO `t_cms_base_site` VALUES (1,NULL,'2016-11-22 19:14:52',NULL,NULL,'武侠世界1','武侠','wuxia','wuxia',1,NULL),(2,NULL,'2016-11-22 19:25:32',NULL,NULL,'原创古风','古风','style','style',1,NULL),(3,NULL,'2017-01-09 12:04:04',NULL,'2017-01-09 12:04:04','sadfasfdasdfasdfasdfasdf','电风扇地方','dfs','/dfs/index.html',1,NULL);
/*!40000 ALTER TABLE `t_cms_base_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cms_base_template`
--

DROP TABLE IF EXISTS `t_cms_base_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cms_base_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `path` varchar(150) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `content` longtext,
  `introduction` varchar(255) DEFAULT NULL,
  `catalog_id` bigint(20) DEFAULT NULL,
  `site_id` bigint(20) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cms_base_template`
--

LOCK TABLES `t_cms_base_template` WRITE;
/*!40000 ALTER TABLE `t_cms_base_template` DISABLE KEYS */;
INSERT INTO `t_cms_base_template` VALUES (1,NULL,'2017-02-23 09:24:26',NULL,'2017-02-23 09:24:26','武侠首页模板',0,'/wuxia/index.html',1,'<html>\r\n<body>\r\n<h1>hello world</h1>\r\n</body>\r\n</html>','sadfasfdasdfa',1,1,1),(2,NULL,'2017-02-23 09:35:30',NULL,'2017-02-23 09:35:30','阿斯顿发生',1,'/wuxia/adf/dfsdf.html',1,'fasfasdfasfd','ddddddddddd',1,1,3);
/*!40000 ALTER TABLE `t_cms_base_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cms_permission_user`
--

DROP TABLE IF EXISTS `t_cms_permission_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cms_permission_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `login_name` varchar(45) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_num` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `lock_time` datetime DEFAULT NULL,
  `salt` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cms_permission_user`
--

LOCK TABLES `t_cms_permission_user` WRITE;
/*!40000 ALTER TABLE `t_cms_permission_user` DISABLE KEYS */;
INSERT INTO `t_cms_permission_user` VALUES (1,NULL,NULL,NULL,'2017-01-20 15:57:01','root','vNqskYFKJA2+7vSgP7H62eShTN2cdWSgaH3U9njwIFg=',NULL,NULL,NULL,NULL,NULL,1,1,'2017-01-20 15:57:01','ZSWxKwJyy8eTslaqktQ+Pw==');
/*!40000 ALTER TABLE `t_cms_permission_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-24 15:03:15
