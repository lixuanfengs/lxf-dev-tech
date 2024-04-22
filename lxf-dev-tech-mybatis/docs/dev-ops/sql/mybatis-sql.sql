/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : road-map

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 15/07/2023 09:26:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE database if NOT EXISTS `mybatis-sql` default character set utf8mb4 collate utf8mb4_0900_ai_ci;
use `mybatis-sql`;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `employee_number` varchar(16) NOT NULL DEFAULT '' COMMENT '雇员ID',
  `employee_name` varchar(32) NOT NULL DEFAULT '' COMMENT '雇员姓名',
  `employee_level` varchar(8) NOT NULL DEFAULT '' COMMENT '雇员级别',
  `employee_title` varchar(16) NOT NULL DEFAULT '' COMMENT '雇员岗位Title',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_employee_number` (`employee_number`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` VALUES (1, '10000001', 'sXvfDpsWnJdLsCVk64tJgw==', 'T-3', '中级工程师', '2023-07-14 15:26:26', '2023-07-14 15:26:26');
INSERT INTO `employee` VALUES (2, '10000010', 'sXvfDpsWnJdLsCVk64tJgw==', 'T2', '见习工程师', '2023-07-14 15:34:40', '2023-07-14 15:34:40');
INSERT INTO `employee` VALUES (3, '10000011', 'sXvfDpsWnJdLsCVk64tJgw==', 'T2', '见习工程师', '2023-07-14 15:34:40', '2023-07-14 15:34:40');
INSERT INTO `employee` VALUES (4, '10000012', 'sXvfDpsWnJdLsCVk64tJgw==', 'T2', '见习工程师', '2023-07-14 15:34:40', '2023-07-14 15:34:40');
INSERT INTO `employee` VALUES (5, '10000013', 'sXvfDpsWnJdLsCVk64tJgw==', 'T2', '见习工程师', '2023-07-14 15:34:40', '2023-07-14 15:34:40');
INSERT INTO `employee` VALUES (6, '10000014', 'sXvfDpsWnJdLsCVk64tJgw==', 'T2', '见习工程师', '2023-07-14 15:34:40', '2023-07-14 15:34:40');
INSERT INTO `employee` VALUES (9, '10000002', 'sXvfDpsWnJdLsCVk64tJgw==', 'T2', '见习工程师', '2023-07-15 07:42:52', '2023-07-15 07:42:52');
INSERT INTO `employee` VALUES (22, '10000015', 'hMCgLG6WV3CsNBQ1UD6PEQ==', 'T2', '见习工程师', '2023-07-15 08:02:31', '2023-07-15 08:02:31');
INSERT INTO `employee` VALUES (23, '10000016', 'hMCgLG6WV3CsNBQ1UD6PEQ==', 'T2', '见习工程师', '2023-07-15 08:02:31', '2023-07-15 08:02:31');
INSERT INTO `employee` VALUES (24, '10000017', 'hMCgLG6WV3CsNBQ1UD6PEQ==', 'T2', '见习工程师', '2023-07-15 08:02:31', '2023-07-15 08:02:31');
INSERT INTO `employee` VALUES (39, '10000022', 'GyG+V0r6mBCNsdusuKl03g==', 'T1', '实习工程师', '2023-07-15 09:17:49', '2023-07-15 09:17:49');
COMMIT;

-- ----------------------------
-- Table structure for employee_salary
-- ----------------------------
DROP TABLE IF EXISTS `employee_salary`;
CREATE TABLE `employee_salary` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `employee_number` varchar(16) NOT NULL DEFAULT '' COMMENT '雇员编号',
  `salary_total_amount` decimal(8,2) NOT NULL COMMENT '薪资总额',
  `salary_merit_amount` decimal(8,2) NOT NULL COMMENT '绩效工资',
  `salary_base_amount` decimal(8,2) NOT NULL COMMENT '基础工资',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_employee_number` (`employee_number`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_salary
-- ----------------------------
BEGIN;
INSERT INTO `employee_salary` VALUES (1, '10000001', 5100.00, 1020.00, 4080.00, '2023-07-14 16:09:06', '2023-07-14 16:09:06');
INSERT INTO `employee_salary` VALUES (2, '10000010', 5000.00, 1000.00, 4000.00, '2023-07-14 16:17:10', '2023-07-14 16:17:10');
INSERT INTO `employee_salary` VALUES (3, '10000011', 5000.00, 1000.00, 4000.00, '2023-07-14 16:17:10', '2023-07-14 16:17:10');
INSERT INTO `employee_salary` VALUES (4, '10000012', 5000.00, 1000.00, 4000.00, '2023-07-14 16:17:10', '2023-07-14 16:17:10');
INSERT INTO `employee_salary` VALUES (5, '10000013', 5000.00, 1000.00, 4000.00, '2023-07-14 16:17:10', '2023-07-14 16:17:10');
INSERT INTO `employee_salary` VALUES (6, '10000014', 5000.00, 1000.00, 4000.00, '2023-07-14 16:17:10', '2023-07-14 16:17:10');
INSERT INTO `employee_salary` VALUES (8, '10000022', 100.00, 10.00, 90.00, '2023-07-15 09:17:49', '2023-07-15 09:17:49');
COMMIT;

-- ----------------------------
-- Table structure for employee_salary_adjust
-- ----------------------------
DROP TABLE IF EXISTS `employee_salary_adjust`;
CREATE TABLE `employee_salary_adjust` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `employee_number` varchar(16) NOT NULL DEFAULT '' COMMENT '雇员编号',
  `adjust_order_id` varchar(32) NOT NULL DEFAULT '' COMMENT '调薪单号',
  `adjust_total_amount` decimal(8,2) NOT NULL COMMENT '总额调薪',
  `adjust_base_amount` decimal(8,2) NOT NULL COMMENT '基础调薪',
  `adjust_merit_amount` decimal(8,2) NOT NULL COMMENT '绩效调薪',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`adjust_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_salary_adjust
