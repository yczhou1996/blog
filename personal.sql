/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : personal

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2018-08-24 17:58:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `add_time` timestamp NULL default NULL,
  `update_time` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------

-- ----------------------------
-- Table structure for t_classify
-- ----------------------------
DROP TABLE IF EXISTS `t_classify`;
CREATE TABLE `t_classify` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classify
-- ----------------------------

-- ----------------------------
-- Table structure for t_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_plan`;
CREATE TABLE `t_plan` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `author_id` int(11) default NULL,
  `start_time` timestamp NULL default NULL,
  `end_time` timestamp NULL default NULL,
  `add_time` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_plan
-- ----------------------------
INSERT INTO `t_plan` VALUES ('1', 'eat', 'eat', null, '2018-08-24 00:00:00', '2018-08-24 00:00:00', null);
INSERT INTO `t_plan` VALUES ('5', 'sleep', 's', null, '2018-08-24 00:00:00', '2018-08-24 00:00:00', null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL COMMENT '账号',
  `password` varchar(255) default NULL COMMENT '密码',
  `fullname` varchar(255) default NULL COMMENT '姓名',
  `email` varchar(255) default NULL COMMENT '邮箱',
  `phone` varchar(255) default NULL COMMENT '电话',
  `qq` varchar(255) default NULL,
  `weibo` varchar(255) default NULL,
  `intro` varchar(255) default NULL COMMENT '简介',
  `photo` varchar(255) default NULL COMMENT '头像',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123456', 'Alex', 'yczhou1229@gmail.com', '', '', '', '', '');
SET FOREIGN_KEY_CHECKS=1;
