/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2020-09-01 15:26:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student_user
-- ----------------------------
DROP TABLE IF EXISTS `student_user`;
CREATE TABLE `student_user` (
  `id` int(255) NOT NULL,
  `user` varchar(255) NOT NULL,
  `psw` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_user
-- ----------------------------
INSERT INTO `student_user` VALUES ('1', '1136', '111');
INSERT INTO `student_user` VALUES ('2', '1137', '333');
