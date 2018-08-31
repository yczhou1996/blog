/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : personal

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2018-08-31 18:02:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `content` text,
  `author_id` int(11) default NULL,
  `categories` varchar(255) default NULL,
  `add_time` timestamp NULL default NULL,
  `update_time` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('27', '技术');
INSERT INTO `t_category` VALUES ('28', '生活');
INSERT INTO `t_category` VALUES ('29', '技巧');
INSERT INTO `t_category` VALUES ('30', '养生');

-- ----------------------------
-- Table structure for t_gallery
-- ----------------------------
DROP TABLE IF EXISTS `t_gallery`;
CREATE TABLE `t_gallery` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `photo` varchar(255) default NULL,
  `author_id` int(11) default NULL,
  `add_time` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gallery
-- ----------------------------
INSERT INTO `t_gallery` VALUES ('2', 'timg.jpg', '/upload/2018/08/20180829133131.jpg', '1', '2018-08-29 13:31:31');
INSERT INTO `t_gallery` VALUES ('3', 'timg.jpg', '/upload/2018/08/20180829133203.jpg', '1', '2018-08-29 13:32:03');
INSERT INTO `t_gallery` VALUES ('4', 'cola.jpg', '/upload/2018/08/20180829133232.jpg', '1', '2018-08-29 13:32:32');
INSERT INTO `t_gallery` VALUES ('5', 'timg.jpg', '/upload/2018/08/20180829133835.jpg', '1', '2018-08-29 13:38:35');
INSERT INTO `t_gallery` VALUES ('6', 'timg.jpg', '/upload/2018/08/20180829133928.jpg', '1', '2018-08-29 13:39:28');
INSERT INTO `t_gallery` VALUES ('7', 'timg.jpg', '/upload/2018/08/20180829134740.jpg', '1', '2018-08-29 13:47:40');
INSERT INTO `t_gallery` VALUES ('8', '13d6c9f81a4c510f70573b6a6359252dd52aa546.jpg', '/upload/2018/08/20180829140401.jpg', '1', '2018-08-29 14:04:01');
INSERT INTO `t_gallery` VALUES ('11', 'timg.jpg', '/upload/2018/08/20180829140804.jpg', '1', '2018-08-29 14:08:23');

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
INSERT INTO `t_plan` VALUES ('1', 'eat', 'eat', null, '2018-08-30 00:00:00', '2018-08-31 00:00:00', null);
INSERT INTO `t_plan` VALUES ('5', 'sleep', 's', null, '2018-08-24 00:00:00', '2018-08-24 00:00:00', null);

-- ----------------------------
-- Table structure for t_relationships
-- ----------------------------
DROP TABLE IF EXISTS `t_relationships`;
CREATE TABLE `t_relationships` (
  `aid` int(10) unsigned NOT NULL,
  `cid` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`aid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_relationships
-- ----------------------------

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
INSERT INTO `t_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'JoJo', 'yczhou1229@gmail.com', '15858370068', '648922974', '', '', '/upload/2018/08/20180829171434.jpg');
SET FOREIGN_KEY_CHECKS=1;
