/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2020-09-01 15:24:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher_user
-- ----------------------------
DROP TABLE IF EXISTS `teacher_user`;
CREATE TABLE `teacher_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_user` varchar(255) NOT NULL,
  `t_psw` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_user
-- ----------------------------
INSERT INTO `teacher_user` VALUES ('1', '111', '111');
