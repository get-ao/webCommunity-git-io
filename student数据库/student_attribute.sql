/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2020-08-31 23:19:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student_attribute
-- ----------------------------
DROP TABLE IF EXISTS `student_attribute`;
CREATE TABLE `student_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `grade` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_attribute
-- ----------------------------
INSERT INTO `student_attribute` VALUES ('25', '1140', '坦克', '19', '男', '艾欧尼亚');
INSERT INTO `student_attribute` VALUES ('26', '1141', '泰坦', '18', '男', '小学生之手');
INSERT INTO `student_attribute` VALUES ('27', '1142', '瑞文', '17', '女', '战争学院');
INSERT INTO `student_attribute` VALUES ('28', '1143', '剑姬', '16', '女', '战争学院');
INSERT INTO `student_attribute` VALUES ('29', '1144', '女警', '15', '女', '战争学院');
INSERT INTO `student_attribute` VALUES ('31', '1152', '小学生之手', '5', '男', '教育网专区');
INSERT INTO `student_attribute` VALUES ('32', '1136', '河蟹', '5', '男', '召唤师峡谷');
INSERT INTO `student_attribute` VALUES ('33', '1135', '盲僧', '22', '男', '瓦罗兰大陆');
INSERT INTO `student_attribute` VALUES ('34', '111', '五千多', '12', '女', '亲卫队去');
INSERT INTO `student_attribute` VALUES ('35', '1133', '小炮', '12', '女', '约德尔人');
INSERT INTO `student_attribute` VALUES ('36', '1131', '提莫', '12', '男', '约德尔人');
