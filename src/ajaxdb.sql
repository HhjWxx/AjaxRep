/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : ajaxdb

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-03-03 01:24:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `mid` varchar(50) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1111', 'B59C67BF196A4758191E42F76670CEBA');
INSERT INTO `member` VALUES ('11111', 'B0BAEE9D279D34FA1DFD71AADB908C3F');
INSERT INTO `member` VALUES ('admin', '5F4DCC3B5AA765D61D8327DEB882CF99');
