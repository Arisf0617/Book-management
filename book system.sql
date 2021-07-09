/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : book system

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 09/07/2021 23:55:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_information
-- ----------------------------
DROP TABLE IF EXISTS `book_information`;
CREATE TABLE `book_information`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `writer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `press` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `num` int(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_information
-- ----------------------------
INSERT INTO `book_information` VALUES (1, '高等数学', '王五', '高等教育出版社', 98);

-- ----------------------------
-- Table structure for borrowing_information
-- ----------------------------
DROP TABLE IF EXISTS `borrowing_information`;
CREATE TABLE `borrowing_information`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `writer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `press` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `borrower` int(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowing_information
-- ----------------------------
INSERT INTO `borrowing_information` VALUES (1, '高等数学', '王五', '高等教育出版社', '2021-06-11', 20193247);
INSERT INTO `borrowing_information` VALUES (1, '高等数学', '王五', '高等教育出版社', '2021-10-02', 20193247);

-- ----------------------------
-- Table structure for user_information
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information`  (
  `uid` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES (20193247, '李四', '男', '交通', '20193247', '读者');
INSERT INTO `user_information` VALUES (20193288, '张三', '男', '信息', '20193288', '管理员');

SET FOREIGN_KEY_CHECKS = 1;
