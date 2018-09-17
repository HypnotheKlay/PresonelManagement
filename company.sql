/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : company

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-11 09:18:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `MaName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '网络部', '唐骏彬');
INSERT INTO `department` VALUES ('2', '秘书部', '成关炜');
INSERT INTO `department` VALUES ('3', '人力资源部', '李剑童');
INSERT INTO `department` VALUES ('4', '公关部', '郭志城');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `professional` varchar(255) DEFAULT NULL,
  `departmentID` int(11) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `password` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '唐骏彬', '全栈工程师', '1', '0', '123456');
INSERT INTO `employee` VALUES ('2', '李剑童', 'CEO', '3', '1', '123456');
INSERT INTO `employee` VALUES ('3', '温超杰', 'java工程师', '1', '0', '123456');
INSERT INTO `employee` VALUES ('4', '郭志城', '营销顾问', '4', '0', '123456');
INSERT INTO `employee` VALUES ('5', '朱家杰', '秘书', '2', '0', '123456');
INSERT INTO `employee` VALUES ('6', '成关炜', '营销顾问', '4', '0', '123456');
INSERT INTO `employee` VALUES ('7', '赵同心', '秘书', '2', '0', '123456');
INSERT INTO `employee` VALUES ('8', '梁润雄', '打杂', '3', '1', '123456');
INSERT INTO `employee` VALUES ('20', 'Test', 'test', '2', '0', '12546');
