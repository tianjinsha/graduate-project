/*
Navicat MySQL Data Transfer

Source Server         : windows10
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : fitness

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-18 10:33:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for age_stage
-- ----------------------------
DROP TABLE IF EXISTS `age_stage`;
CREATE TABLE `age_stage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '阶段id',
  `stage` varchar(10) DEFAULT NULL COMMENT '年龄阶段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='年龄阶段';

-- ----------------------------
-- Records of age_stage
-- ----------------------------

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id（编号）',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `useCount` int(11) DEFAULT '0' COMMENT '有效次数',
  `useTime` smallint(6) DEFAULT NULL COMMENT '有效天数',
  `money` varchar(255) DEFAULT NULL COMMENT '价格',
  `discount` decimal(10,0) DEFAULT NULL COMMENT '折扣',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='会员卡类型';

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '年卡', '0', '365', '800', '1', '2018-12-17');
INSERT INTO `card` VALUES ('2', '半年卡', '0', '180', '570', '1', '2018-12-20');
INSERT INTO `card` VALUES ('3', '季卡', '0', '90', '568', '1', '2018-12-17');
INSERT INTO `card` VALUES ('4', '月卡', '0', '30', '76', '1', '2018-12-17');
INSERT INTO `card` VALUES ('5', '周卡', '0', '7', '6887', '1', '2018-12-17');
INSERT INTO `card` VALUES ('6', '日卡', '0', '1', '678', '1', '2018-12-17');
INSERT INTO `card` VALUES ('7', '次卡', '1', '0', '35', '1', '2018-12-17');

-- ----------------------------
-- Table structure for card_history
-- ----------------------------
DROP TABLE IF EXISTS `card_history`;
CREATE TABLE `card_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `memberId` int(11) DEFAULT NULL COMMENT '会员id',
  `cardNumber` int(11) DEFAULT NULL COMMENT '卡号',
  `disableTime` datetime DEFAULT NULL COMMENT '失效时间',
  `cardId` int(11) DEFAULT NULL COMMENT '卡片种类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT=' 办卡记录';

-- ----------------------------
-- Records of card_history
-- ----------------------------
INSERT INTO `card_history` VALUES ('1', '2018-12-05 10:51:06', '1', '343324', '2018-12-29 10:51:18', '1');
INSERT INTO `card_history` VALUES ('2', '2018-12-17 10:57:33', '2', '3556', '2018-12-17 10:57:42', '2');
INSERT INTO `card_history` VALUES ('3', '2018-12-17 10:57:57', '3', '3546', '2018-12-28 10:58:04', '3');
INSERT INTO `card_history` VALUES ('4', '2018-12-18 10:32:16', '1', '212', '2018-11-25 00:00:00', '1');
INSERT INTO `card_history` VALUES ('5', '2018-12-18 10:32:51', '232', '323', '2018-12-02 00:00:00', '2');

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '私教id',
  `name` varchar(255) DEFAULT NULL COMMENT '私教名称',
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `thumb` varchar(255) DEFAULT NULL COMMENT '私教 头像',
  `description` varchar(255) DEFAULT NULL COMMENT '个人介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='私教列表';

-- ----------------------------
-- Records of coach
-- ----------------------------

-- ----------------------------
-- Table structure for coach_card
-- ----------------------------
DROP TABLE IF EXISTS `coach_card`;
CREATE TABLE `coach_card` (
  `id` int(11) NOT NULL COMMENT '私教打卡id',
  `coachId` int(11) DEFAULT NULL COMMENT '私教id',
  `createTime` datetime DEFAULT NULL COMMENT '上班时间',
  `endTime` datetime DEFAULT NULL COMMENT '下班时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='私教打卡';

-- ----------------------------
-- Records of coach_card
-- ----------------------------

-- ----------------------------
-- Table structure for coach_student
-- ----------------------------
DROP TABLE IF EXISTS `coach_student`;
CREATE TABLE `coach_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教练学员',
  `coachId` int(11) DEFAULT NULL COMMENT '私教id',
  `memberId` int(11) DEFAULT NULL COMMENT '会员id',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `deadline` date DEFAULT NULL COMMENT '截至时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教练学员';

-- ----------------------------
-- Records of coach_student
-- ----------------------------

-- ----------------------------
-- Table structure for consumer_history
-- ----------------------------
DROP TABLE IF EXISTS `consumer_history`;
CREATE TABLE `consumer_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消费id',
  `memberId` int(11) DEFAULT NULL COMMENT '会员id',
  `coachId` int(11) DEFAULT NULL COMMENT '私教id',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `money` decimal(5,2) DEFAULT NULL COMMENT '消费金额',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消费记录';

-- ----------------------------
-- Records of consumer_history
-- ----------------------------

-- ----------------------------
-- Table structure for discount
-- ----------------------------
DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cardId` int(11) DEFAULT NULL COMMENT '卡片类型',
  `discount` decimal(4,1) DEFAULT NULL COMMENT '折扣率',
  `fromTime` datetime DEFAULT NULL COMMENT '开始时间',
  `toTime` datetime DEFAULT NULL COMMENT '到期时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员卡打折';

-- ----------------------------
-- Records of discount
-- ----------------------------

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `number` varchar(11) DEFAULT NULL COMMENT '编号',
  `thumb` varchar(255) DEFAULT NULL COMMENT '图片',
  `typeId` smallint(6) DEFAULT NULL COMMENT '器材名称ID',
  `status` char(1) DEFAULT '1' COMMENT '状态，1-默认良好，0-损坏，2-正在维修',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='器材列表';

-- ----------------------------
-- Records of equipment
-- ----------------------------

-- ----------------------------
-- Table structure for equipment_type
-- ----------------------------
DROP TABLE IF EXISTS `equipment_type`;
CREATE TABLE `equipment_type` (
  `id` smallint(11) NOT NULL AUTO_INCREMENT COMMENT '器材分类ID',
  `equipmentName` varchar(255) DEFAULT NULL COMMENT '器材名称',
  `type` varchar(255) DEFAULT NULL COMMENT '器材种类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='器材名称';

-- ----------------------------
-- Records of equipment_type
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `lastTime` datetime DEFAULT NULL COMMENT '上一次登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'admin', '$2a$10$/LiE1AjvOl6jWAhLBVOHeekVq.Y5Q5RhxDywnxCY8kMhk8mfIowJ.', '2018-11-25 11:11:37');
INSERT INTO `manager` VALUES ('2', 'root', '$2a$10$HPUhfdgJgTnHCxFlrvmhdeFGdigeUMInbvhJxA51Am8I9BBzOVfgm', '2018-11-25 11:12:01');
INSERT INTO `manager` VALUES ('3', 'mybatis', '$2a$10$xa5gacTPzaByE33LH8WT4OoLKJ.GnHCuhOncLIPAUnyXrWXJLPqS6', '2018-11-25 11:17:12');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `thumb` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` varchar(255) DEFAULT NULL COMMENT '年龄',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` char(1) DEFAULT '1' COMMENT '状态（0-失效，1-在线）',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `hot` float(3,1) DEFAULT '0.0' COMMENT '活跃度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COMMENT='会员';

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '彭于晏', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('2', '胡歌', null, '男', '35', '2018-12-26 12:51:18', '1', '2232323', '3.0');
INSERT INTO `member` VALUES ('3', '刘亦菲', null, '女', '36', '2018-12-16 12:51:21', '1', '3232323', '2.0');
INSERT INTO `member` VALUES ('4', '高圆圆', null, '女', '29', '2018-12-16 12:51:24', '1', '233232323', '4.0');
INSERT INTO `member` VALUES ('5', '小琴', null, '女', '23', '2018-12-25 12:52:19', '1', '334234333', '0.0');
INSERT INTO `member` VALUES ('6', '彭于晏', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('7', '彭于晏', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('8', '彭于晏', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('9', '王五', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('10', '王五', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('11', '王五', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('12', '王五', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('13', '王五', '', '男', '34', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('14', '李艳', '', '女', '23', '2018-12-05 12:50:35', '1', '1213132344', '3.0');
INSERT INTO `member` VALUES ('15', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('16', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('17', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('18', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('19', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('20', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('21', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('22', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('23', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('24', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('25', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('26', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('27', '李艳', '', '女', '24', '2018-12-05 12:50:35', '1', '1213132344', '2.0');
INSERT INTO `member` VALUES ('28', '1234', null, null, null, null, '1', null, '0.0');
INSERT INTO `member` VALUES ('29', 'asd', null, '1', '18', null, '1', '131', '0.0');
INSERT INTO `member` VALUES ('30', 'asd23', null, '1', '18', null, '1', '1314343', '0.0');
INSERT INTO `member` VALUES ('31', 'afds', null, '2', '19', null, '1', '224', '0.0');
INSERT INTO `member` VALUES ('32', 'adf', null, '1', '18', null, '1', null, '0.0');
INSERT INTO `member` VALUES ('33', 'dfd', null, '1', '18', null, '1', null, '0.0');
INSERT INTO `member` VALUES ('34', 'rewr3we', null, '1', '18', null, '1', null, '0.0');
INSERT INTO `member` VALUES ('35', 'a', null, '1', '18', null, '1', '1', '0.0');
INSERT INTO `member` VALUES ('36', null, null, '1', '18', null, '1', null, '0.0');
INSERT INTO `member` VALUES ('37', 'd ', null, '1', '18', null, '1', null, '0.0');

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '预留手机号',
  `createTime` varchar(255) DEFAULT NULL COMMENT '来访时间',
  `intention` smallint(6) DEFAULT NULL COMMENT '意向',
  `sex` varchar(255) DEFAULT NULL COMMENT '年龄',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `age` tinyint(3) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='游客';

-- ----------------------------
-- Records of visitor
-- ----------------------------