-- ----------------------------
BEGIN;
INSERT INTO `employee_salary_adjust` VALUES (1, '10000001', '109089990198888811', 1000.00, 800.00, 200.00, '2023-07-14 16:55:53', '2023-07-14 16:55:53');
INSERT INTO `employee_salary_adjust` VALUES (2, '10000001', '100908977676001', 100.00, 20.00, 80.00, '2023-07-14 21:57:39', '2023-07-14 21:57:39');
COMMIT;

-- ----------------------------
-- Table structure for rule_tree
-- ----------------------------
DROP TABLE IF EXISTS `rule_tree`;
CREATE TABLE `rule_tree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tree_name` varchar(64) DEFAULT NULL COMMENT '规则树Id',
  `tree_desc` varchar(128) DEFAULT NULL COMMENT '规则树描述',
  `tree_root_node_id` bigint(20) DEFAULT NULL COMMENT '规则树根ID',
  `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(3) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2110081903 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule_tree
-- ----------------------------
BEGIN;
INSERT INTO `rule_tree` VALUES (2110081902, '抽奖活动规则树', '用于决策不同用户可参与的活动', 1, '2021-10-08 15:38:05.000', '2021-10-08 15:38:05.000');
COMMIT;

-- ----------------------------
-- Table structure for rule_tree_node
-- ----------------------------
DROP TABLE IF EXISTS `rule_tree_node`;
CREATE TABLE `rule_tree_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tree_id` int(2) DEFAULT NULL COMMENT '规则树ID',
  `node_type` int(2) DEFAULT NULL COMMENT '节点类型；1子叶、2果实',
  `node_value` varchar(32) DEFAULT NULL COMMENT '节点值[nodeType=2]；果实值',
  `rule_key` varchar(16) DEFAULT NULL COMMENT '规则Key',
  `rule_desc` varchar(32) DEFAULT NULL COMMENT '规则描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule_tree_node
-- ----------------------------
BEGIN;
INSERT INTO `rule_tree_node` VALUES (1, 2110081902, 1, NULL, 'userGender', '用户性别[男/女]');
INSERT INTO `rule_tree_node` VALUES (11, 2110081902, 1, NULL, 'userAge', '用户年龄');
INSERT INTO `rule_tree_node` VALUES (12, 2110081902, 1, NULL, 'userAge', '用户年龄');
INSERT INTO `rule_tree_node` VALUES (111, 2110081902, 2, '100001', NULL, NULL);
INSERT INTO `rule_tree_node` VALUES (112, 2110081902, 2, '100002', NULL, NULL);
INSERT INTO `rule_tree_node` VALUES (121, 2110081902, 2, '100003', NULL, NULL);
INSERT INTO `rule_tree_node` VALUES (122, 2110081902, 2, '100004', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for rule_tree_node_line
-- ----------------------------
DROP TABLE IF EXISTS `rule_tree_node_line`;
CREATE TABLE `rule_tree_node_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tree_id` bigint(20) DEFAULT NULL COMMENT '规则树ID',
  `node_id_from` bigint(20) DEFAULT NULL COMMENT '节点From',
  `node_id_to` bigint(20) DEFAULT NULL COMMENT '节点To',
  `rule_limit_type` int(2) DEFAULT NULL COMMENT '限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围];7:果实',
  `rule_limit_value` varchar(32) DEFAULT NULL COMMENT '限定值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule_tree_node_line
-- ----------------------------
BEGIN;
INSERT INTO `rule_tree_node_line` VALUES (1, 2110081902, 1, 11, 1, 'man');
INSERT INTO `rule_tree_node_line` VALUES (2, 2110081902, 1, 12, 1, 'woman');
INSERT INTO `rule_tree_node_line` VALUES (3, 2110081902, 11, 111, 3, '25');
INSERT INTO `rule_tree_node_line` VALUES (4, 2110081902, 11, 112, 4, '25');
INSERT INTO `rule_tree_node_line` VALUES (5, 2110081902, 12, 121, 3, '25');
INSERT INTO `rule_tree_node_line` VALUES (6, 2110081902, 12, 122, 4, '25');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_id` varchar(9) DEFAULT NULL COMMENT '用户ID',
  `user_nickname` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `user_head` varchar(16) DEFAULT NULL COMMENT '用户头像',
  `user_password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '184172133', '小傅哥', '01_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (2, '980765512', '铁锤', '02_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (3, '796542178', '团团', '03_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (4, '523088136', '哈尼克兔', '04_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (5, '123456001', '比丘卡', '05_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (6, '123456002', '兰兰', '06_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (7, '123456003', 'Alexa', '07_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (8, '123456004', '小白', '08_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (9, '123456005', '铃铛', '09_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (10, '123456006', '马小帅', '10_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (11, '123456007', 'S.A.K', '11_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
INSERT INTO `user` VALUES (12, '123456008', '池鱼有点贤', '12_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
