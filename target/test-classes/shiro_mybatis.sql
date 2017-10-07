/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : shiro_mybatis

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2017-10-06 19:34:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege` (
  `p_rid` int(11) DEFAULT NULL,
  `r_pid` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `p_rid` (`p_rid`),
  KEY `r_pid` (`r_pid`),
  CONSTRAINT `p_rid` FOREIGN KEY (`p_rid`) REFERENCES `sys_role` (`rid`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `r_pid` FOREIGN KEY (`r_pid`) REFERENCES `sys_privilege` (`pid`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of role_privilege
-- ----------------------------
INSERT INTO `role_privilege` VALUES ('1', '1', '1');
INSERT INTO `role_privilege` VALUES ('1', '2', '4');
INSERT INTO `role_privilege` VALUES ('1', '3', '5');
INSERT INTO `role_privilege` VALUES ('1', '4', '6');
INSERT INTO `role_privilege` VALUES ('1', '5', '7');
INSERT INTO `role_privilege` VALUES ('3', '2', '8');
INSERT INTO `role_privilege` VALUES ('2', '2', '9');
INSERT INTO `role_privilege` VALUES ('3', '5', '10');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `u_rid` int(11) DEFAULT NULL,
  `r_uid` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `u_rid` (`u_rid`),
  KEY `r_uid` (`r_uid`),
  CONSTRAINT `u_rid` FOREIGN KEY (`u_rid`) REFERENCES `sys_role` (`rid`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `r_uid` FOREIGN KEY (`r_uid`) REFERENCES `sys_user` (`uid`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('2', '1', '2');
INSERT INTO `role_user` VALUES ('1', '92', '4');
INSERT INTO `role_user` VALUES ('3', '102', '6');

-- ----------------------------
-- Table structure for sys_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_info`;
CREATE TABLE `sys_info` (
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`uid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sys_info
-- ----------------------------
INSERT INTO `sys_info` VALUES ('�����������!', '1', '1');
INSERT INTO `sys_info` VALUES ('���!��˭', '2', null);
INSERT INTO `sys_info` VALUES ('ƹƹ����ƹƹ������������������', '4', '92');
INSERT INTO `sys_info` VALUES ('���!���', '5', '1');
INSERT INTO `sys_info` VALUES ('���!ë��', '6', '1');
INSERT INTO `sys_info` VALUES ('���!�Ű�', '9', '1');
INSERT INTO `sys_info` VALUES ('���!�չ�', '10', '1');
INSERT INTO `sys_info` VALUES ('���!����', '11', '1');
INSERT INTO `sys_info` VALUES ('���!��ʹ', '12', '1');
INSERT INTO `sys_info` VALUES ('���!�밡', '13', '1');
INSERT INTO `sys_info` VALUES ('���!Ǯ��', '14', '1');
INSERT INTO `sys_info` VALUES ('���!��Ը', '15', '1');
INSERT INTO `sys_info` VALUES ('���!�º�', '16', '1');
INSERT INTO `sys_info` VALUES ('���!�ջ�', '17', '1');
INSERT INTO `sys_info` VALUES ('���!����', '18', '1');
INSERT INTO `sys_info` VALUES ('���!���', '19', '1');
INSERT INTO `sys_info` VALUES ('���!����', '21', '1');
INSERT INTO `sys_info` VALUES ('���!�ﵰ', '22', '1');
INSERT INTO `sys_info` VALUES ('���!�Ż�', '23', '1');
INSERT INTO `sys_info` VALUES ('���!����', '24', '1');
INSERT INTO `sys_info` VALUES ('���!Ǯ��', '25', '1');
INSERT INTO `sys_info` VALUES ('���!��ʼ', '26', '1');
INSERT INTO `sys_info` VALUES ('���!��̨', '27', '1');
INSERT INTO `sys_info` VALUES ('���!�칫', '28', '1');
INSERT INTO `sys_info` VALUES ('���!����', '29', '1');
INSERT INTO `sys_info` VALUES ('���!�Ƶ�', '30', '1');
INSERT INTO `sys_info` VALUES ('���!����', '31', '1');
INSERT INTO `sys_info` VALUES ('���!����', '32', '1');
INSERT INTO `sys_info` VALUES ('���!����', '33', '1');
INSERT INTO `sys_info` VALUES ('���!��ʹ', '34', '1');
INSERT INTO `sys_info` VALUES ('���!����', '35', '1');
INSERT INTO `sys_info` VALUES ('���!�ź�', '36', '1');
INSERT INTO `sys_info` VALUES ('���!����', '37', '1');
INSERT INTO `sys_info` VALUES ('���!���ӷ��պ�', '38', '1');
INSERT INTO `sys_info` VALUES ('���!�ؾ�', '39', '1');
INSERT INTO `sys_info` VALUES ('���!���ӷ��պ�', '40', '1');
INSERT INTO `sys_info` VALUES ('���!�ش�', '41', '1');
INSERT INTO `sys_info` VALUES ('���!�ƺ�', '42', '1');
INSERT INTO `sys_info` VALUES ('���!��٤', '43', '1');
INSERT INTO `sys_info` VALUES ('���!����', '44', '1');
INSERT INTO `sys_info` VALUES ('���!���', '45', '1');
INSERT INTO `sys_info` VALUES ('���!����', '46', '1');
INSERT INTO `sys_info` VALUES ('���!��˵', '47', '1');
INSERT INTO `sys_info` VALUES ('���!����', '48', '1');
INSERT INTO `sys_info` VALUES ('���!˾��', '49', '1');
INSERT INTO `sys_info` VALUES ('���!��٤', '50', '1');
INSERT INTO `sys_info` VALUES ('���!����', '51', '1');
INSERT INTO `sys_info` VALUES ('���!����', '52', '1');
INSERT INTO `sys_info` VALUES ('���!���', '53', '1');
INSERT INTO `sys_info` VALUES ('���!���', '54', '1');
INSERT INTO `sys_info` VALUES ('���!�ܸ�', '55', '1');
INSERT INTO `sys_info` VALUES ('���!����', '56', '1');
INSERT INTO `sys_info` VALUES ('���!����', '57', '1');
INSERT INTO `sys_info` VALUES ('���!�乫', '58', '1');
INSERT INTO `sys_info` VALUES ('���!����', '59', '1');
INSERT INTO `sys_info` VALUES ('���!�쵽', '60', '1');
INSERT INTO `sys_info` VALUES ('���!����', '61', '1');
INSERT INTO `sys_info` VALUES ('���!�·�', '62', '1');
INSERT INTO `sys_info` VALUES ('���!����', '63', '1');
INSERT INTO `sys_info` VALUES ('���!����', '64', '1');
INSERT INTO `sys_info` VALUES ('���!�ּ�', '65', '1');
INSERT INTO `sys_info` VALUES ('���!�շ�', '66', '1');
INSERT INTO `sys_info` VALUES ('���!����', '67', '1');
INSERT INTO `sys_info` VALUES ('���!�ֻ�', '68', '1');
INSERT INTO `sys_info` VALUES ('���!����', '69', '1');
INSERT INTO `sys_info` VALUES ('���!����', '70', '1');
INSERT INTO `sys_info` VALUES ('���!���', '71', '1');
INSERT INTO `sys_info` VALUES ('���!���', '72', '1');
INSERT INTO `sys_info` VALUES ('���!����', '73', '1');
INSERT INTO `sys_info` VALUES ('���!����', '74', '1');
INSERT INTO `sys_info` VALUES ('���!ë��', '75', '1');
INSERT INTO `sys_info` VALUES ('���!����', '76', '1');
INSERT INTO `sys_info` VALUES ('���!�������', '77', '1');
INSERT INTO `sys_info` VALUES ('���!��Υ', '78', '1');
INSERT INTO `sys_info` VALUES ('���!�պ�', '79', '1');
INSERT INTO `sys_info` VALUES ('���!���', '80', '1');
INSERT INTO `sys_info` VALUES ('���!����', '81', '1');
INSERT INTO `sys_info` VALUES ('���!�', '82', '1');
INSERT INTO `sys_info` VALUES ('���!����', '83', '1');
INSERT INTO `sys_info` VALUES ('���!���', '84', '1');
INSERT INTO `sys_info` VALUES ('���!�վ�', '85', '1');
INSERT INTO `sys_info` VALUES ('���!�﷢', '86', '1');
INSERT INTO `sys_info` VALUES ('���!����', '87', '1');
INSERT INTO `sys_info` VALUES ('���!�෽', '88', '1');
INSERT INTO `sys_info` VALUES ('���!����', '89', '1');
INSERT INTO `sys_info` VALUES ('���!����', '90', '1');
INSERT INTO `sys_info` VALUES ('���!��Բ', '91', '1');
INSERT INTO `sys_info` VALUES ('���!�ູ', '92', '1');
INSERT INTO `sys_info` VALUES ('���!ë��', '93', '1');
INSERT INTO `sys_info` VALUES ('���!ǮҲ', '94', '1');
INSERT INTO `sys_info` VALUES ('���!���', '95', '1');
INSERT INTO `sys_info` VALUES ('���!��Բ', '96', '1');
INSERT INTO `sys_info` VALUES ('���!����', '97', '1');
INSERT INTO `sys_info` VALUES ('���!����', '98', '1');
INSERT INTO `sys_info` VALUES ('���!���ӷ�����', '99', '1');
INSERT INTO `sys_info` VALUES ('���!���ӷ��ջ�', '100', '1');
INSERT INTO `sys_info` VALUES ('���!˾���', '101', '1');
INSERT INTO `sys_info` VALUES ('���!���', '102', '1');
INSERT INTO `sys_info` VALUES ('���!��һ', '103', '1');
INSERT INTO `sys_info` VALUES ('���!�Ƶ�', '104', '1');
INSERT INTO `sys_info` VALUES ('���鲻�ð�!', '105', '102');
INSERT INTO `sys_info` VALUES ('������', '106', '92');

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('user:admin', '1');
INSERT INTO `sys_privilege` VALUES ('user:select', '2');
INSERT INTO `sys_privilege` VALUES ('user:update', '3');
INSERT INTO `sys_privilege` VALUES ('user:remove', '4');
INSERT INTO `sys_privilege` VALUES ('user:save', '5');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL COMMENT '��ɫ����',
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `available` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '����Ա', '1');
INSERT INTO `sys_role` VALUES ('2', 'student', 'һ���û�', '1');
INSERT INTO `sys_role` VALUES ('3', 'teacher', '��ͨ�û�', '1');
INSERT INTO `sys_role` VALUES ('4', 'linghai', '�', '1');
INSERT INTO `sys_role` VALUES ('5', 'yuga', '���', '1');
INSERT INTO `sys_role` VALUES ('6', 'jidao', '����', '1');
INSERT INTO `sys_role` VALUES ('7', 'qiange', 'Ǯ��', '1');
INSERT INTO `sys_role` VALUES ('8', 'jiaha', '�ֹ�', '1');
INSERT INTO `sys_role` VALUES ('9', 'zhuyu', '����', '1');
INSERT INTO `sys_role` VALUES ('10', 'zhangshe', '����', '1');
INSERT INTO `sys_role` VALUES ('11', 'wangwan', '����', '1');
INSERT INTO `sys_role` VALUES ('12', 'hanhai', '����', '1');
INSERT INTO `sys_role` VALUES ('13', 'wujia', '���', '1');
INSERT INTO `sys_role` VALUES ('14', 'sunti', '����', '1');
INSERT INTO `sys_role` VALUES ('15', 'gongzifusuhen', '���ӷ��պ�', '1');
INSERT INTO `sys_role` VALUES ('16', 'dengsha', '��ɱ', '1');
INSERT INTO `sys_role` VALUES ('17', 'jiashi', '��ʵ', '1');
INSERT INTO `sys_role` VALUES ('18', 'zhuduo', '���', '1');
INSERT INTO `sys_role` VALUES ('19', 'zhangjia', '�ż�', '1');
INSERT INTO `sys_role` VALUES ('20', 'jijia', '����', '1');
INSERT INTO `sys_role` VALUES ('21', 'gongzilingshi', '������ʼ', '1');
INSERT INTO `sys_role` VALUES ('22', 'maoa', 'ë��', '1');
INSERT INTO `sys_role` VALUES ('23', 'guanga', '����', '1');
INSERT INTO `sys_role` VALUES ('24', 'zhangwo', '����', '1');
INSERT INTO `sys_role` VALUES ('25', 'guanfu', '�ظ�', '1');
INSERT INTO `sys_role` VALUES ('26', 'mafa', '��', '1');
INSERT INTO `sys_role` VALUES ('27', 'dengkai', '�˿�', '1');
INSERT INTO `sys_role` VALUES ('28', 'wugui', '���', '1');
INSERT INTO `sys_role` VALUES ('29', 'longha', '����', '1');
INSERT INTO `sys_role` VALUES ('30', 'guanshi', '��ʹ', '1');
INSERT INTO `sys_role` VALUES ('31', 'suhuo', '�ջ�', '1');
INSERT INTO `sys_role` VALUES ('32', 'yuwei', '��Υ', '1');
INSERT INTO `sys_role` VALUES ('33', 'duhen', '�ź�', '1');
INSERT INTO `sys_role` VALUES ('34', 'caoe', '�ܶ�', '1');
INSERT INTO `sys_role` VALUES ('35', 'yushi', '����', '1');
INSERT INTO `sys_role` VALUES ('36', 'zhoudang', '�ܵ�', '1');
INSERT INTO `sys_role` VALUES ('37', 'sungao', '���', '1');
INSERT INTO `sys_role` VALUES ('38', 'tangfen', '����', '1');
INSERT INTO `sys_role` VALUES ('39', 'gongzilingde', '�������', '1');
INSERT INTO `sys_role` VALUES ('40', 'zhutu', '��;', '1');
INSERT INTO `sys_role` VALUES ('41', 'suga', '�ո�', '1');
INSERT INTO `sys_role` VALUES ('42', 'longjia', '����', '1');
INSERT INTO `sys_role` VALUES ('43', 'lintu', '��;', '1');
INSERT INTO `sys_role` VALUES ('44', 'jiashei', '��˭', '1');
INSERT INTO `sys_role` VALUES ('45', 'fengde', '���', '1');
INSERT INTO `sys_role` VALUES ('46', 'linshang', '����', '1');
INSERT INTO `sys_role` VALUES ('47', 'qianguan', 'Ǯ��', '1');
INSERT INTO `sys_role` VALUES ('48', 'huangjia', '�Ƽ�', '1');
INSERT INTO `sys_role` VALUES ('49', 'liujing', '����', '1');
INSERT INTO `sys_role` VALUES ('50', 'lu:gong', '����', '1');
INSERT INTO `sys_role` VALUES ('51', 'dengga', '�˸�', '1');
INSERT INTO `sys_role` VALUES ('52', 'simaa', '˾��', '1');
INSERT INTO `sys_role` VALUES ('53', 'simaguang', '˾���', '1');
INSERT INTO `sys_role` VALUES ('54', 'liuga', '����', '1');
INSERT INTO `sys_role` VALUES ('55', 'lu:fa', '����', '1');
INSERT INTO `sys_role` VALUES ('56', 'liuga', '����', '1');
INSERT INTO `sys_role` VALUES ('57', 'aga', '����', '1');
INSERT INTO `sys_role` VALUES ('58', 'gongzifusuhuo', '���ӷ��ջ�', '1');
INSERT INTO `sys_role` VALUES ('59', 'tangjia', '����', '1');
INSERT INTO `sys_role` VALUES ('60', 'tangye', '��Ҳ', '1');
INSERT INTO `sys_role` VALUES ('61', 'quwa', '����', '1');
INSERT INTO `sys_role` VALUES ('62', 'maojin', 'ë��', '1');
INSERT INTO `sys_role` VALUES ('63', 'gongzilingyi', '������һ', '1');
INSERT INTO `sys_role` VALUES ('64', 'qianshen', 'Ǯ��', '1');
INSERT INTO `sys_role` VALUES ('65', 'lidi', '���', '1');
INSERT INTO `sys_role` VALUES ('66', 'mafen', '���', '1');
INSERT INTO `sys_role` VALUES ('67', 'tangga', '����', '1');
INSERT INTO `sys_role` VALUES ('68', 'afa', '����', '1');
INSERT INTO `sys_role` VALUES ('69', 'jiade', '�ֵ�', '1');
INSERT INTO `sys_role` VALUES ('70', 'gongzifusudong', '���ӷ��ն�', '1');
INSERT INTO `sys_role` VALUES ('71', 'magen', '���', '1');
INSERT INTO `sys_role` VALUES ('72', 'qudan', '����', '1');
INSERT INTO `sys_role` VALUES ('73', 'lingsha', '��ɱ', '1');
INSERT INTO `sys_role` VALUES ('74', 'hanga', '����', '1');
INSERT INTO `sys_role` VALUES ('75', 'tangqi', '����', '1');
INSERT INTO `sys_role` VALUES ('76', 'guanyu', '����', '1');
INSERT INTO `sys_role` VALUES ('77', 'liude', '����', '1');
INSERT INTO `sys_role` VALUES ('78', 'jiyu', '����', '1');
INSERT INTO `sys_role` VALUES ('79', 'hanfeng', '����', '1');
INSERT INTO `sys_role` VALUES ('80', 'adao', '����', '1');
INSERT INTO `sys_role` VALUES ('81', 'sunde', '���', '1');
INSERT INTO `sys_role` VALUES ('82', 'wangfa', '����', '1');
INSERT INTO `sys_role` VALUES ('83', 'lidao', '�', '1');
INSERT INTO `sys_role` VALUES ('84', 'zhangdao', '�µ�', '1');
INSERT INTO `sys_role` VALUES ('85', 'jide', '����', '1');
INSERT INTO `sys_role` VALUES ('86', 'line', '�ֶ�', '1');
INSERT INTO `sys_role` VALUES ('87', 'maoshi', 'ëʼ', '1');
INSERT INTO `sys_role` VALUES ('88', 'afa', '����', '1');
INSERT INTO `sys_role` VALUES ('89', 'tanga', '����', '1');
INSERT INTO `sys_role` VALUES ('90', 'zhuti', '����', '1');
INSERT INTO `sys_role` VALUES ('91', 'linhen', '�ֺ�', '1');
INSERT INTO `sys_role` VALUES ('92', 'wangshe', '����', '1');
INSERT INTO `sys_role` VALUES ('93', 'huangde', '�Ƶ�', '1');
INSERT INTO `sys_role` VALUES ('94', 'huanghua', '�ƻ�', '1');
INSERT INTO `sys_role` VALUES ('95', 'qiande', 'Ǯ��', '1');
INSERT INTO `sys_role` VALUES ('96', 'guanfeng', '�ط�', '1');
INSERT INTO `sys_role` VALUES ('97', 'wuha', '���', '1');
INSERT INTO `sys_role` VALUES ('98', 'gongzifusuru', '���ӷ�����', '1');
INSERT INTO `sys_role` VALUES ('99', 'longhai', '����', '1');
INSERT INTO `sys_role` VALUES ('100', 'qianhen', 'Ǯ��', '1');
INSERT INTO `sys_role` VALUES ('101', 'mawan', '����', '1');
INSERT INTO `sys_role` VALUES ('102', 'wanggao', '����', '1');
INSERT INTO `sys_role` VALUES ('103', 'lu:sheng', '����', '1');
INSERT INTO `sys_role` VALUES ('104', 'yuduo', '���', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `organizationid` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `username` varchar(255) CHARACTER SET gbk NOT NULL,
  `password` varchar(255) CHARACTER SET gbk NOT NULL,
  `salt` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `lock_User` tinyint(63) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('̫ƽ���չ�˾', 'alice', 'MTIzNDU2OTA3YmM4ZmUtY2ZkMi00NmQ2LTkzMzYtMGY1MTdmZTg1YmNj', '907bc8fe-cfd2-46d6-9336-0f517fe85bcc', '1', '2017-10-10 00:00:00', '1');
INSERT INTO `sys_user` VALUES ('��ʯ��', 'root', 'MTIzNDU2ZDNhZjQzZWItY2RlOS00MWM5MDVn', 'd3af43eb-cde9-41c905g', '0', '2017-10-03 17:11:06', '92');
INSERT INTO `sys_user` VALUES ('��ʯ��', 'blake', 'MTIzNDU2NmIyNzg0MDAtYWFiNi00YTg4LTk0MmMtNmQ3Nzk4NTdhNDMz', '6b278400-aab6-4a88-942c-6d779857a433', '0', '2017-10-06 12:08:09', '102');
