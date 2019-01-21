/*
Navicat MySQL Data Transfer

Source Server         : windows10
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : qixing_db

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-12 19:44:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `qname` varchar(20) NOT NULL COMMENT '权限名称',
  `description` varchar(300) NOT NULL COMMENT '权限描述',
  `sort` smallint(6) NOT NULL COMMENT '权限排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '超级管理员', '超级管理员', '1');
INSERT INTO `authority` VALUES ('2', '新闻管理员', '新闻管理员', '2');
INSERT INTO `authority` VALUES ('3', '后台管理员', '后台管理员', '3');

-- ----------------------------
-- Table structure for aware
-- ----------------------------
DROP TABLE IF EXISTS `aware`;
CREATE TABLE `aware` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) NOT NULL COMMENT '问题标题',
  `thumb` varchar(300) DEFAULT NULL COMMENT '标签图像',
  `description` varchar(2000) NOT NULL COMMENT '问题描述',
  `attentionCount` int(11) DEFAULT '0' COMMENT '关注数',
  `tags` varchar(100) NOT NULL COMMENT '标签',
  `answerCount` int(11) DEFAULT '0' COMMENT '回答数',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `userId` int(11) NOT NULL,
  `status` char(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of aware
-- ----------------------------
INSERT INTO `aware` VALUES ('1', '为什么很多人最终都会变成自己讨厌的模样？', 'test.png', '真的是因为，自己讨厌的的那副样子，恰恰是因为对方有了自己想要的，所以讨厌？', '0', '1,2', '1', '2018-12-11 22:32:28', '1', '1');
INSERT INTO `aware` VALUES ('2', '提问 我要回答\r\n为什么无知者往往固执？', 'test.pngt', '感觉”无知者无畏“这句话是真理啊！为什么那些越无知的人就越觉得自己坚持的是对的？', '0', '1,2', '1', '2018-12-11 22:33:17', '2', '1');

-- ----------------------------
-- Table structure for aware_comment
-- ----------------------------
DROP TABLE IF EXISTS `aware_comment`;
CREATE TABLE `aware_comment` (
  `id` int(11) NOT NULL COMMENT '主键',
  `content` varchar(2000) NOT NULL COMMENT '讨论内容',
  `createTime` datetime NOT NULL COMMENT '讨论时间',
  `acceptCount` smallint(6) DEFAULT NULL COMMENT '认同数量',
  `denyCount` smallint(6) DEFAULT NULL COMMENT '否认数量',
  `awareId` int(11) NOT NULL COMMENT '讨论对象',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of aware_comment
-- ----------------------------

-- ----------------------------
-- Table structure for aware_tags
-- ----------------------------
DROP TABLE IF EXISTS `aware_tags`;
CREATE TABLE `aware_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，标签ID',
  `qname` varchar(20) NOT NULL COMMENT '标签名称',
  `description` varchar(500) NOT NULL COMMENT '表情描述',
  `attentionCount` int(11) DEFAULT '0' COMMENT '关注数量',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `awareTypeId` int(11) NOT NULL COMMENT '标签类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of aware_tags
-- ----------------------------
INSERT INTO `aware_tags` VALUES ('1', '心理学', '心理学', '0', '2018-12-11 22:27:36', '1');
INSERT INTO `aware_tags` VALUES ('2', '人文', '人文', '0', '2018-12-04 22:28:20', '1');
INSERT INTO `aware_tags` VALUES ('3', '社会科学', '社会科学', '0', '2018-12-11 22:28:39', '1');
INSERT INTO `aware_tags` VALUES ('4', '历史', '历史', '0', '2018-12-11 22:28:57', '1');
INSERT INTO `aware_tags` VALUES ('5', '互联网', '互联网', '0', '2018-12-11 22:29:15', '2');
INSERT INTO `aware_tags` VALUES ('6', '电子', '电子', '0', '2018-12-11 22:29:26', '2');
INSERT INTO `aware_tags` VALUES ('7', '计算机', '计算机', '0', '2018-12-11 22:29:38', '2');
INSERT INTO `aware_tags` VALUES ('8', '电子产品', '电子产品', '0', '2018-12-11 22:29:50', '2');
INSERT INTO `aware_tags` VALUES ('9', '生活', '生活', '0', '2018-12-11 22:30:08', '3');
INSERT INTO `aware_tags` VALUES ('10', '医学', '医学', '0', '2018-12-11 22:30:28', '3');
INSERT INTO `aware_tags` VALUES ('11', '生物', '生物', '0', '2018-12-11 22:30:42', '4');
INSERT INTO `aware_tags` VALUES ('12', '物理学', '物理学', '0', '2018-12-11 22:30:54', '4');

-- ----------------------------
-- Table structure for aware_type
-- ----------------------------
DROP TABLE IF EXISTS `aware_type`;
CREATE TABLE `aware_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qname` varchar(20) NOT NULL COMMENT '标签类型名称',
  `description` varchar(500) NOT NULL COMMENT '标签类型描述',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of aware_type
-- ----------------------------
INSERT INTO `aware_type` VALUES ('1', '人文社科', '人文·社科', '1');
INSERT INTO `aware_type` VALUES ('2', '科学技术', '科学·技术', '2');
INSERT INTO `aware_type` VALUES ('3', '生活·娱乐 ', '生活·娱乐 ', '3');
INSERT INTO `aware_type` VALUES ('4', '自然·生态', '自然·生态', '4');

-- ----------------------------
-- Table structure for browse_log
-- ----------------------------
DROP TABLE IF EXISTS `browse_log`;
CREATE TABLE `browse_log` (
  `id` int(11) NOT NULL COMMENT '浏览记录ID',
  `browseTime` datetime NOT NULL COMMENT '浏览时间',
  `articleId` int(11) NOT NULL COMMENT '文章Id',
  `articelType` int(11) NOT NULL COMMENT '文章 类型',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of browse_log
-- ----------------------------

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL COMMENT '收藏ID',
  `articleId` int(11) NOT NULL COMMENT '文章ID',
  `collectionTime` datetime NOT NULL COMMENT '收藏时间',
  `articleType` smallint(6) NOT NULL COMMENT '文章类型',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform` (
  `id` int(11) NOT NULL COMMENT '通知ID',
  `title` varchar(50) NOT NULL COMMENT '通知标题',
  `content` varchar(500) NOT NULL COMMENT '通知内容',
  `createTime` datetime NOT NULL COMMENT '通知时间',
  `managerId` int(11) DEFAULT NULL COMMENT '管理员ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of inform
-- ----------------------------

-- ----------------------------
-- Table structure for it
-- ----------------------------
DROP TABLE IF EXISTS `it`;
CREATE TABLE `it` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'IT文章ID',
  `title` varchar(50) NOT NULL COMMENT '文章标题',
  `author` varchar(30) NOT NULL COMMENT '文章作者',
  `content` text NOT NULL COMMENT '文章内容',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `readingCount` int(11) NOT NULL DEFAULT '0' COMMENT '阅读数量',
  `itCategoryId` int(11) NOT NULL COMMENT '分类ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `status` char(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of it
-- ----------------------------
INSERT INTO `it` VALUES ('1', '打发士大夫', '方法', '房贷首付', '2018-12-04 23:40:29', '0', '1', '1', '1');

-- ----------------------------
-- Table structure for it_category
-- ----------------------------
DROP TABLE IF EXISTS `it_category`;
CREATE TABLE `it_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id文章分类',
  `qname` varchar(20) NOT NULL COMMENT '分类名称',
  `description` varchar(300) NOT NULL COMMENT '分类描述',
  `sort` smallint(6) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of it_category
-- ----------------------------
INSERT INTO `it_category` VALUES ('1', '前端', '前端', '1');
INSERT INTO `it_category` VALUES ('2', 'Android', 'Android', '2');
INSERT INTO `it_category` VALUES ('3', '后端', '后端', '3');
INSERT INTO `it_category` VALUES ('4', '人工智能', '人工智能', '4');
INSERT INTO `it_category` VALUES ('5', 'iOS', 'iOS', '5');
INSERT INTO `it_category` VALUES ('6', '工具资源', '工具资源', '6');
INSERT INTO `it_category` VALUES ('7', '运维', '运维', '7');

-- ----------------------------
-- Table structure for it_comment
-- ----------------------------
DROP TABLE IF EXISTS `it_comment`;
CREATE TABLE `it_comment` (
  `id` int(11) NOT NULL COMMENT 'it文章评论ID',
  `content` varchar(500) NOT NULL COMMENT '评论内容',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `itId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of it_comment
-- ----------------------------

-- ----------------------------
-- Table structure for it_tags
-- ----------------------------
DROP TABLE IF EXISTS `it_tags`;
CREATE TABLE `it_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'it文章标签ID',
  `qname` varchar(20) NOT NULL COMMENT '标签名称',
  `description` varchar(300) NOT NULL COMMENT '标签描述',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `categoryId` int(11) DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of it_tags
-- ----------------------------
INSERT INTO `it_tags` VALUES ('1', 'Vue.js', 'Vue.js', '2018-12-11 15:46:56', '1');
INSERT INTO `it_tags` VALUES ('2', 'Angular.js', 'Angular.js', '2018-12-04 15:47:26', '1');
INSERT INTO `it_tags` VALUES ('3', 'python', 'python', '2018-12-04 15:48:14', '2');
INSERT INTO `it_tags` VALUES ('4', 'java', 'java', '2018-12-13 15:48:28', '2');
INSERT INTO `it_tags` VALUES ('5', 'php', 'php', '2018-12-11 15:48:47', '2');

-- ----------------------------
-- Table structure for live
-- ----------------------------
DROP TABLE IF EXISTS `live`;
CREATE TABLE `live` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '生活文章ID',
  `title` varchar(50) NOT NULL COMMENT '文章标题',
  `content` text NOT NULL COMMENT '文章内容',
  `readingCount` int(11) DEFAULT '0' COMMENT '阅读数量',
  `likeCount` int(11) DEFAULT '0' COMMENT '不喜欢数量',
  `dislikeCount` int(11) DEFAULT '0' COMMENT '喜欢数量',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `topicId` int(11) NOT NULL COMMENT '话题id',
  `status` char(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of live
-- ----------------------------
INSERT INTO `live` VALUES ('1', '这部关于知青的禁片，让她成为国内第一个金马影后！', '说到金马影后，大家一直都还是觉得分量很重的。\r\n\r\n例如之前被嘲的很厉害的周冬雨凭借《七月与安生》拿到金马影后之后，口碑一下逆转，直接成为了90后小花的领军人物。', '0', '0', '0', '2018-12-11 23:13:35', '1', '1', '1');
INSERT INTO `live` VALUES ('2', '濮存昕：我演的东西没人看！流量为王的时代，老戏骨竟纷纷下台...', '01\r\n\r\n“我演的东西没人看”\r\n\r\n“我演的东西没人看。”说这句话的不是别人而是濮存昕。\r\n\r\n这句话，对于演员而言无疑是一件可悲的事情。可是对于观众而言，这也是一件可惜的事情。', '0', '0', '0', '2018-12-11 23:14:06', '1', '1', '1');

-- ----------------------------
-- Table structure for live_comment
-- ----------------------------
DROP TABLE IF EXISTS `live_comment`;
CREATE TABLE `live_comment` (
  `id` int(11) NOT NULL,
  `content` varchar(500) NOT NULL,
  `createTime` datetime NOT NULL,
  `liveId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of live_comment
-- ----------------------------

-- ----------------------------
-- Table structure for live_topic
-- ----------------------------
DROP TABLE IF EXISTS `live_topic`;
CREATE TABLE `live_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '话题ID',
  `qname` char(10) NOT NULL COMMENT '话题名称',
  `thumb` varchar(300) DEFAULT NULL COMMENT '头像',
  `description` varchar(300) NOT NULL COMMENT '话题描述',
  `articleCount` int(11) DEFAULT '0' COMMENT '文章数量',
  `attentionCount` int(11) DEFAULT '0' COMMENT '关注数量',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of live_topic
-- ----------------------------
INSERT INTO `live_topic` VALUES ('1', '电影', '', '电影', '0', '0', '2018-12-11 23:15:47', '1');
INSERT INTO `live_topic` VALUES ('2', '读书', null, '读书', '0', '0', '2018-12-11 23:16:17', '2');
INSERT INTO `live_topic` VALUES ('3', '大学生活', null, '大学生活', '0', '0', '2018-12-11 23:17:14', '3');

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` int(11) NOT NULL COMMENT '登录记录ID',
  `loginTime` datetime NOT NULL COMMENT '登录时间',
  `loginIp` varchar(50) NOT NULL COMMENT '登录IP',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of login_log
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID，自增',
  `account` varchar(10) NOT NULL COMMENT '账号',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `createTime` datetime NOT NULL COMMENT '创建时时间',
  `lastTime` datetime DEFAULT NULL COMMENT '上次登录时间',
  `authorityId` smallint(6) DEFAULT NULL COMMENT '权限ID',
  `status` char(1) DEFAULT '1' COMMENT '1-开启，0-禁用',
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('3', '86608', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:31', '2018-12-10 10:23:31', '1', '1', 'test@163.com');
INSERT INTO `manager` VALUES ('4', '14828', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:31', '2018-12-10 10:23:31', '1', '1', 'test@163.com');
INSERT INTO `manager` VALUES ('5', '104312', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:32', '2018-12-10 10:23:32', '1', '1', 'test@163.com');
INSERT INTO `manager` VALUES ('6', '67081', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:32', '2018-12-10 10:23:32', '1', '0', 'test@163.com');
INSERT INTO `manager` VALUES ('7', '12470', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:32', '2018-12-10 10:23:32', '1', '1', 'test@163.com');
INSERT INTO `manager` VALUES ('8', '51102', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:33', '2018-12-10 10:23:33', '1', '0', 'test@163.com');
INSERT INTO `manager` VALUES ('9', '108102', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:33', '2018-12-10 10:23:33', '1', '0', 'test@163.com');
INSERT INTO `manager` VALUES ('10', '77209', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:33', '2018-12-10 10:23:33', '1', '1', 'test@163.com');
INSERT INTO `manager` VALUES ('11', '51737', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:34', '2018-12-10 10:23:34', '1', '0', 'test@163.com');
INSERT INTO `manager` VALUES ('12', '17057', 'test', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:34', '2018-12-10 10:23:34', '1', '0', 'test@163.com');
INSERT INTO `manager` VALUES ('13', '20073', 'hi', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:42', '2018-12-10 10:23:42', '1', '0', 'test@163.com');
INSERT INTO `manager` VALUES ('14', '39196', 'hi', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:52', '2018-12-10 10:23:52', '2', '0', 'test@163.com');
INSERT INTO `manager` VALUES ('15', '25760', 'hi', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:52', '2018-12-10 10:23:52', '2', '0', 'test@163.com');
INSERT INTO `manager` VALUES ('16', '101213', 'hi', '$10$DcpsGI8GsSVDrOpIDpB/LutCRyge2xpeQOa4tZue97w9JD0TBSB2.', '2018-12-10 10:23:53', '2018-12-10 10:23:53', '2', '1', 'test@163.com');
INSERT INTO `manager` VALUES ('17', 'fdffadsf', 'fasdfasdf', 'ereerer', '2018-12-10 15:52:11', null, '1', '1', 'ssfasdf@44.com');

-- ----------------------------
-- Table structure for manager_login_log
-- ----------------------------
DROP TABLE IF EXISTS `manager_login_log`;
CREATE TABLE `manager_login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `managerId` int(11) DEFAULT NULL COMMENT '管理员id',
  `loginTime` datetime DEFAULT NULL COMMENT '登录时间',
  `loginLocation` varchar(100) DEFAULT NULL COMMENT '登录地点',
  `loginIp` varchar(50) DEFAULT NULL COMMENT '登录IP',
  `duration` double DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of manager_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for manager_role
-- ----------------------------
DROP TABLE IF EXISTS `manager_role`;
CREATE TABLE `manager_role` (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT 'ID-主键',
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `identity` varchar(30) DEFAULT NULL COMMENT '标识',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` char(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of manager_role
-- ----------------------------
INSERT INTO `manager_role` VALUES ('1', '超级管理员', '121', '的方法', '2018-12-26 11:18:25', '0');
INSERT INTO `manager_role` VALUES ('2', '后台管理员', '2323', '后台管理员', '2018-12-05 13:42:48', '0');
INSERT INTO `manager_role` VALUES ('3', 'fsdf', 'sdfsdf', 'sfasdf', '2018-12-12 15:42:21', '1');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL COMMENT '消息ID',
  `content` varchar(500) NOT NULL COMMENT '消息内容',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `status` tinyint(1) NOT NULL COMMENT '状态',
  `managerId` int(11) NOT NULL COMMENT '管理员ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `source` varchar(20) DEFAULT NULL COMMENT '来源',
  `summary` varchar(300) DEFAULT NULL COMMENT '摘要',
  `content` text COMMENT '内容',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `likeCount` int(11) DEFAULT NULL COMMENT '喜欢数量',
  `readingCount` int(11) DEFAULT NULL COMMENT '阅读数',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `status` char(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('2', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('3', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('4', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('5', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '2', '1');
INSERT INTO `news` VALUES ('6', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('7', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('8', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('9', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('10', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('11', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('12', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('13', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('14', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('15', 'fsdfsf', 'dfsdf', 'dsf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('16', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('17', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('18', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('19', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '2', '1');
INSERT INTO `news` VALUES ('20', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('21', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '0');
INSERT INTO `news` VALUES ('22', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('23', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');
INSERT INTO `news` VALUES ('24', 'fsdfsf', 'dfsdf', 'dfsdf', 'fsdfsdf', 'sfasdfb', '2018-12-04 22:19:09', '2', '3', '1', '1');

-- ----------------------------
-- Table structure for news_category
-- ----------------------------
DROP TABLE IF EXISTS `news_category`;
CREATE TABLE `news_category` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `qname` varchar(20) DEFAULT NULL COMMENT '新闻种类名称',
  `description` varchar(100) DEFAULT NULL COMMENT '新闻种类描述',
  `sort` int(3) DEFAULT NULL COMMENT '新闻种类排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of news_category
-- ----------------------------
INSERT INTO `news_category` VALUES ('1', '军事', '军事', '1');
INSERT INTO `news_category` VALUES ('2', '体育', '体育', '2');
INSERT INTO `news_category` VALUES ('3', '财经', '财经', '3');

-- ----------------------------
-- Table structure for news_comment
-- ----------------------------
DROP TABLE IF EXISTS `news_comment`;
CREATE TABLE `news_comment` (
  `id` int(11) NOT NULL COMMENT '新闻评论ID',
  `content` varchar(500) NOT NULL COMMENT '评论内容',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `newsId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of news_comment
-- ----------------------------

-- ----------------------------
-- Table structure for news_tags
-- ----------------------------
DROP TABLE IF EXISTS `news_tags`;
CREATE TABLE `news_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻标签ID',
  `qname` varchar(20) NOT NULL COMMENT '标签名称',
  `description` varchar(300) NOT NULL COMMENT '标签描述',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `categoryId` int(11) DEFAULT NULL COMMENT '标签分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of news_tags
-- ----------------------------
INSERT INTO `news_tags` VALUES ('1', '韩国军事', '韩国军事', '2018-12-11 10:53:04', '1');
INSERT INTO `news_tags` VALUES ('2', '美国军事', '美国军事', '2018-12-12 10:54:06', '1');
INSERT INTO `news_tags` VALUES ('3', '德国军事', '德国军事', '2018-12-11 10:54:26', '1');
INSERT INTO `news_tags` VALUES ('4', '世界杯', '世界杯', '2018-12-11 10:56:52', '2');
INSERT INTO `news_tags` VALUES ('5', 'NBA', 'NBA', '2018-12-11 10:57:10', '2');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('田园风', '9z9MO+ku7en0p7hDbppcKw==', 'i5d28NilDWLGpIpcls1cGw==', '2018-12-12 18:53:29');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'KZ07kUTAR0KyqkMUR5rQog==', 'J6WYZH+4LcbM/PxSLq13GQ==', '2018-12-12 18:50:33');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'ncSo9u4zrDGfbzMNj8GrzQ==', 'Osd0BLK8EaSz1HVQ7ot8Vw==', '2018-12-12 15:13:39');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'oEeaI+hlfvhpj6agjhviOg==', 'XWeMhiZRXZkNhESldO/apA==', '2018-12-12 09:46:37');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'p2PratZqXOC7Bu9KRiPRLw==', 'R7A3jk9fNa74SL6QV6bomA==', '2018-12-12 11:37:51');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'RNvm/vCLkkqCDLoU5r7qTA==', 'YXYv0lECLbczZNThCW3jTw==', '2018-12-12 11:49:22');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'Ti2PVMwxO1WG+EX0jafpwQ==', '88DzyNvbQ77xuJHQK/v6Pw==', '2018-12-12 13:23:37');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'ulTfQ6bYV49mu3gKIdyJQQ==', 'v9svDxGHT/UUz2rzGyVBag==', '2018-12-12 15:11:02');
INSERT INTO `persistent_logins` VALUES ('admin', 'W8hXc6N1sEnZoFFWJJfYcQ==', 'WR4Ck1jK5+wdAsaRCXw35A==', '2018-12-12 18:51:55');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'whIS1n4wlo/FoDdojKQ67A==', 'ZwXOjSVOiJkb9vLzhnu0NQ==', '2018-12-12 11:37:11');
INSERT INTO `persistent_logins` VALUES ('tianjinshan', 'y0EnVUmPk8PUWw8+8SoDCg==', 'fWG71xJ1UXaSk49L8JI/wA==', '2018-12-12 13:24:10');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` char(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通会员', '普通会员\n                 ', '2018-12-06 17:42:02', '1');
INSERT INTO `role` VALUES ('2', 'VIP会员', '111\n                 ', '2018-12-06 17:42:42', '1');
INSERT INTO `role` VALUES ('3', '新闻会员', '新闻', '2018-12-06 21:43:04', '0');
INSERT INTO `role` VALUES ('4', '博客会员', '博客', '2018-12-06 21:44:13', '0');
INSERT INTO `role` VALUES ('5', '签约会员', '签约会员', '2018-12-06 21:44:54', '1');
INSERT INTO `role` VALUES ('8', '测试会员', '测试会员', '2018-12-07 13:26:41', '0');
INSERT INTO `role` VALUES ('9', '游客', '测试会员2\n                 \n                 \n                 ', '2018-12-07 13:26:46', '1');
INSERT INTO `role` VALUES ('10', '测试会员', '测试会员', '2018-12-07 13:26:46', '1');
INSERT INTO `role` VALUES ('11', '测试会员', '测试会员', '2018-12-07 13:26:46', '1');
INSERT INTO `role` VALUES ('12', '测试会员', '测试会员', '2018-12-07 13:26:46', '1');
INSERT INTO `role` VALUES ('13', '测试会员', '测试会员', '2018-12-07 13:26:46', '0');
INSERT INTO `role` VALUES ('14', '游客', '测试会员', '2018-12-07 13:26:47', '0');
INSERT INTO `role` VALUES ('15', '测试会员', '测试会员', '2018-12-07 13:26:47', '0');
INSERT INTO `role` VALUES ('16', '投稿会员', '投稿会员', '2018-12-07 13:27:29', '0');
INSERT INTO `role` VALUES ('17', '投稿会员', '投稿会员', '2018-12-07 13:27:29', '1');
INSERT INTO `role` VALUES ('18', '投稿会员', '投稿会员', '2018-12-07 13:27:30', '1');
INSERT INTO `role` VALUES ('19', '投稿会员', '投稿会员', '2018-12-07 13:27:30', '0');
INSERT INTO `role` VALUES ('20', '投稿会员', '投稿会员', '2018-12-07 13:27:30', '0');
INSERT INTO `role` VALUES ('21', '投稿会员', '投稿会员', '2018-12-07 13:27:31', '0');
INSERT INTO `role` VALUES ('22', '投稿会员', '投稿会员', '2018-12-07 13:27:31', '1');
INSERT INTO `role` VALUES ('23', '投稿会员', '投稿会员', '2018-12-07 13:27:31', '1');
INSERT INTO `role` VALUES ('24', '投稿会员', '投稿会员', '2018-12-07 13:27:32', '1');
INSERT INTO `role` VALUES ('25', '投稿会员', '投稿会员', '2018-12-07 13:27:32', '1');
INSERT INTO `role` VALUES ('26', '随机会员', '随机会员', '2018-12-07 13:27:54', '0');
INSERT INTO `role` VALUES ('27', '随机会员', '随机会员', '2018-12-07 13:27:54', '0');
INSERT INTO `role` VALUES ('28', '随机会员', '随机会员', '2018-12-07 13:27:54', '1');
INSERT INTO `role` VALUES ('29', '随机会员', '随机会员', '2018-12-07 13:27:55', '1');
INSERT INTO `role` VALUES ('30', '随机会员', '随机会员', '2018-12-07 13:27:55', '1');
INSERT INTO `role` VALUES ('31', '随机会员', '随机会员', '2018-12-07 13:27:55', '1');
INSERT INTO `role` VALUES ('32', '随机会员', '随机会员', '2018-12-07 13:27:55', '1');
INSERT INTO `role` VALUES ('33', '随机会员', '随机会员', '2018-12-07 13:27:56', '1');
INSERT INTO `role` VALUES ('34', '随机会员', '随机会员', '2018-12-07 13:27:56', '1');
INSERT INTO `role` VALUES ('35', '随机会员', '随机会员', '2018-12-07 13:27:56', '1');
INSERT INTO `role` VALUES ('36', '随机会员', '随机会员', '2018-12-07 13:27:56', '1');
INSERT INTO `role` VALUES ('37', '随机会员', '随机会员', '2018-12-07 13:27:56', '1');
INSERT INTO `role` VALUES ('38', '随机会员', '随机会员', '2018-12-07 13:27:57', '1');
INSERT INTO `role` VALUES ('39', '随机会员', '随机会员', '2018-12-07 13:27:57', '0');
INSERT INTO `role` VALUES ('40', '随机会员', '随机会员', '2018-12-07 13:27:57', '1');
INSERT INTO `role` VALUES ('41', '随机会员', '随机会员', '2018-12-07 13:27:58', '1');
INSERT INTO `role` VALUES ('42', '随机会员', '随机会员', '2018-12-07 13:27:58', '1');
INSERT INTO `role` VALUES ('43', '随机会员', '随机会员', '2018-12-07 13:27:58', '1');
INSERT INTO `role` VALUES ('44', '随机会员', '随机会员', '2018-12-07 13:27:59', '1');
INSERT INTO `role` VALUES ('45', '随机会员', '随机会员', '2018-12-07 13:27:59', '1');
INSERT INTO `role` VALUES ('46', '随机会员', '随机会员', '2018-12-07 13:27:59', '1');
INSERT INTO `role` VALUES ('47', '随机会员', '随机会员', '2018-12-07 13:28:00', '1');
INSERT INTO `role` VALUES ('48', '随机会员', '随机会员', '2018-12-07 13:28:00', '1');
INSERT INTO `role` VALUES ('50', '随机会员', '随机会员\n                 ', '2018-12-07 21:50:23', '1');
INSERT INTO `role` VALUES ('51', '他是大哥他', '神恶魔啊啊', '2018-12-07 21:51:27', '1');
INSERT INTO `role` VALUES ('52', '我是大哥大', '修改了我是大哥大神恶魔东西来则\n                 ', '2018-12-07 17:51:58', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `nickname` varchar(50) NOT NULL COMMENT '用户昵称',
  `email` varchar(50) NOT NULL COMMENT '用户邮箱',
  `phoneNum` varchar(20) NOT NULL COMMENT '用户电话',
  `password` varchar(40) NOT NULL COMMENT '用户密码',
  `official` char(1) DEFAULT '0' COMMENT '是否是官方账号',
  `createTime` datetime DEFAULT NULL COMMENT '//创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '跟新时间',
  `status` char(1) DEFAULT '1' COMMENT '状态-0删除，1启用，2停用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'rgba', 'test@163.com', '18780183730', '1234', '0', '2018-12-02 21:42:25', '2018-12-04 17:46:46', '0');
INSERT INTO `user` VALUES ('3', 'tian', 'test@126.com', '18780183730', '1234', '0', '2018-12-04 21:42:30', '2018-12-04 17:46:46', '0');
INSERT INTO `user` VALUES ('4', 'jin', 'test@qq.com', '18780183730', '1234', '0', '2018-12-27 21:42:34', '2018-12-07 11:59:25', '0');
INSERT INTO `user` VALUES ('5', 'shan', 'test@gmail.com', '13111856139', '1234', '1', '2018-11-28 21:42:38', '2018-12-05 19:32:43', '2');
INSERT INTO `user` VALUES ('6', 'shan', 'test@gmail.com', '12', '232', '0', '2018-11-14 22:26:41', null, '1');
INSERT INTO `user` VALUES ('7', 's', 'test@gmail.com', '2324', 'r353', '0', '2018-12-20 22:26:58', '2018-12-07 11:59:25', '0');
INSERT INTO `user` VALUES ('8', 'an', 'test@gmail.com', '1234', '34345', '0', '2018-12-04 22:27:16', '2018-12-04 17:46:46', '0');
INSERT INTO `user` VALUES ('9', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-05 21:29:28', '1');
INSERT INTO `user` VALUES ('10', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 17:46:23', '2');
INSERT INTO `user` VALUES ('11', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-07 11:09:38', '2');
INSERT INTO `user` VALUES ('12', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-05 20:52:19', '0');
INSERT INTO `user` VALUES ('13', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-05 20:52:19', '0');
INSERT INTO `user` VALUES ('15', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('16', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 21:31:09', '1');
INSERT INTO `user` VALUES ('17', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('18', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 21:31:09', '1');
INSERT INTO `user` VALUES ('19', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('20', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('22', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-07 11:05:59', '1');
INSERT INTO `user` VALUES ('23', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('24', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('25', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('27', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('28', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('29', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('30', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 22:52:43', '1');
INSERT INTO `user` VALUES ('31', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('32', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('33', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-04 18:49:00', '2018-12-04 17:46:46', '0');
INSERT INTO `user` VALUES ('34', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('35', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('36', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 21:31:09', '1');
INSERT INTO `user` VALUES ('37', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 21:31:09', '1');
INSERT INTO `user` VALUES ('38', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('39', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 22:52:43', '1');
INSERT INTO `user` VALUES ('40', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 17:46:23', '2');
INSERT INTO `user` VALUES ('41', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 21:31:09', '1');
INSERT INTO `user` VALUES ('42', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 17:46:46', '0');
INSERT INTO `user` VALUES ('43', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 17:46:46', '0');
INSERT INTO `user` VALUES ('44', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 17:46:46', '0');
INSERT INTO `user` VALUES ('45', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 18:15:56', '0');
INSERT INTO `user` VALUES ('46', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 18:15:56', '0');
INSERT INTO `user` VALUES ('47', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 18:16:36', '0');
INSERT INTO `user` VALUES ('48', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 18:16:36', '0');
INSERT INTO `user` VALUES ('50', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 18:18:19', '0');
INSERT INTO `user` VALUES ('52', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 18:19:00', '0');
INSERT INTO `user` VALUES ('53', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 18:20:12', '0');
INSERT INTO `user` VALUES ('54', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 18:35:28', '2');
INSERT INTO `user` VALUES ('55', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 21:31:09', '1');
INSERT INTO `user` VALUES ('56', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('57', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 22:52:43', '1');
INSERT INTO `user` VALUES ('58', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-04 17:46:46', '0');
INSERT INTO `user` VALUES ('61', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', null, '1');
INSERT INTO `user` VALUES ('62', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-12 21:42:22', '2018-12-03 21:31:09', '1');
INSERT INTO `user` VALUES ('63', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:10', null, '1');
INSERT INTO `user` VALUES ('64', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:13', null, '1');
INSERT INTO `user` VALUES ('65', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:13', null, '1');
INSERT INTO `user` VALUES ('66', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:13', null, '1');
INSERT INTO `user` VALUES ('67', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:14', null, '1');
INSERT INTO `user` VALUES ('68', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:14', null, '1');
INSERT INTO `user` VALUES ('69', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:14', null, '1');
INSERT INTO `user` VALUES ('70', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:14', null, '1');
INSERT INTO `user` VALUES ('71', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:15', null, '1');
INSERT INTO `user` VALUES ('72', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:15', null, '1');
INSERT INTO `user` VALUES ('73', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:16', null, '1');
INSERT INTO `user` VALUES ('74', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:16', null, '1');
INSERT INTO `user` VALUES ('75', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:18', null, '1');
INSERT INTO `user` VALUES ('76', 'rgb', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:19', null, '1');
INSERT INTO `user` VALUES ('77', 'rgba', '18780183730@163.com', '18780183730', '1234', '0', '2018-12-05 13:15:29', null, '1');
INSERT INTO `user` VALUES ('78', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 13:15:45', null, '1');
INSERT INTO `user` VALUES ('79', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 13:15:46', null, '1');
INSERT INTO `user` VALUES ('80', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 13:15:46', null, '1');
INSERT INTO `user` VALUES ('81', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 13:15:46', null, '1');
INSERT INTO `user` VALUES ('82', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 13:15:46', null, '1');
INSERT INTO `user` VALUES ('83', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 13:15:47', null, '1');
INSERT INTO `user` VALUES ('84', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 13:15:48', null, '1');
INSERT INTO `user` VALUES ('85', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:08', null, '1');
INSERT INTO `user` VALUES ('86', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:10', null, '1');
INSERT INTO `user` VALUES ('87', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:10', null, '1');
INSERT INTO `user` VALUES ('88', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:10', null, '1');
INSERT INTO `user` VALUES ('89', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:11', null, '1');
INSERT INTO `user` VALUES ('90', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:11', null, '1');
INSERT INTO `user` VALUES ('91', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:11', null, '1');
INSERT INTO `user` VALUES ('92', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:11', null, '1');
INSERT INTO `user` VALUES ('93', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:12', null, '1');
INSERT INTO `user` VALUES ('94', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:12', null, '1');
INSERT INTO `user` VALUES ('95', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:12', null, '1');
INSERT INTO `user` VALUES ('96', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:12', null, '1');
INSERT INTO `user` VALUES ('97', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:13', null, '1');
INSERT INTO `user` VALUES ('98', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:13', null, '1');
INSERT INTO `user` VALUES ('99', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:13', null, '1');
INSERT INTO `user` VALUES ('100', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:13', null, '1');
INSERT INTO `user` VALUES ('101', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:14', null, '1');
INSERT INTO `user` VALUES ('102', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:14', null, '1');
INSERT INTO `user` VALUES ('103', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:14', null, '1');
INSERT INTO `user` VALUES ('104', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:15', null, '1');
INSERT INTO `user` VALUES ('105', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:15', null, '1');
INSERT INTO `user` VALUES ('106', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:15', null, '1');
INSERT INTO `user` VALUES ('107', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:16', null, '1');
INSERT INTO `user` VALUES ('108', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:16', null, '1');
INSERT INTO `user` VALUES ('109', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:16', null, '1');
INSERT INTO `user` VALUES ('110', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:16', null, '1');
INSERT INTO `user` VALUES ('111', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:17', '2018-12-05 19:53:12', '0');
INSERT INTO `user` VALUES ('112', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:17', null, '1');
INSERT INTO `user` VALUES ('113', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:17', null, '1');
INSERT INTO `user` VALUES ('114', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:17', null, '1');
INSERT INTO `user` VALUES ('115', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:18', null, '1');
INSERT INTO `user` VALUES ('116', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:18', null, '1');
INSERT INTO `user` VALUES ('117', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:18', null, '1');
INSERT INTO `user` VALUES ('118', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:19', null, '1');
INSERT INTO `user` VALUES ('119', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:19', null, '1');
INSERT INTO `user` VALUES ('120', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:19', null, '1');
INSERT INTO `user` VALUES ('121', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:20', null, '1');
INSERT INTO `user` VALUES ('122', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:20', null, '1');
INSERT INTO `user` VALUES ('123', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:20', null, '1');
INSERT INTO `user` VALUES ('124', 'rgba', '18780183730@163.com', '1311856136', '1234', '0', '2018-12-05 18:24:20', null, '1');
INSERT INTO `user` VALUES ('125', '123', '34234@163.com', '12345', '123456', null, '2018-12-07 23:38:30', null, '1');
INSERT INTO `user` VALUES ('126', 'fgtdsf', '34234@163.com', '11324', '123456', null, '2019-01-03 23:38:34', '2018-12-09 21:47:41', '1');
INSERT INTO `user` VALUES ('127', 'fgtdsf', '34234@163.com', '11324', '123456', null, '2018-12-13 23:38:38', '2018-12-07 23:57:39', '1');
INSERT INTO `user` VALUES ('128', 'fgtdsf', '34234@163.com', '11324', '123456', null, '2018-12-07 23:46:37', null, '1');
INSERT INTO `user` VALUES ('129', 'fgtdsf', 'sdfd34@163.com', '11324123', '123456', null, '2018-12-07 23:46:40', null, '2');
INSERT INTO `user` VALUES ('130', 'fsdfs', '34fd234@163.com', '123232', '123456', '0', '2018-12-07 23:46:42', null, '1');
INSERT INTO `user` VALUES ('132', 'ssfasfs', 'fasfasef@198.com', '12232424', '123456', '0', '2018-12-07 23:51:55', null, '2');
INSERT INTO `user` VALUES ('133', 'sdfaef', 'ffasf@232.com', '121313', '123456', '0', '2018-12-07 23:57:20', null, '1');
INSERT INTO `user` VALUES ('134', 'erwer', 'sfsfas@163.com', '12132323', '123456', '0', '2018-12-10 14:58:28', null, '1');
INSERT INTO `user` VALUES ('135', ' ', 'sfsfas@163.com', '12132323', '123456', '0', '2018-12-10 14:58:38', null, '1');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `introduce` varchar(200) DEFAULT NULL COMMENT '个人介绍',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `lastTime` datetime DEFAULT NULL COMMENT '上次登录时间',
  `loginCount` int(11) DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'tian', 'fsfsdf', '2018-12-04 22:05:33', '男', '2018-12-05 22:05:55', '2', '2018-12-10 22:06:02', '3');
INSERT INTO `userinfo` VALUES ('2', '山', '送分題他', '2018-12-19 22:08:25', '女', '2018-12-11 22:08:31', '9', '2018-11-27 22:37:02', '4');

-- ----------------------------
-- Table structure for zipkin_annotations
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_annotations`;
CREATE TABLE `zipkin_annotations` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int(11) NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint(20) DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int(11) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint(6) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_annotations
-- ----------------------------

-- ----------------------------
-- Table structure for zipkin_dependencies
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_dependencies`;
CREATE TABLE `zipkin_dependencies` (
  `day` date NOT NULL,
  `parent` varchar(255) NOT NULL,
  `child` varchar(255) NOT NULL,
  `call_count` bigint(20) DEFAULT NULL,
  `error_count` bigint(20) DEFAULT NULL,
  UNIQUE KEY `day` (`day`,`parent`,`child`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_dependencies
-- ----------------------------

-- ----------------------------
-- Table structure for zipkin_spans
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_spans`;
CREATE TABLE `zipkin_spans` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `debug` bit(1) DEFAULT NULL,
  `start_ts` bigint(20) DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint(20) DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts` (`start_ts`) COMMENT 'for getTraces ordering and range'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_spans
-- ----------------------------
