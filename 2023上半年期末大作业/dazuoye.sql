/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : dazuoye

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 29/06/2023 22:12:31
*/

create database XXXX default character set=utf8 default collate=utf8_general_ci;

use XXXX;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `number` int NOT NULL,
  `name` varchar(7) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  `newquantity` int NULL DEFAULT NULL,
  `place` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `profit` double(10, 2) NULL DEFAULT NULL,
  `tag` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`tag`) USING BTREE,
  INDEX `number`(`number`) USING BTREE,
  CONSTRAINT `commodity_ibfk_1` FOREIGN KEY (`number`) REFERENCES `profit` (`number`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (1, '矿泉水', 1, 96, 4, '北6', 0.80, 1);
INSERT INTO `commodity` VALUES (1, '矿泉水', 1, 100, NULL, '北5', 0.00, 2);
INSERT INTO `commodity` VALUES (2, '绿茶', 3, 96, 4, '北6', 6.00, 3);
INSERT INTO `commodity` VALUES (2, '绿茶', 3, 100, NULL, '北5', 0.00, 4);
INSERT INTO `commodity` VALUES (3, '辣条', 2, 93, 9, '北6', 7.20, 5);
INSERT INTO `commodity` VALUES (3, '辣条', 2, 100, 3, '北5', 2.40, 6);
INSERT INTO `commodity` VALUES (4, '方便面', 2, 10, 17, '北6', 13.60, 7);

-- ----------------------------
-- Table structure for profit
-- ----------------------------
DROP TABLE IF EXISTS `profit`;
CREATE TABLE `profit`  (
  `number` int NOT NULL,
  `oldprice` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of profit
-- ----------------------------
INSERT INTO `profit` VALUES (1, 0.80);
INSERT INTO `profit` VALUES (2, 1.50);
INSERT INTO `profit` VALUES (3, 1.20);
INSERT INTO `profit` VALUES (4, 1.20);
INSERT INTO `profit` VALUES (5, 2.00);
INSERT INTO `profit` VALUES (6, 2.30);
INSERT INTO `profit` VALUES (7, 2.60);
INSERT INTO `profit` VALUES (8, 1.80);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `priority` int NOT NULL DEFAULT 1,
  `place` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL,
  `tag` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`tag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '88888', 3, NULL, 1);
INSERT INTO `user` VALUES ('解子祥', '123456', 1, '北6', 2);
INSERT INTO `user` VALUES ('xzx', '123456', 2, '北6', 3);
INSERT INTO `user` VALUES ('解', '123', 2, '北5', 5);
INSERT INTO `user` VALUES ('1', '123456', 1, '北5', 6);

SET FOREIGN_KEY_CHECKS = 1;
