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
INSERT INTO `sys_info` VALUES ('今天天气真好!', '1', '1');
INSERT INTO `sys_info` VALUES ('你好!马谁', '2', null);
INSERT INTO `sys_info` VALUES ('乒乒乓乓乒乒乓乓批批批批批批批', '4', '92');
INSERT INTO `sys_info` VALUES ('你好!李符', '5', '1');
INSERT INTO `sys_info` VALUES ('你好!毛到', '6', '1');
INSERT INTO `sys_info` VALUES ('你好!张啊', '9', '1');
INSERT INTO `sys_info` VALUES ('你好!苏哈', '10', '1');
INSERT INTO `sys_info` VALUES ('你好!李射', '11', '1');
INSERT INTO `sys_info` VALUES ('你好!关使', '12', '1');
INSERT INTO `sys_info` VALUES ('你好!冯啊', '13', '1');
INSERT INTO `sys_info` VALUES ('你好!钱法', '14', '1');
INSERT INTO `sys_info` VALUES ('你好!令愿', '15', '1');
INSERT INTO `sys_info` VALUES ('你好!陈喊', '16', '1');
INSERT INTO `sys_info` VALUES ('你好!苏黄', '17', '1');
INSERT INTO `sys_info` VALUES ('你好!刘嘎', '18', '1');
INSERT INTO `sys_info` VALUES ('你好!李多', '19', '1');
INSERT INTO `sys_info` VALUES ('你好!康的', '21', '1');
INSERT INTO `sys_info` VALUES ('你好!孙蛋', '22', '1');
INSERT INTO `sys_info` VALUES ('你好!杜谎', '23', '1');
INSERT INTO `sys_info` VALUES ('你好!屈用', '24', '1');
INSERT INTO `sys_info` VALUES ('你好!钱尕', '25', '1');
INSERT INTO `sys_info` VALUES ('你好!关始', '26', '1');
INSERT INTO `sys_info` VALUES ('你好!吕台', '27', '1');
INSERT INTO `sys_info` VALUES ('你好!朱公', '28', '1');
INSERT INTO `sys_info` VALUES ('你好!汤万', '29', '1');
INSERT INTO `sys_info` VALUES ('你好!黄的', '30', '1');
INSERT INTO `sys_info` VALUES ('你好!季阿', '31', '1');
INSERT INTO `sys_info` VALUES ('你好!林受', '32', '1');
INSERT INTO `sys_info` VALUES ('你好!韩湾', '33', '1');
INSERT INTO `sys_info` VALUES ('你好!汤使', '34', '1');
INSERT INTO `sys_info` VALUES ('你好!王干', '35', '1');
INSERT INTO `sys_info` VALUES ('你好!杜合', '36', '1');
INSERT INTO `sys_info` VALUES ('你好!黄是', '37', '1');
INSERT INTO `sys_info` VALUES ('你好!公子扶苏海', '38', '1');
INSERT INTO `sys_info` VALUES ('你好!关精', '39', '1');
INSERT INTO `sys_info` VALUES ('你好!公子扶苏和', '40', '1');
INSERT INTO `sys_info` VALUES ('你好!关大', '41', '1');
INSERT INTO `sys_info` VALUES ('你好!黄很', '42', '1');
INSERT INTO `sys_info` VALUES ('你好!余伽', '43', '1');
INSERT INTO `sys_info` VALUES ('你好!林热', '44', '1');
INSERT INTO `sys_info` VALUES ('你好!武干', '45', '1');
INSERT INTO `sys_info` VALUES ('你好!黄生', '46', '1');
INSERT INTO `sys_info` VALUES ('你好!冯说', '47', '1');
INSERT INTO `sys_info` VALUES ('你好!冯所', '48', '1');
INSERT INTO `sys_info` VALUES ('你好!司马还', '49', '1');
INSERT INTO `sys_info` VALUES ('你好!冯伽', '50', '1');
INSERT INTO `sys_info` VALUES ('你好!屈嘎', '51', '1');
INSERT INTO `sys_info` VALUES ('你好!曹是', '52', '1');
INSERT INTO `sys_info` VALUES ('你好!李黄', '53', '1');
INSERT INTO `sys_info` VALUES ('你好!令嘎', '54', '1');
INSERT INTO `sys_info` VALUES ('你好!周嘎', '55', '1');
INSERT INTO `sys_info` VALUES ('你好!啊的', '56', '1');
INSERT INTO `sys_info` VALUES ('你好!张射', '57', '1');
INSERT INTO `sys_info` VALUES ('你好!武公', '58', '1');
INSERT INTO `sys_info` VALUES ('你好!朱神', '59', '1');
INSERT INTO `sys_info` VALUES ('你好!朱到', '60', '1');
INSERT INTO `sys_info` VALUES ('你好!余商', '61', '1');
INSERT INTO `sys_info` VALUES ('你好!陈符', '62', '1');
INSERT INTO `sys_info` VALUES ('你好!朱神', '63', '1');
INSERT INTO `sys_info` VALUES ('你好!刘鸡', '64', '1');
INSERT INTO `sys_info` VALUES ('你好!林加', '65', '1');
INSERT INTO `sys_info` VALUES ('你好!苏法', '66', '1');
INSERT INTO `sys_info` VALUES ('你好!刘哈', '67', '1');
INSERT INTO `sys_info` VALUES ('你好!林谎', '68', '1');
INSERT INTO `sys_info` VALUES ('你好!周所', '69', '1');
INSERT INTO `sys_info` VALUES ('你好!康阿', '70', '1');
INSERT INTO `sys_info` VALUES ('你好!令合', '71', '1');
INSERT INTO `sys_info` VALUES ('你好!朱谎', '72', '1');
INSERT INTO `sys_info` VALUES ('你好!王是', '73', '1');
INSERT INTO `sys_info` VALUES ('你好!康公', '74', '1');
INSERT INTO `sys_info` VALUES ('你好!毛啊', '75', '1');
INSERT INTO `sys_info` VALUES ('你好!令体', '76', '1');
INSERT INTO `sys_info` VALUES ('你好!公子陵嘎', '77', '1');
INSERT INTO `sys_info` VALUES ('你好!林违', '78', '1');
INSERT INTO `sys_info` VALUES ('你好!苏喊', '79', '1');
INSERT INTO `sys_info` VALUES ('你好!李风', '80', '1');
INSERT INTO `sys_info` VALUES ('你好!朱人', '81', '1');
INSERT INTO `sys_info` VALUES ('你好!令公', '82', '1');
INSERT INTO `sys_info` VALUES ('你好!李我', '83', '1');
INSERT INTO `sys_info` VALUES ('你好!马俄', '84', '1');
INSERT INTO `sys_info` VALUES ('你好!苏纠', '85', '1');
INSERT INTO `sys_info` VALUES ('你好!孙发', '86', '1');
INSERT INTO `sys_info` VALUES ('你好!韩哈', '87', '1');
INSERT INTO `sys_info` VALUES ('你好!余方', '88', '1');
INSERT INTO `sys_info` VALUES ('你好!龙关', '89', '1');
INSERT INTO `sys_info` VALUES ('你好!康哈', '90', '1');
INSERT INTO `sys_info` VALUES ('你好!韩圆', '91', '1');
INSERT INTO `sys_info` VALUES ('你好!余汗', '92', '1');
INSERT INTO `sys_info` VALUES ('你好!毛格', '93', '1');
INSERT INTO `sys_info` VALUES ('你好!钱也', '94', '1');
INSERT INTO `sys_info` VALUES ('你好!冯关', '95', '1');
INSERT INTO `sys_info` VALUES ('你好!屈圆', '96', '1');
INSERT INTO `sys_info` VALUES ('你好!吕考', '97', '1');
INSERT INTO `sys_info` VALUES ('你好!刘与', '98', '1');
INSERT INTO `sys_info` VALUES ('你好!公子扶苏歧', '99', '1');
INSERT INTO `sys_info` VALUES ('你好!公子扶苏获', '100', '1');
INSERT INTO `sys_info` VALUES ('你好!司马多', '101', '1');
INSERT INTO `sys_info` VALUES ('你好!马加', '102', '1');
INSERT INTO `sys_info` VALUES ('你好!龙一', '103', '1');
INSERT INTO `sys_info` VALUES ('你好!黄的', '104', '1');
INSERT INTO `sys_info` VALUES ('心情不好啊!', '105', '102');
INSERT INTO `sys_info` VALUES ('啦啦啦', '106', '92');

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
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `available` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', '1');
INSERT INTO `sys_role` VALUES ('2', 'student', '一般用户', '1');
INSERT INTO `sys_role` VALUES ('3', 'teacher', '普通用户', '1');
INSERT INTO `sys_role` VALUES ('4', 'linghai', '令海', '1');
INSERT INTO `sys_role` VALUES ('5', 'yuga', '余嘎', '1');
INSERT INTO `sys_role` VALUES ('6', 'jidao', '季到', '1');
INSERT INTO `sys_role` VALUES ('7', 'qiange', '钱哥', '1');
INSERT INTO `sys_role` VALUES ('8', 'jiaha', '贾哈', '1');
INSERT INTO `sys_role` VALUES ('9', 'zhuyu', '朱与', '1');
INSERT INTO `sys_role` VALUES ('10', 'zhangshe', '章射', '1');
INSERT INTO `sys_role` VALUES ('11', 'wangwan', '王万', '1');
INSERT INTO `sys_role` VALUES ('12', 'hanhai', '韩海', '1');
INSERT INTO `sys_role` VALUES ('13', 'wujia', '武加', '1');
INSERT INTO `sys_role` VALUES ('14', 'sunti', '孙体', '1');
INSERT INTO `sys_role` VALUES ('15', 'gongzifusuhen', '公子扶苏很', '1');
INSERT INTO `sys_role` VALUES ('16', 'dengsha', '邓杀', '1');
INSERT INTO `sys_role` VALUES ('17', 'jiashi', '贾实', '1');
INSERT INTO `sys_role` VALUES ('18', 'zhuduo', '朱多', '1');
INSERT INTO `sys_role` VALUES ('19', 'zhangjia', '张家', '1');
INSERT INTO `sys_role` VALUES ('20', 'jijia', '季家', '1');
INSERT INTO `sys_role` VALUES ('21', 'gongzilingshi', '公子陵始', '1');
INSERT INTO `sys_role` VALUES ('22', 'maoa', '毛啊', '1');
INSERT INTO `sys_role` VALUES ('23', 'guanga', '关尕', '1');
INSERT INTO `sys_role` VALUES ('24', 'zhangwo', '张我', '1');
INSERT INTO `sys_role` VALUES ('25', 'guanfu', '关富', '1');
INSERT INTO `sys_role` VALUES ('26', 'mafa', '马发', '1');
INSERT INTO `sys_role` VALUES ('27', 'dengkai', '邓开', '1');
INSERT INTO `sys_role` VALUES ('28', 'wugui', '武规', '1');
INSERT INTO `sys_role` VALUES ('29', 'longha', '龙哈', '1');
INSERT INTO `sys_role` VALUES ('30', 'guanshi', '关使', '1');
INSERT INTO `sys_role` VALUES ('31', 'suhuo', '苏获', '1');
INSERT INTO `sys_role` VALUES ('32', 'yuwei', '余违', '1');
INSERT INTO `sys_role` VALUES ('33', 'duhen', '杜很', '1');
INSERT INTO `sys_role` VALUES ('34', 'caoe', '曹俄', '1');
INSERT INTO `sys_role` VALUES ('35', 'yushi', '余市', '1');
INSERT INTO `sys_role` VALUES ('36', 'zhoudang', '周当', '1');
INSERT INTO `sys_role` VALUES ('37', 'sungao', '孙高', '1');
INSERT INTO `sys_role` VALUES ('38', 'tangfen', '汤纷', '1');
INSERT INTO `sys_role` VALUES ('39', 'gongzilingde', '公子陵的', '1');
INSERT INTO `sys_role` VALUES ('40', 'zhutu', '朱途', '1');
INSERT INTO `sys_role` VALUES ('41', 'suga', '苏嘎', '1');
INSERT INTO `sys_role` VALUES ('42', 'longjia', '龙加', '1');
INSERT INTO `sys_role` VALUES ('43', 'lintu', '林途', '1');
INSERT INTO `sys_role` VALUES ('44', 'jiashei', '贾谁', '1');
INSERT INTO `sys_role` VALUES ('45', 'fengde', '冯得', '1');
INSERT INTO `sys_role` VALUES ('46', 'linshang', '林上', '1');
INSERT INTO `sys_role` VALUES ('47', 'qianguan', '钱关', '1');
INSERT INTO `sys_role` VALUES ('48', 'huangjia', '黄家', '1');
INSERT INTO `sys_role` VALUES ('49', 'liujing', '刘精', '1');
INSERT INTO `sys_role` VALUES ('50', 'lu:gong', '吕公', '1');
INSERT INTO `sys_role` VALUES ('51', 'dengga', '邓嘎', '1');
INSERT INTO `sys_role` VALUES ('52', 'simaa', '司马阿', '1');
INSERT INTO `sys_role` VALUES ('53', 'simaguang', '司马广', '1');
INSERT INTO `sys_role` VALUES ('54', 'liuga', '刘嘎', '1');
INSERT INTO `sys_role` VALUES ('55', 'lu:fa', '吕法', '1');
INSERT INTO `sys_role` VALUES ('56', 'liuga', '刘嘎', '1');
INSERT INTO `sys_role` VALUES ('57', 'aga', '啊嘎', '1');
INSERT INTO `sys_role` VALUES ('58', 'gongzifusuhuo', '公子扶苏获', '1');
INSERT INTO `sys_role` VALUES ('59', 'tangjia', '汤加', '1');
INSERT INTO `sys_role` VALUES ('60', 'tangye', '汤也', '1');
INSERT INTO `sys_role` VALUES ('61', 'quwa', '屈瓦', '1');
INSERT INTO `sys_role` VALUES ('62', 'maojin', '毛今', '1');
INSERT INTO `sys_role` VALUES ('63', 'gongzilingyi', '公子陵一', '1');
INSERT INTO `sys_role` VALUES ('64', 'qianshen', '钱身', '1');
INSERT INTO `sys_role` VALUES ('65', 'lidi', '李地', '1');
INSERT INTO `sys_role` VALUES ('66', 'mafen', '马纷', '1');
INSERT INTO `sys_role` VALUES ('67', 'tangga', '汤嘎', '1');
INSERT INTO `sys_role` VALUES ('68', 'afa', '啊法', '1');
INSERT INTO `sys_role` VALUES ('69', 'jiade', '贾得', '1');
INSERT INTO `sys_role` VALUES ('70', 'gongzifusudong', '公子扶苏动', '1');
INSERT INTO `sys_role` VALUES ('71', 'magen', '马根', '1');
INSERT INTO `sys_role` VALUES ('72', 'qudan', '屈蛋', '1');
INSERT INTO `sys_role` VALUES ('73', 'lingsha', '令杀', '1');
INSERT INTO `sys_role` VALUES ('74', 'hanga', '韩嘎', '1');
INSERT INTO `sys_role` VALUES ('75', 'tangqi', '汤歧', '1');
INSERT INTO `sys_role` VALUES ('76', 'guanyu', '关与', '1');
INSERT INTO `sys_role` VALUES ('77', 'liude', '刘的', '1');
INSERT INTO `sys_role` VALUES ('78', 'jiyu', '季与', '1');
INSERT INTO `sys_role` VALUES ('79', 'hanfeng', '韩锋', '1');
INSERT INTO `sys_role` VALUES ('80', 'adao', '啊到', '1');
INSERT INTO `sys_role` VALUES ('81', 'sunde', '孙的', '1');
INSERT INTO `sys_role` VALUES ('82', 'wangfa', '王发', '1');
INSERT INTO `sys_role` VALUES ('83', 'lidao', '李到', '1');
INSERT INTO `sys_role` VALUES ('84', 'zhangdao', '章到', '1');
INSERT INTO `sys_role` VALUES ('85', 'jide', '季得', '1');
INSERT INTO `sys_role` VALUES ('86', 'line', '林额', '1');
INSERT INTO `sys_role` VALUES ('87', 'maoshi', '毛始', '1');
INSERT INTO `sys_role` VALUES ('88', 'afa', '啊发', '1');
INSERT INTO `sys_role` VALUES ('89', 'tanga', '汤啊', '1');
INSERT INTO `sys_role` VALUES ('90', 'zhuti', '朱体', '1');
INSERT INTO `sys_role` VALUES ('91', 'linhen', '林很', '1');
INSERT INTO `sys_role` VALUES ('92', 'wangshe', '王设', '1');
INSERT INTO `sys_role` VALUES ('93', 'huangde', '黄的', '1');
INSERT INTO `sys_role` VALUES ('94', 'huanghua', '黄华', '1');
INSERT INTO `sys_role` VALUES ('95', 'qiande', '钱得', '1');
INSERT INTO `sys_role` VALUES ('96', 'guanfeng', '关丰', '1');
INSERT INTO `sys_role` VALUES ('97', 'wuha', '武哈', '1');
INSERT INTO `sys_role` VALUES ('98', 'gongzifusuru', '公子扶苏入', '1');
INSERT INTO `sys_role` VALUES ('99', 'longhai', '龙海', '1');
INSERT INTO `sys_role` VALUES ('100', 'qianhen', '钱很', '1');
INSERT INTO `sys_role` VALUES ('101', 'mawan', '马湾', '1');
INSERT INTO `sys_role` VALUES ('102', 'wanggao', '王高', '1');
INSERT INTO `sys_role` VALUES ('103', 'lu:sheng', '吕生', '1');
INSERT INTO `sys_role` VALUES ('104', 'yuduo', '余多', '1');

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
INSERT INTO `sys_user` VALUES ('太平洋保险公司', 'alice', 'MTIzNDU2OTA3YmM4ZmUtY2ZkMi00NmQ2LTkzMzYtMGY1MTdmZTg1YmNj', '907bc8fe-cfd2-46d6-9336-0f517fe85bcc', '1', '2017-10-10 00:00:00', '1');
INSERT INTO `sys_user` VALUES ('中石化', 'root', 'MTIzNDU2ZDNhZjQzZWItY2RlOS00MWM5MDVn', 'd3af43eb-cde9-41c905g', '0', '2017-10-03 17:11:06', '92');
INSERT INTO `sys_user` VALUES ('中石油', 'blake', 'MTIzNDU2NmIyNzg0MDAtYWFiNi00YTg4LTk0MmMtNmQ3Nzk4NTdhNDMz', '6b278400-aab6-4a88-942c-6d779857a433', '0', '2017-10-06 12:08:09', '102');
