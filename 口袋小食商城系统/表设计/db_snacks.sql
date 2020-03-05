/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : db_snacks

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-25 14:20:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_account
-- ----------------------------
DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�˻����',
  `uid` int(11) DEFAULT NULL COMMENT '�û����',
  `money` double DEFAULT NULL COMMENT '�˻����',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_account
-- ----------------------------
INSERT INTO `tb_account` VALUES ('1', '1', '1000');

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '���',
  `uid` int(11) NOT NULL COMMENT '�û����',
  `full_address` varchar(200) NOT NULL COMMENT '��ϸ��ַ',
  `phone` varchar(20) NOT NULL COMMENT '��ϵ�˵绰',
  `zip_code` varchar(7) NOT NULL COMMENT '�ʱ�',
  `name` varchar(50) NOT NULL COMMENT '��ϵ������',
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK_Reference_4` (`uid`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES ('1', '1', '河北省张家口市宣化区幸福小区110', '13212341234', '075110', '张小北', '0');
INSERT INTO `tb_address` VALUES ('2', '1', '北京市昌平区交通职业技术学院中软楼', '13212345432', '102200', '温海宁', '1');
INSERT INTO `tb_address` VALUES ('3', '1', '北京市昌平区昌平县城开心小区222', '13510113343', '102200', '张晓南', '0');

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '��ϵ������',
  `phone` varchar(20) NOT NULL COMMENT '�绰',
  `email` varchar(50) NOT NULL COMMENT '����',
  `address` varchar(200) NOT NULL COMMENT '��˾��ϸ��ַ',
  `state` char(1) NOT NULL COMMENT '״̬0:����  1:ȡ������',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
INSERT INTO `tb_brand` VALUES ('1', '三只松鼠', '13212341234', '432424@163.com', '安徽省芜湖市弋江区芜湖高新技术产业开发区', '0');
INSERT INTO `tb_brand` VALUES ('2', '周黑鸭', '13289054543', '5435345@163.com', '安徽', '0');
INSERT INTO `tb_brand` VALUES ('3', '旺旺', '13289054543', '5435345@163.com', '安徽', '0');
INSERT INTO `tb_brand` VALUES ('4', '徐福记', '13289054543', '5435345@163.com', '安徽', '0');
INSERT INTO `tb_brand` VALUES ('5', '好吃点', '13289054543', '5435345@163.com', '安徽省芜湖市弋江区芜湖高新技术产业开发区', '0');
INSERT INTO `tb_brand` VALUES ('6', '稻香村', '13289054543', '5435345@163.com', '安徽', '0');
INSERT INTO `tb_brand` VALUES ('7', '乐事', '13289054543', '5435345@163.com', '安徽', '0');
INSERT INTO `tb_brand` VALUES ('8', '良品铺子', '13289054543', '5435345@163.com', '安徽', '0');
INSERT INTO `tb_brand` VALUES ('9', '卫龙', '13289054543', '5435345@163.com', '安徽省芜湖市弋江区芜湖高新技术产业开发区', '1');
INSERT INTO `tb_brand` VALUES ('10', '口水娃', '13289054543', '5435345@163.com', '安徽', '0');

-- ----------------------------
-- Table structure for tb_cart
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart`;
CREATE TABLE `tb_cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '���ﳵ���',
  `uid` int(11) DEFAULT NULL COMMENT '�û����',
  `quantity` int(11) DEFAULT NULL COMMENT '����',
  `commodity_id` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `FK_Reference_10` (`uid`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_cart
-- ----------------------------
INSERT INTO `tb_cart` VALUES ('24', '1', '14', '1', '8');
INSERT INTO `tb_cart` VALUES ('25', '1', '1', '4', '1');
INSERT INTO `tb_cart` VALUES ('26', '1', '3', '1', '9');
INSERT INTO `tb_cart` VALUES ('27', '1', '1', '9', '2');
INSERT INTO `tb_cart` VALUES ('28', '1', '3', '6', '1');
INSERT INTO `tb_cart` VALUES ('29', '1', '20', '3', '11');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '������',
  `category_parentid` int(11) NOT NULL COMMENT '�������',
  `name` varchar(20) NOT NULL COMMENT '�������',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1', '0', '休闲食品');
INSERT INTO `tb_category` VALUES ('2', '0', '粮油调味');
INSERT INTO `tb_category` VALUES ('3', '0', '进口食品');
INSERT INTO `tb_category` VALUES ('4', '0', '营养辅食');
INSERT INTO `tb_category` VALUES ('5', '0', '饮料冲调');
INSERT INTO `tb_category` VALUES ('6', '0', '个性零食');
INSERT INTO `tb_category` VALUES ('7', '0', '价格');
INSERT INTO `tb_category` VALUES ('8', '1', '休闲零食');
INSERT INTO `tb_category` VALUES ('9', '1', '饼干蛋糕');
INSERT INTO `tb_category` VALUES ('10', '1', '肉干肉脯');
INSERT INTO `tb_category` VALUES ('11', '1', '糖果/巧克力');
INSERT INTO `tb_category` VALUES ('12', '1', '坚果炒货');
INSERT INTO `tb_category` VALUES ('13', '1', '蜜饯果干');
INSERT INTO `tb_category` VALUES ('14', '1', '熟食腊味');
INSERT INTO `tb_category` VALUES ('15', '1', '膨化食品');
INSERT INTO `tb_category` VALUES ('16', '2', '方便食品');
INSERT INTO `tb_category` VALUES ('17', '2', '食用油');
INSERT INTO `tb_category` VALUES ('18', '2', '杂粮');
INSERT INTO `tb_category` VALUES ('19', '2', '南北干货');
INSERT INTO `tb_category` VALUES ('20', '2', '调味品');
INSERT INTO `tb_category` VALUES ('21', '2', '烘焙原料');
INSERT INTO `tb_category` VALUES ('22', '2', '米');
INSERT INTO `tb_category` VALUES ('23', '2', '面');
INSERT INTO `tb_category` VALUES ('24', '3', '饼干蛋糕');
INSERT INTO `tb_category` VALUES ('25', '3', '休闲零食');
INSERT INTO `tb_category` VALUES ('26', '3', '糖果/巧克力');
INSERT INTO `tb_category` VALUES ('27', '3', '方便食品');
INSERT INTO `tb_category` VALUES ('28', '3', '咖啡豆/咖啡粉');
INSERT INTO `tb_category` VALUES ('29', '3', '冲调品');
INSERT INTO `tb_category` VALUES ('30', '3', '米面调油');
INSERT INTO `tb_category` VALUES ('31', '3', '饮料');
INSERT INTO `tb_category` VALUES ('32', '3', '牛奶');
INSERT INTO `tb_category` VALUES ('33', '3', '油');
INSERT INTO `tb_category` VALUES ('34', '4', '宝宝零食');
INSERT INTO `tb_category` VALUES ('35', '4', '果汁/果泥');
INSERT INTO `tb_category` VALUES ('36', '4', '米粉/菜粉');
INSERT INTO `tb_category` VALUES ('37', '4', '钙铁锌/维生素');
INSERT INTO `tb_category` VALUES ('38', '4', '面条/粥');
INSERT INTO `tb_category` VALUES ('39', '4', '清火/开胃');
INSERT INTO `tb_category` VALUES ('40', '4', '益生菌');
INSERT INTO `tb_category` VALUES ('41', '5', '冲饮谷物');
INSERT INTO `tb_category` VALUES ('42', '5', '饮料');
INSERT INTO `tb_category` VALUES ('43', '5', '牛奶乳品');
INSERT INTO `tb_category` VALUES ('44', '5', '咖啡/奶茶');
INSERT INTO `tb_category` VALUES ('45', '5', '成人奶粉');
INSERT INTO `tb_category` VALUES ('46', '5', '蜂蜜/柚子茶');
INSERT INTO `tb_category` VALUES ('47', '7', '0-25');
INSERT INTO `tb_category` VALUES ('48', '7', '26-50');
INSERT INTO `tb_category` VALUES ('49', '7', '50以上');
INSERT INTO `tb_category` VALUES ('50', '0', '海鲜制品');
INSERT INTO `tb_category` VALUES ('51', '0', '其他');

-- ----------------------------
-- Table structure for tb_commodity
-- ----------------------------
DROP TABLE IF EXISTS `tb_commodity`;
CREATE TABLE `tb_commodity` (
  `commodity_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `cname` varchar(50) NOT NULL COMMENT '��Ʒ����',
  `promotional_price` double DEFAULT NULL COMMENT '������',
  `original_price` double NOT NULL COMMENT 'ԭ��',
  `description` varchar(500) NOT NULL COMMENT '����',
  `img` varchar(30) NOT NULL COMMENT 'ͼƬ',
  `createtime` datetime NOT NULL COMMENT '�ϼ�ʱ��',
  PRIMARY KEY (`commodity_id`),
  KEY `category_id` (`category_id`),
  KEY `store_id` (`brand_id`),
  CONSTRAINT `store_id` FOREIGN KEY (`brand_id`) REFERENCES `tb_brand` (`brand_id`),
  CONSTRAINT `tb_commodity_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_commodity
-- ----------------------------
INSERT INTO `tb_commodity` VALUES ('1', '1', '7', '乐事（Lay’s）零食 休闲食品 大波浪薯片 ', '13.5', '13.5', '品牌： 乐事（Lay\'s）\r\n商品名称：乐事大波浪薯片 铁板鱿鱼味 145g商品毛重：160.00g商品产地：上海市国产/进口：国产分类：膨化食品', 'sp01.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('2', '1', '7', '乐事（Lay’s）薯片 休闲零食 145g', '10.5', '10.5', '品牌： 乐事（Lay\'s）\r\n商品名称：乐事（Lay\'s） 乐事大波浪薯片碳烤五花肉味145g/袋休闲食品小吃零食商品编号：28553162264毛重：160.00g国产/进口：国产规格：200g以下', 'sp02.jpg', '2019-05-13 16:49:32');
INSERT INTO `tb_commodity` VALUES ('3', '1', '1', '休闲怀旧零食品掌心脆干吃方便面', '1', '1', '产品参数：\r\n\r\n生产许可证编号：SC10633019702613产品标准号：LS/T 3211 GB 17400厂名：杭州统一企业有限公司厂址：浙江省杭州市杭州大江东产业集聚区三丰路301号厂家联系方式：4007000600配料表：小麦粉、精炼植物油（含维生素E）、白砂糖、食用盐等储藏方法：常温避光保质期：180 天食品添加剂：见包装品牌: 统一系列: 小当家干脆面', 'sp03.jpg', '2019-05-14 10:17:27');
INSERT INTO `tb_commodity` VALUES ('4', '1', '1', '冬己饼干咸蛋黄黑糖夹心麦芽饼网红办公室休闲小零食', '25.5', '25.5', '5464', 'sp04.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('5', '1', '1', '曲奇饼干进口黄油糕点办公零食', '30', '30', '5464', 'sp05.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('6', '3', '1', '白色恋人饼干日本进口零食北海道夹心饼干', '15.5', '15.5', '5464', 'sp06.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('7', '3', '1', '黄金香厦门老字号鼓浪屿特产油酥肉松营养零食', '68', '68', '5464', 'sp07.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('8', '3', '1', '泡椒凤爪500g小包装泡凤爪散装鸡爪子休闲成人零食', '13.5', '13.5', '5464', 'sp08.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('9', '3', '1', '牛肉干肉脯零食小吃牛筋牛肉粒', '54', '54', '5464', 'sp09.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('10', '1', '1', '营养早餐口袋面包网红零食饼干蛋糕乳酸菌小伴侣面包', '28.9', '28.9', '5464', 'sp10.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('11', '1', '1', '休闲零食膨化小吃方便面干脆面小贱拉面丸子85g/袋', '10.9', '10.9', '5464', 'sp11.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('12', '1', '1', '饼干糕点网红零食台湾风味一口凤梨酥300g/袋', '39.5', '39.5', '5464', 'sp12.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('13', '1', '1', '肉食海味即食鱼干小鱼仔香酥小黄鱼96g/袋', '9.9', '9.9', '5464', 'sp13.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('14', '1', '1', '薯片 休闲零食 休闲怀旧零食 送礼零食', '12', '12', '5464', 'sp14.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('15', '1', '1', '巨型网红零食大礼包2.0升级版30包送礼肩扛大零食猪饲料', '88', '88', '5464', '001.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('16', '1', '1', '芒果干116g休闲零食特产蜜饯果脯水果干', '23', '23', '5464', '002.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('17', '1', '1', ' 坚果炒货休闲零食 送礼零食', '23', '23', '5464', '003.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('18', '1', '1', ' 每日坚果混合果仁 送礼零食', '23', '23', '5464', '004.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('19', '1', '1', ' 每日坚果混合果仁（25g*30包）750g/盒 送礼零食礼盒', '79.9', '79.9', '5464', '005.jpg', '2019-05-28 16:59:00');
INSERT INTO `tb_commodity` VALUES ('20', '1', '1', '坚果炒货零食每日坚果手剥东北开口松子', '23', '23', '5464', '006.jpg', '2019-05-15 17:15:45');

-- ----------------------------
-- Table structure for tb_commodity_param
-- ----------------------------
DROP TABLE IF EXISTS `tb_commodity_param`;
CREATE TABLE `tb_commodity_param` (
  `param_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `product_area` varchar(50) DEFAULT NULL,
  `product_place` varchar(50) DEFAULT NULL,
  `product_specification` varchar(50) DEFAULT NULL,
  `expiration_date` varchar(50) DEFAULT NULL,
  `usage` varchar(50) DEFAULT NULL,
  `storage _method` varchar(50) DEFAULT NULL,
  `standard_ number` varchar(50) DEFAULT NULL,
  `license_ number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_commodity_param
-- ----------------------------

-- ----------------------------
-- Table structure for tb_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `tb_evaluate`;
CREATE TABLE `tb_evaluate` (
  `content` varchar(500) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `oid` varchar(80) DEFAULT NULL,
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for tb_flavor
-- ----------------------------
DROP TABLE IF EXISTS `tb_flavor`;
CREATE TABLE `tb_flavor` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '���',
  `fname` varchar(30) NOT NULL COMMENT '��ζ����',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_flavor
-- ----------------------------
INSERT INTO `tb_flavor` VALUES ('1', '混合口味');
INSERT INTO `tb_flavor` VALUES ('2', '香辣');
INSERT INTO `tb_flavor` VALUES ('3', '香葱');
INSERT INTO `tb_flavor` VALUES ('4', '红烧牛肉');
INSERT INTO `tb_flavor` VALUES ('5', '五香牛肉');
INSERT INTO `tb_flavor` VALUES ('6', '铁板鱿鱼');
INSERT INTO `tb_flavor` VALUES ('7', '芝士培根');
INSERT INTO `tb_flavor` VALUES ('8', '番茄');
INSERT INTO `tb_flavor` VALUES ('9', '经典原味');
INSERT INTO `tb_flavor` VALUES ('10', '鸡翅');
INSERT INTO `tb_flavor` VALUES ('11', '奶油');
INSERT INTO `tb_flavor` VALUES ('12', '麻辣');

-- ----------------------------
-- Table structure for tb_flavor_commodity
-- ----------------------------
DROP TABLE IF EXISTS `tb_flavor_commodity`;
CREATE TABLE `tb_flavor_commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '���',
  `fid` int(11) NOT NULL COMMENT '��ζ���',
  `commodity_id` int(11) NOT NULL COMMENT '��Ʒ���',
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`fid`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`fid`) REFERENCES `tb_flavor` (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_flavor_commodity
-- ----------------------------
INSERT INTO `tb_flavor_commodity` VALUES ('1', '1', '14', '44');
INSERT INTO `tb_flavor_commodity` VALUES ('2', '2', '14', '54');
INSERT INTO `tb_flavor_commodity` VALUES ('3', '3', '14', '54');
INSERT INTO `tb_flavor_commodity` VALUES ('4', '1', '9', '63');
INSERT INTO `tb_flavor_commodity` VALUES ('5', '2', '9', '42');
INSERT INTO `tb_flavor_commodity` VALUES ('6', '9', '3', '54');
INSERT INTO `tb_flavor_commodity` VALUES ('7', '10', '3', '55');
INSERT INTO `tb_flavor_commodity` VALUES ('8', '11', '3', '0');
INSERT INTO `tb_flavor_commodity` VALUES ('9', '8', '1', '49');
INSERT INTO `tb_flavor_commodity` VALUES ('10', '9', '1', '57');
INSERT INTO `tb_flavor_commodity` VALUES ('11', '8', '2', '22');
INSERT INTO `tb_flavor_commodity` VALUES ('12', '9', '2', '66');
INSERT INTO `tb_flavor_commodity` VALUES ('13', '1', '4', '39');
INSERT INTO `tb_flavor_commodity` VALUES ('14', '1', '5', '31');
INSERT INTO `tb_flavor_commodity` VALUES ('15', '1', '6', '63');
INSERT INTO `tb_flavor_commodity` VALUES ('16', '1', '7', '2');
INSERT INTO `tb_flavor_commodity` VALUES ('17', '1', '8', '4');
INSERT INTO `tb_flavor_commodity` VALUES ('18', '1', '9', '66');
INSERT INTO `tb_flavor_commodity` VALUES ('19', '1', '10', '3');
INSERT INTO `tb_flavor_commodity` VALUES ('20', '1', '11', '7');
INSERT INTO `tb_flavor_commodity` VALUES ('21', '1', '12', '55');
INSERT INTO `tb_flavor_commodity` VALUES ('22', '1', '13', '886');
INSERT INTO `tb_flavor_commodity` VALUES ('23', '1', '15', '77');
INSERT INTO `tb_flavor_commodity` VALUES ('24', '1', '16', '33');
INSERT INTO `tb_flavor_commodity` VALUES ('25', '1', '17', '65');
INSERT INTO `tb_flavor_commodity` VALUES ('26', '1', '18', '54');
INSERT INTO `tb_flavor_commodity` VALUES ('27', '1', '19', '5');
INSERT INTO `tb_flavor_commodity` VALUES ('28', '1', '20', '6');

-- ----------------------------
-- Table structure for tb_orders
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders` (
  `oid` varchar(80) NOT NULL COMMENT '�������',
  `uid` int(11) DEFAULT NULL COMMENT '�û����',
  `totalprice` double DEFAULT NULL COMMENT '�ܼ�',
  `remark` varchar(50) DEFAULT NULL COMMENT '��ע',
  `ordertime` datetime DEFAULT NULL COMMENT '�µ�ʱ��',
  `state` int(11) DEFAULT NULL COMMENT '����״̬��0:��֧��  1:��֧��  2:��ȡ��',
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FK_Reference_6` (`uid`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_orders
-- ----------------------------
INSERT INTO `tb_orders` VALUES ('0162baba-91a8-4be6-8a81-fcf394fcca8d', '1', '162', '送小礼物', '2019-05-28 10:28:00', '1', '3');
INSERT INTO `tb_orders` VALUES ('9a4aaf2e-d6a0-456b-b367-60750c52cf23', '1', '245.5', '送小礼物', '2019-05-28 10:51:37', '1', '1');
INSERT INTO `tb_orders` VALUES ('e43d9b93-9619-4178-8ba7-518e2990495c', '1', '79.5', '', '2019-05-28 10:54:01', '1', '1');

-- ----------------------------
-- Table structure for tb_orders_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders_detail`;
CREATE TABLE `tb_orders_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '���',
  `commodity_id` int(11) DEFAULT NULL COMMENT '��Ʒ���',
  `quantity` int(11) DEFAULT NULL COMMENT '����',
  `price` double DEFAULT NULL COMMENT '����',
  `fid` int(11) DEFAULT NULL COMMENT '��ζ���',
  `brand_id` int(11) DEFAULT NULL,
  `oid` varchar(80) DEFAULT NULL COMMENT '�������',
  PRIMARY KEY (`detail_id`),
  KEY `FK_Reference_1` (`fid`),
  KEY `FK_Reference_8` (`brand_id`),
  KEY `FK_Reference_9` (`oid`),
  KEY `commodity_id` (`commodity_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`fid`) REFERENCES `tb_flavor` (`fid`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`brand_id`) REFERENCES `tb_brand` (`brand_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`oid`) REFERENCES `tb_orders` (`oid`),
  CONSTRAINT `tb_orders_detail_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `tb_commodity` (`commodity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_orders_detail
-- ----------------------------
INSERT INTO `tb_orders_detail` VALUES ('26', '1', '2', '13.5', '9', '7', '0162baba-91a8-4be6-8a81-fcf394fcca8d');
INSERT INTO `tb_orders_detail` VALUES ('27', '9', '1', '54', '2', '1', '0162baba-91a8-4be6-8a81-fcf394fcca8d');
INSERT INTO `tb_orders_detail` VALUES ('28', '4', '1', '25.5', '1', '1', '9a4aaf2e-d6a0-456b-b367-60750c52cf23');
INSERT INTO `tb_orders_detail` VALUES ('29', '1', '3', '13.5', '9', '7', '9a4aaf2e-d6a0-456b-b367-60750c52cf23');
INSERT INTO `tb_orders_detail` VALUES ('30', '9', '1', '54', '2', '1', '9a4aaf2e-d6a0-456b-b367-60750c52cf23');
INSERT INTO `tb_orders_detail` VALUES ('31', '6', '1', '15.5', '1', '1', '9a4aaf2e-d6a0-456b-b367-60750c52cf23');
INSERT INTO `tb_orders_detail` VALUES ('32', '4', '1', '25.5', '1', '1', 'e43d9b93-9619-4178-8ba7-518e2990495c');
INSERT INTO `tb_orders_detail` VALUES ('33', '9', '1', '54', '2', '1', 'e43d9b93-9619-4178-8ba7-518e2990495c');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '�û����',
  `username` varchar(50) NOT NULL COMMENT '�û���',
  `password` varchar(50) NOT NULL COMMENT '����',
  `phone` varchar(20) DEFAULT NULL COMMENT '�ֻ���',
  `sex` char(2) DEFAULT NULL COMMENT '�Ա�',
  `email` varchar(50) DEFAULT NULL COMMENT '����',
  `regtime` datetime DEFAULT NULL COMMENT 'ע��ʱ��',
  `updatetime` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  `account_id` int(11) DEFAULT NULL COMMENT '�˻����',
  PRIMARY KEY (`uid`),
  KEY `FK_Reference_3` (`account_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`account_id`) REFERENCES `tb_account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'whn', '123456', '13212341234', '女', 'whn@chinasofti.com', '2019-05-01 14:20:47', null, '1');
