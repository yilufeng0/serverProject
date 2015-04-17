/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : serverproject

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2015-04-17 08:36:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `passwd` varchar(100) NOT NULL,
  `type` varchar(30) NOT NULL,
  `time` varchar(20) NOT NULL,
  `showTime` varchar(20) NOT NULL,
  `operation` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for apps
-- ----------------------------
DROP TABLE IF EXISTS `apps`;
CREATE TABLE `apps` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(30) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `bigVersion` int(10) DEFAULT NULL,
  `mediumVersion` int(10) DEFAULT NULL,
  `smallVersion` int(10) DEFAULT NULL,
  `submit` varchar(100) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  `Url` varchar(200) DEFAULT NULL,
  `showTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for exhibition
-- ----------------------------
DROP TABLE IF EXISTS `exhibition`;
CREATE TABLE `exhibition` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(30) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `oripath` varchar(500) DEFAULT NULL,
  `Url` varchar(200) DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  `thumbpath` varchar(255) DEFAULT NULL,
  `showTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `feedback` varchar(200) DEFAULT NULL,
  `uuId` varchar(200) DEFAULT NULL,
  `operation` varchar(1) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `showTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(30) DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `imageOri` varchar(500) DEFAULT NULL,
  `imageThumbnail` varchar(100) DEFAULT NULL,
  `imageThumbnailUrl` varchar(200) DEFAULT NULL,
  `content` mediumtext,
  `contentUrl` varchar(200) DEFAULT NULL,
  `abstract` varchar(200) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `showTime` varchar(30) DEFAULT NULL,
  `uuid` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for push
-- ----------------------------
DROP TABLE IF EXISTS `push`;
CREATE TABLE `push` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(30) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `tips` varchar(100) DEFAULT NULL,
  `abstract` varchar(200) DEFAULT NULL,
  `area` varchar(30) DEFAULT NULL,
  `object` varchar(30) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
