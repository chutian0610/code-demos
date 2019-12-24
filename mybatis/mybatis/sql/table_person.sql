-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `tests`.`person`;
CREATE TABLE `tests`.`person` (
  `id` int(11) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `tests`.`person` VALUES ('1', '张三', '张三的备注');