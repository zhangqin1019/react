/*
MySQL Data Transfer
Source Host: localhost
Source Database: angular
Target Host: localhost
Target Database: angular
Date: 2016/10/21 16:13:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(255) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `userPwd` varchar(255) NOT NULL,
  `userAge` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '张三', '123', '17');
INSERT INTO `userinfo` VALUES ('2', '李四', '456', '18');
INSERT INTO `userinfo` VALUES ('3', '王五', '789', '20');
INSERT INTO `userinfo` VALUES ('4', '赵六', '890', '21');
INSERT INTO `userinfo` VALUES ('5', '小赵', '012', '22');
INSERT INTO `userinfo` VALUES ('6', '马武', '345', '23');
INSERT INTO `userinfo` VALUES ('7', '赵丽', '235', '24');
INSERT INTO `userinfo` VALUES ('8', '小马', '123', '18');
INSERT INTO `userinfo` VALUES ('10', '小花', '123', '12');
