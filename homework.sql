/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-21 22:36:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` char(4) NOT NULL,
  `password` char(20) NOT NULL,
  UNIQUE KEY `login_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1023', 'def');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` char(4) NOT NULL,
  `userid` char(4) NOT NULL,
  `hotelid` char(4) NOT NULL,
  `createtime` char(8) NOT NULL,
  `executetime` char(8) NOT NULL,
  `delaytime` char(8) NOT NULL,
  `duringtime` char(2) NOT NULL,
  `value` char(5) NOT NULL,
  `status` char(1) NOT NULL,
  UNIQUE KEY `order_id_uindex` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion` (
  `id` char(4) DEFAULT NULL,
  `promotionName` char(4) DEFAULT NULL,
  `beginTime` char(20) DEFAULT NULL,
  `endTime` char(20) DEFAULT NULL,
  `discount` char(4) DEFAULT NULL,
  `place` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of promotion
-- ----------------------------
INSERT INTO `promotion` VALUES ('2', '十一', '2016/10/01 12:00:00', '2016/10/07 12:00:00', '0.95', '全国');
INSERT INTO `promotion` VALUES ('3', 'as', '2016/01/03 12:00:00', '2016/01/05 12:00:00', '0.65', '全国');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` char(4) NOT NULL,
  `name` char(10) NOT NULL,
  `credit` char(4) NOT NULL,
  `number` char(11) NOT NULL,
  UNIQUE KEY `user_userid_uindex` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1023', '天', '140', '1213');
