/*
Navicat MySQL Data Transfer

Source Server         : 123.206.75.169
Source Server Version : 50721
Source Host           : 123.206.75.169:3306
Source Database       : supermis

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-04 23:10:52
*/

DROP DATABASE IF EXISTS supermis;
CREATE DATABASE IF NOT EXISTS supermis DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE supermis;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `megOwner` int(11) NOT NULL COMMENT '提问者编号',
  `answerId` int(11) NOT NULL COMMENT '回答者编号',
  `question` varchar(255) DEFAULT NULL COMMENT '问题内容',
  `answer` varchar(255) DEFAULT NULL COMMENT '回答内容',
  `isReply` tinyint(4) DEFAULT '0' COMMENT '1表示已回复，0表示未回复',
  `qaTime` datetime DEFAULT NULL COMMENT '提问时间',
  `replyTime` datetime DEFAULT NULL COMMENT '回答时间',
  `isValid` tinyint(4) DEFAULT '1' COMMENT '是否有效',
  `alterCon` varchar(255) DEFAULT NULL COMMENT '1表示普通用户未读，0表示普通用户已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '63', '65', '怎样预防儿童哮喘？', '注意空气质量，早晚多喝水。', '1', '2018-04-22 22:06:20', '2018-04-22 22:10:31', '1', '0');
INSERT INTO `answer` VALUES ('5', '63', '65', '提问11', '问答11', '1', '2018-04-23 09:30:26', '2018-04-23 09:37:55', '1', '0');
INSERT INTO `answer` VALUES ('6', '63', '65', '22', '问答22', '1', '2018-04-23 10:17:06', '2018-04-23 10:17:48', '1', '0');
INSERT INTO `answer` VALUES ('7', '63', '65', '提问33', '回答33', '1', '2018-04-23 13:15:17', '2018-04-23 13:44:02', '1', '0');
INSERT INTO `answer` VALUES ('8', '63', '65', '提问4444', '问答44444', '1', '2018-04-25 14:09:20', '2018-04-25 14:22:25', '1', '0');
INSERT INTO `answer` VALUES ('9', '63', '65', '提问5555', '问答55555', '1', '2018-04-25 14:09:24', '2018-04-25 14:24:27', '1', '0');
INSERT INTO `answer` VALUES ('10', '63', '69', '哮喘病的症状有哪些？', null, '0', '2018-05-17 21:08:37', null, '1', null);

-- ----------------------------
-- Table structure for `asthrecord`
-- ----------------------------
DROP TABLE IF EXISTS `asthrecord`;
CREATE TABLE `asthrecord` (
  `id` int(11) NOT NULL COMMENT '编号，主键',
  `followTime` datetime DEFAULT NULL COMMENT '随访时间',
  `isMedTaking` tinyint(4) DEFAULT NULL COMMENT '至此次随访是否仍在服用',
  `timesPerDay` int(11) DEFAULT NULL COMMENT '每日服用次数',
  `dosage` int(11) DEFAULT NULL COMMENT '每次剂量',
  `cardNo` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `drug` varchar(255) DEFAULT NULL COMMENT '药物名称',
  `firstUseDrugTime` datetime DEFAULT NULL COMMENT '开始使用时间',
  `mediDay` int(11) DEFAULT NULL,
  `drugRoute` varchar(255) DEFAULT NULL COMMENT '给药途径',
  `patientName` varchar(255) DEFAULT NULL COMMENT '病人姓名',
  `altercol` varchar(255) DEFAULT NULL COMMENT '备选列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='哮喘管理记录表';

-- ----------------------------
-- Records of asthrecord
-- ----------------------------

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备编号',
  `deviceName` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `deviceType` varchar(255) DEFAULT NULL COMMENT '设备类型',
  `functions` varchar(255) DEFAULT NULL COMMENT '功效类型',
  `functionDesc` varchar(255) DEFAULT NULL COMMENT '功能描述',
  `manufacturer` varchar(255) DEFAULT NULL COMMENT '生产厂家',
  `deviceModel` varchar(255) DEFAULT NULL COMMENT '设备型号',
  `productDate` varchar(255) DEFAULT NULL COMMENT '出厂日期',
  `expirationDate` varchar(255) DEFAULT NULL COMMENT '设备保质期',
  `devicePrice` int(11) DEFAULT NULL COMMENT '设备单价',
  `deviceStock` int(11) DEFAULT NULL COMMENT '库存量',
  `deviceImg` varchar(255) DEFAULT NULL COMMENT '设备图片',
  `createTime` datetime DEFAULT NULL,
  `altercol` varchar(255) DEFAULT NULL COMMENT '备选列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='设备表';

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '呼吸设备', '呼吸', '呼吸哮喘', '测试呼吸频率', '上海仪器制造商', 'HX01', '2017-02-10', '2020-04-23', '200', '10', 'http://123.206.75.169:8090/kaptcha/a328c15f-b81f-4b74-9571-830befad6a1e.jpg', '2018-04-23 20:58:01', null);
INSERT INTO `device` VALUES ('2', '哮喘设备', '哮喘', '哮喘、呼吸', '测量哮喘症状', '呼吸家', 'XCHX', '2018-08-12 09:59:59', '2022-10-09 15:59:50', '1980', '100', 'http://123.206.75.169:8090/kaptcha/a6babe87-2416-4058-8de4-238b212be495.jpg', '2018-08-19 11:12:51', null);
INSERT INTO `device` VALUES ('3', '智呼吸监测', '哮喘', '哮喘、呼吸', '测量哮喘症状', '呼吸家', 'XCHX', '2018-08-12 09:59:59', '2022-10-09 15:59:50', '1980', '100', 'http://123.206.75.169:8090/kaptcha/349bf65d-d5b1-4e62-8255-462d454c5f48.jpg', '2018-08-19 11:14:34', null);
INSERT INTO `device` VALUES ('4', '心电心压手环', '手环', '即时监测电极式心电/心压', '电极式心电/心压手环', '其他厂商', 'ZHXSH', '2018-08-12 09:59:59', '2022-10-09 15:59:50', '398', '100', 'http://123.206.75.169:8090/kaptcha/e3ecc137-dfe5-421f-b3f7-b0adb0fb21d8.jpg', '2018-08-19 11:17:56', null);
INSERT INTO `device` VALUES ('5', '智能手环', '手环', '即时监测电极式心电/心压', '电极式心电/心压手环', '其他厂商', 'ZHXSH', '2018-08-12 09:59:59', '2022-10-09 15:59:50', '398', '100', 'http://123.206.75.169:8090/kaptcha/731a0e19-7501-4d3f-9c0a-7f36a8268ba5.jpg', '2018-08-19 11:19:00', null);

-- ----------------------------
-- Table structure for `doctoruser`
-- ----------------------------
DROP TABLE IF EXISTS `doctoruser`;
CREATE TABLE `doctoruser` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `cardNo` varchar(20) DEFAULT NULL,
  `hospitalName` varchar(50) DEFAULT NULL,
  `hospitalAddr` varchar(50) DEFAULT NULL COMMENT '医院地址',
  `department` varchar(20) DEFAULT NULL COMMENT '科室',
  `title` varchar(20) DEFAULT NULL COMMENT '职称',
  `medSpecialty` varchar(255) DEFAULT NULL COMMENT '医学专长',
  `mobile` varchar(11) DEFAULT NULL,
  `collScore` float DEFAULT NULL COMMENT '综合评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='医生信息表';

-- ----------------------------
-- Records of doctoruser
-- ----------------------------
INSERT INTO `doctoruser` VALUES ('00000000001', '李主任', '410326196806252618', '仁济医院', '上海市浦东新区浦建路280号', '呼吸科', '副主任', '过敏性鼻炎、哮喘', '18321787738', '4.8');
INSERT INTO `doctoruser` VALUES ('00000000002', '沈主任', '410326196806252618', '仁济医院', '上海市浦东新区浦建路280号', '呼吸科', '主任', '过敏性鼻炎、哮喘', '13700000000', '4.8');
INSERT INTO `doctoruser` VALUES ('00000000003', '沈医生', '123456', '第一妇幼保健院1', '上海市浦东新区', '内科1', '主任1', '风湿病关节炎1', '13735592263', null);
INSERT INTO `doctoruser` VALUES ('00000000004', 'shch70', '123456', '第一医院', null, '内科', '医生', '杂症', '13735592270', null);
INSERT INTO `doctoruser` VALUES ('00000000005', '小小明', '436515199712574566', '中心医院', null, '放射科', '病人', '', '13795376092', null);
INSERT INTO `doctoruser` VALUES ('00000000011', '1', '1', '1', null, '1', '1', '1', '1', null);
INSERT INTO `doctoruser` VALUES ('00000000012', '孙世敏', '110108196309152379', '上海儿童医院', null, '五官科', '主任医生', '过敏性疾病', '18917521631', null);
INSERT INTO `doctoruser` VALUES ('00000000013', 'shch00', '339005198912125800', 'yiyuan', null, 'keshi', 'title', 'zhuang', '13735592200', null);
INSERT INTO `doctoruser` VALUES ('00000000014', '黄新园', '330623197608150310', '嵊州市人民医院', null, '儿科', '副主任医师', '哮喘', '13588515460', null);
INSERT INTO `doctoruser` VALUES ('00000000015', '曹华', '1122222222222', ' 北京协和医院', null, '变态反应科', '主任医师', '过敏性疾病', '13222222222', null);

-- ----------------------------
-- Table structure for `dprelation`
-- ----------------------------
DROP TABLE IF EXISTS `dprelation`;
CREATE TABLE `dprelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctorId` int(11) DEFAULT NULL COMMENT '医生编号',
  `patientId` int(11) DEFAULT NULL COMMENT '病人编号',
  `status` int(11) DEFAULT '1' COMMENT '关系是否有效，1表示有效，-1无效',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='医患关系表';

-- ----------------------------
-- Records of dprelation
-- ----------------------------
INSERT INTO `dprelation` VALUES ('1', '69', '63', '1', '2018-04-06 16:53:57', null);
INSERT INTO `dprelation` VALUES ('2', '65', '63', '1', '2018-04-06 16:54:58', null);
INSERT INTO `dprelation` VALUES ('3', '65', '67', '1', '2018-04-06 16:56:46', null);

-- ----------------------------
-- Table structure for `evarecord`
-- ----------------------------
DROP TABLE IF EXISTS `evarecord`;
CREATE TABLE `evarecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '评测用户编号',
  `deviceId` int(11) DEFAULT NULL COMMENT '设备编号',
  `evaType` varchar(255) DEFAULT NULL COMMENT '评测类型，PEF、FEV1、FEV6、FVC、ACT、RQLQ',
  `evaValue` varchar(255) NOT NULL COMMENT '评测值',
  `evaTime` varchar(255) DEFAULT NULL COMMENT '评测时间',
  `symDescription` varchar(255) DEFAULT NULL COMMENT '症状描述',
  `medRecord` varchar(255) DEFAULT NULL COMMENT '用药记录',
  `latitude` float DEFAULT NULL COMMENT '当前位置纬度(latitude,float)',
  `longitude` float DEFAULT NULL COMMENT '当前位置经度',
  `altercol` varchar(255) DEFAULT NULL COMMENT '候选域',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='评测记录表';

-- ----------------------------
-- Records of evarecord
-- ----------------------------
INSERT INTO `evarecord` VALUES ('1', '58', '2', 'ACT', '76.5', '2018-03-22', '未知', 'test', '0', '0', null);
INSERT INTO `evarecord` VALUES ('2', '63', '1', 'PEF', '{\'PEFBest\':\'95\',\'PEFPredict\':\'90\',\'FEV1\':\'76\',\'FVC\':\'80\',\'PEF\':\'65\'}', '2018-04-23 21:25:30', '感觉良好', '未用药', '31.2467', '121.577', null);
INSERT INTO `evarecord` VALUES ('3', '63', '1', 'ACT', '23', '2018-04-02 10:22:50', '感觉良好', '未用药', '31.2467', '121.577', null);
INSERT INTO `evarecord` VALUES ('4', '63', '1', 'PEF', '{\'PEFBest\':\'95\',\'PEFPredict\':\'90\',\'FEV1\':\'76\',\'FVC\':\'3000\',\'PEF\':\'20\'}', '2018-04-02 09:30:00', '感觉良好', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('5', '63', '1', 'ACT', '23', '2018-04-02 15:17:55', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('6', '63', '-1', 'ACT', '23', '2018-04-02 09:19:14', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('7', '63', '-1', 'TRACK', '23', '2018-04-02 09:24:10', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('8', '63', '-1', 'TRACK', '22', '2018-04-02 16:24:21', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('9', '63', '-1', 'ACT', '22', '2018-04-10 15:24:38', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('10', '63', '-1', 'C-ACT', '22', '2018-04-10 09:54:49', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('11', '63', '-1', 'C-ACT', '22', '2018-04-20 09:24:54', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('12', '63', '-1', 'C-ACT', '20', '2018-04-21 09:25:01', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('13', '63', '-1', 'SAR', '22', '2018-04-22 09:25:17', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('14', '63', '-1', 'SAR', '20', '2018-04-24 09:25:31', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('15', '63', '1', 'PEF', '{\'PEFBest\':\'95\',\'PEFPredict\':\'90\',\'FEV1\':\'76\',\'FVC\':\'3000\',\'PEF\':\'10\'}', '2018-04-25 09:34:18', '感觉良好', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('16', '63', '1', 'PEF', '{\'PEFBest\':\'95\',\'PEFPredict\':\'90\',\'FEV1\':\'76\',\'FVC\':\'3000\',\'PEF\':\'10\'}', '2018-04-25 15:34:32', '感觉良好', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('17', '63', '1', 'PEF', '{\'PEFBest\':\'95\',\'PEFPredict\':\'90\',\'FEV1\':\'76\',\'FVC\':\'3000\',\'PEF\':\'10\'}', '2018-04-24 18:34:34', '感觉良好', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('18', '63', '1', 'PEF', '{\'PEFBest\':\'95\',\'PEFPredict\':\'90\',\'FEV1\':\'76\',\'FVC\':\'3000\',\'PEF\':\'10\'}', '2018-04-23 20:36:29', '感觉良好', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('19', '63', '1', 'PEF', '{\'PEFBest\':\'95\',\'PEFPredict\':\'90\',\'FEV1\':\'76\',\'FVC\':\'3000\',\'PEF\':\'10\'}', '2018-04-26 16:37:01', '感觉良好', '未用药1', null, null, null);
INSERT INTO `evarecord` VALUES ('20', '63', '-1', 'TRACK', '5', '2018-04-25 08:49:22', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('21', '63', '-1', 'TRACK', '5', '2018-04-25 14:50:57', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('22', '63', '-1', 'TRACK', '5', '2018-04-20 08:52:09', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('23', '63', '-1', 'TRACK', '5', '2018-04-20 14:52:25', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('24', '63', '-1', 'TRACK', '5', '2018-04-15 11:52:45', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('25', '63', '-1', 'TRACK', '5', '2018-04-15 18:52:57', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('26', '63', '-1', 'SAR', '22', '2018-04-26 10:12:42', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('27', '63', '1', 'PEF', '{\'PEFBest\':\'95\',\'PEFPredict\':\'90\',\'FEV1\':\'76\',\'FVC\':\'80\',\'PEF\':\'65\'}', '2018-03-23 10:25:30', '感觉良好', '未用药', '31.2467', '121.577', null);
INSERT INTO `evarecord` VALUES ('28', '63', null, 'ACT', '36', '2018-03-23 14:25:30', '感觉良好', '未用药', '31.2467', '121.577', null);
INSERT INTO `evarecord` VALUES ('31', '63', null, 'PEF', '{\"PEFBest\":\"90\",\"PEFPredict\":\"80\",\"FEV1\":\"3000\",\"FVC\":\"3000\",\"PEF\":\"10\"}', '2018-04-27 13:49:27', '感觉良好', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('32', '63', '-1', 'TRACK', '14', '2018-05-03 10:07:22', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('33', '63', '-1', 'TRACK', '15', '2018-05-03 10:07:56', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('34', '63', '-1', 'TRACK', '10', '2018-05-03 10:08:18', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('35', '63', '-1', 'SAR', '40', '2018-05-03 10:08:55', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('36', '63', null, 'PEF', '{\"PEFBest\":\"90\",\"PEFPredict\":\"80\",\"FEV1\":\"3000\",\"FVC\":\"2000\",\"PEF\":\"10\"}', '2018-05-03 11:09:58', '感觉良好', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('37', '63', '-1', 'SAR', '54', '2018-05-17 21:07:23', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('38', '63', null, 'PEF', '{\"PEFBest\":\"120\",\"PEFPredict\":\"119\",\"FEV1\":\"200\",\"FVC\":\"100\",\"PEF\":\"8\"}', '2018-05-17 21:23:56', '感觉良好', '控制用药', null, null, null);
INSERT INTO `evarecord` VALUES ('39', '63', null, 'PEF', '{\"PEFBest\":\"120\",\"PEFPredict\":\"119\",\"FEV1\":\"200\",\"FVC\":\"100\",\"PEF\":\"8\"}', '2018-05-17 21:23:58', '感觉良好', '控制用药', null, null, null);
INSERT INTO `evarecord` VALUES ('40', '63', '-1', 'TRACK', '19', '2018-05-17 21:28:35', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('41', '63', null, 'PEF', '{\"PEFBest\":\"118\",\"PEFPredict\":\"120\",\"FEV1\":\"90\",\"FVC\":\"85\",\"PEF\":\"14\"}', '2018-05-18 08:10:24', '喘息', '控制用药', null, null, null);
INSERT INTO `evarecord` VALUES ('42', '90', '-1', 'TRACK', '13', '2018-08-09 22:04:29', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('43', '90', '-1', 'SAR', '67', '2018-08-09 22:06:31', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('44', '90', '-1', 'TRACK', '12', '2018-08-17 16:29:51', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('45', '90', '-1', 'SAR', '50', '2018-08-17 16:31:41', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('46', '90', '-1', 'TRACK', '22', '2018-08-20 12:07:16', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('47', '90', '-1', 'TRACK', '25', '2018-08-20 12:07:51', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('48', '90', '-1', 'TRACK', '25', '2018-08-20 12:09:31', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('49', '93', '-1', 'TRACK', '16', '2018-08-26 10:05:36', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('50', '93', '-1', 'TRACK', '21', '2018-08-26 10:11:09', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('51', '93', '-1', 'SAR', '62', '2018-08-26 10:11:42', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('52', '93', null, 'PEF', '{\"PEFBest\":\"100\",\"PEFPredict\":\"30\",\"FEV1\":\"50\",\"FVC\":\"36\",\"PEF\":\"70\"}', '2018-08-26 10:12:27', '夜间憋醒', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('53', '93', null, 'PEF', '{\"PEFBest\":\"100\",\"PEFPredict\":\"30\",\"FEV1\":\"50\",\"FVC\":\"36\",\"PEF\":\"70\"}', '2018-08-26 10:12:33', '夜间憋醒', '未用药', null, null, null);
INSERT INTO `evarecord` VALUES ('54', '90', '-1', 'ACT', '13', '2018-08-27 17:48:10', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('55', '90', '-1', 'SAR', '69', '2018-08-27 17:50:35', null, null, null, null, null);
INSERT INTO `evarecord` VALUES ('56', '90', '-1', 'ACT', '7', '2018-08-27 17:51:22', null, null, null, null, null);

-- ----------------------------
-- Table structure for `globaldrug`
-- ----------------------------
DROP TABLE IF EXISTS `globaldrug`;
CREATE TABLE `globaldrug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drug` varchar(255) DEFAULT NULL COMMENT '药物名称',
  `functionDescript` varchar(255) DEFAULT NULL COMMENT '药物功能描述',
  `treatSymptoms` varchar(255) DEFAULT NULL COMMENT '治疗症状',
  `advEffect` varchar(255) DEFAULT NULL COMMENT '不良反应',
  `stock` int(11) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `dosageManage` varchar(255) DEFAULT NULL COMMENT '用量管理',
  `createTime` datetime DEFAULT NULL COMMENT '添加时间',
  `altercol` varchar(255) DEFAULT NULL COMMENT '备选列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药物表';

-- ----------------------------
-- Records of globaldrug
-- ----------------------------

-- ----------------------------
-- Table structure for `interactmessage`
-- ----------------------------
DROP TABLE IF EXISTS `interactmessage`;
CREATE TABLE `interactmessage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `mesOwner` int(11) DEFAULT NULL COMMENT '消息主人',
  `contraid` int(11) DEFAULT NULL COMMENT '对方编号',
  `megSender` int(11) DEFAULT NULL COMMENT '消息发送者编号',
  `megReciver` int(11) DEFAULT NULL COMMENT '消息接受者编号',
  `megContent` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `sendTime` datetime DEFAULT NULL,
  `readTime` datetime DEFAULT NULL,
  `isRead` tinyint(4) NOT NULL DEFAULT '0' COMMENT '消息是否已读,1表示已读，0未读',
  `megType` int(11) DEFAULT NULL COMMENT '消息类型,1表示普通消息，2表示系统消息',
  `altercol` varchar(255) DEFAULT NULL COMMENT '备选列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='互动留言表';

-- ----------------------------
-- Records of interactmessage
-- ----------------------------
INSERT INTO `interactmessage` VALUES ('1', '71', '70', '71', '70', '测试消息发送的内容', '2018-04-03 15:43:30', '2018-04-06 17:26:51', '1', '1', null);
INSERT INTO `interactmessage` VALUES ('2', '70', '71', '71', '70', '测试消息发送的内容', '2018-04-03 15:43:30', null, '0', '1', null);
INSERT INTO `interactmessage` VALUES ('3', '71', '70', '71', '70', '这是配合接口调试的消息', '2018-04-22 15:11:46', null, '0', '1', null);
INSERT INTO `interactmessage` VALUES ('4', '70', '71', '71', '70', '这是配合接口调试的消息', '2018-04-22 15:11:46', null, '0', '1', null);
INSERT INTO `interactmessage` VALUES ('5', '71', '70', '71', '70', '这是配合接口调试的消息2', '2018-04-22 15:12:30', null, '0', '1', null);
INSERT INTO `interactmessage` VALUES ('6', '70', '71', '71', '70', '这是配合接口调试的消息2', '2018-04-22 15:12:30', null, '0', '1', null);
INSERT INTO `interactmessage` VALUES ('7', '63', '65', '63', '65', '提问1', '2018-04-22 18:55:16', null, '0', '1', null);
INSERT INTO `interactmessage` VALUES ('8', '65', '63', '63', '65', '提问1', '2018-04-22 18:55:16', null, '0', '1', null);
INSERT INTO `interactmessage` VALUES ('9', '65', '63', '65', '63', '回答1', '2018-04-22 19:15:30', null, '0', '1', null);
INSERT INTO `interactmessage` VALUES ('10', '63', '65', '65', '63', '回答1', '2018-04-22 19:15:30', null, '0', '1', null);

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，资讯编号',
  `newsType` int(11) DEFAULT NULL COMMENT '资讯类别，1表示哮喘，2表示饮食，3表示科普，4表示健康资讯类，5表示其他资讯类',
  `title` varchar(255) DEFAULT NULL COMMENT '资讯标题',
  `content` text COMMENT '新闻内容',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modTime` datetime DEFAULT NULL COMMENT '修改时间',
  `editor` varchar(255) DEFAULT NULL COMMENT '编辑人',
  `roleid` varchar(255) DEFAULT NULL COMMENT '面向人群的角色',
  `readCount` bigint(20) DEFAULT NULL COMMENT '阅读次数',
  `outlink` varchar(255) DEFAULT NULL COMMENT '外部链接',
  `titleImg` varchar(255) DEFAULT NULL COMMENT '新闻展示的的标识图片',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '当前状态，1表示可用，2表示不可用',
  `alterCol` varchar(255) DEFAULT '' COMMENT '备选列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='新闻资讯表';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '1', '哮喘护理', '(1)随时注意观察哮喘发作和持续的时间，诱发因素，发作时全身症状，如体温、脉象、痰液性质，及大使小便的次数、性质，及时告诉医生。对发有定时者，要在发作前一小时服药。这样往往可制止发作。 \r\n(2)严重哮喘病人，应采取半卧位，有条件的也可以输点氧。随时注意保持呼吸道通畅，必要时针刺天突、膻中、气海等穴。痰多者要协助排痰。有时可根据医生嘱咐选用您艾喷雾剂。洋金花喷雾剂、满山红喷雾剂等能解痉平喘的中药。千万不可随便镇咳。 \r\n(3)一旦发现病人出现久喘不息、神志恍惚烦躁痛苦，或喘难平卧，面色青紫，口吐大量泡沫痰者，应立刻人院抢救，渡过危险之后，再重新调养。哮喘病的调养中，可以进行一些缓慢的户外活动，如做呼吸操，健身散步等等，但切忌过度疲劳。 \r\n (1)随时注意观察哮喘发作和持续的时间，诱发因素，发作时全身症状，如体温、脉象、痰液性质，及大使小便的次数、性质，及时告诉医生。对发有定时者，要在发作前一小时服药。这样往往可制止发作。 \r\n(2)严重哮喘病人，应采取半卧位，有条件的也可以输点氧。随时注意保持呼吸道通畅，必要时针刺天突、膻中、气海等穴。痰多者要协助排痰。有时可根据医生嘱咐选用您艾喷雾剂。洋金花喷雾剂、满山红喷雾剂等能解痉平喘的中药。千万不可随便镇咳。 \r\n(3)一旦发现病人出现久喘不息、神志恍惚烦躁痛苦，或喘难平卧，面色青紫，口吐大量泡沫痰者，应立刻人院抢救，渡过危险之后，再重新调养。哮喘病的调养中，可以进行一些缓慢的户外活动，如做呼吸操，健身散步等等，但切忌过度疲劳。 \r\n', '2018-03-15 21:02:38', '2018-03-28 12:34:35', '管理员', null, '5', '#', 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', null);
INSERT INTO `news` VALUES ('2', '1', '支气管哮喘', '支气管哮喘是一种气道慢性炎症，我们所说的炎症，不是说有火了，化脓了要用抗菌素了这种炎症，它是一种过敏性炎症，对于过敏体质的人，这种炎症导致病人反复的咳嗽、憋喘、胸闷和呼吸困难，炎症导致支气管对各种刺激都敏感，如花粉、烟草、油漆、二硫化碳、冷空气或运动等。', '2018-03-28 22:17:55', null, '管理员', null, '5', null, 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', null);
INSERT INTO `news` VALUES ('3', '2', '饮食注意事项', '1.支气管哮喘患者的饮食宜清淡，少刺激，不宜过饱、过咸、过甜，忌生冷、酒、辛辣等刺激性食物。 \r\n2.过敏性体质者宜少食异性蛋白类食物，一旦发现某种食物确实可诱发患者支气管哮喘发病，应避免进食，宜多食植物性大豆蛋白，如豆类及豆制品等。 \r\n3.经常吃食用菌类能调节免疫功能，如香菇、蘑菇含香菇多糖、蘑菇多糖，可以增强人体抵抗力，减少支气管哮喘的发作。\r\n', '2018-03-28 22:19:28', null, '管理员', null, '5', 'https://mp.weixin.qq.com/s?__biz=MzUzNjU2NzQzOQ==&mid=100000137&idx=1&sn=4f789dd2f153e4895fc4d7be368f925d&scene=19#wechat_redirect', 'http://123.206.75.169:8090/kaptcha/206a54fc-9ed9-4218-908c-1bd353db183d.jpg', '1', null);
INSERT INTO `news` VALUES ('4', '2', '警惕!77%过敏性休克竟因食物诱发！', null, '2018-03-28 22:19:42', null, '管理员', null, '5', '__biz=MzUzNjU2NzQzOQ==&mid=100000137&idx=1&sn=4f789dd2f153e4895fc4d7be368f925d&scene=19#wechat_redirect', 'http://123.206.75.169:8090/kaptcha/59137f22-1eb2-4c07-9ad8-dd37b1bfd78c.jpg', '1', null);
INSERT INTO `news` VALUES ('5', '3', '天气渐凉，小心过敏性鼻炎反复发作 ', null, '2018-03-28 22:20:06', null, '管理员', null, '5', 'https://mp.weixin.qq.com/s?__biz=MzUzNjU2NzQzOQ==&mid=100000178&idx=1&sn=34f6487aef2aa211f2fd01fa4c3639fa&scene=19#wechat_redirect', 'http://123.206.75.169:8090/kaptcha/206a54fc-9ed9-4218-908c-1bd353db183d.jpg', '1', null);
INSERT INTO `news` VALUES ('6', '3', '过敏性鼻炎为何季节性发作？', null, '2018-03-28 22:20:16', null, '管理员', null, '5', 'https://mp.weixin.qq.com/s/SkxS0lQBU2l4L7NsZK6XQg', 'http://123.206.75.169:8090/kaptcha/206a54fc-9ed9-4218-908c-1bd353db183d.jpg', '1', null);
INSERT INTO `news` VALUES ('7', '4', '大健康而是科普12223健康频道1发布', null, '2018-03-28 22:20:42', null, '管理员', null, '5', null, 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', null);
INSERT INTO `news` VALUES ('8', '4', '大健康而是科普12223健康频道1发布', null, '2018-03-28 22:20:49', null, '管理员', null, '5', null, 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', null);
INSERT INTO `news` VALUES ('9', '5', '未知的健康总数美好的', null, '2018-03-28 22:21:15', null, '管理员', null, '5', null, 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', null);
INSERT INTO `news` VALUES ('10', '5', '健康总数美好的', null, '2018-03-28 22:21:32', null, '管理员', null, '5', null, 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', null);
INSERT INTO `news` VALUES ('11', '2', '儿童食物过敏，您是否也做过这些“傻事”？ ', null, '2018-08-16 19:14:05', null, '管理员', null, '5', 'https://mp.weixin.qq.com/s?__biz=MzUzNjU2NzQzOQ==&mid=100000195&idx=1&sn=219aadab47f3a6843d1ad1f19642902f&scene=19#wechat_redirect', 'http://123.206.75.169:8090/kaptcha/206a54fc-9ed9-4218-908c-1bd353db183d.jpg', '1', null);
INSERT INTO `news` VALUES ('12', '1', '过敏性哮喘', '过敏性哮喘是由多种细胞特别是肥大细胞、嗜酸性粒细胞和T淋巴细胞参与的慢性气道炎症，在易感者中此种炎症可引起反复发作的喘息、气促、胸闷和（或）咳嗽等症状，多在夜间和（或）凌晨发生，气道对多种刺激因子反应性增高。', '2018-08-18 21:05:26', null, '管理员', null, '5', null, 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', '');
INSERT INTO `news` VALUES ('13', '1', '老年性哮喘', '随着科学进步和卫生保健工作的发展，老年人口逐年增加。近年来国内外有关老年性哮喘流行病学研究结果显示，老年性哮喘在逐年增加。由于老年人的生理特点，决定了老年性哮喘在病因学、病理生理、发病机制、药代动力学和临床表现等方面有其特殊性，与儿童、青少年哮喘有着某些差异。另外老年性哮喘患者多伴有慢性支气管炎、慢性阻塞性肺病（COPD）、冠心病及左心衰竭等疾病，使老年性哮喘的症状更加复杂，诊断和治疗也比较困难，加上社会经济学因素和不同社会保障体制的不同影响，老年性哮喘往往容易被忽视。因此我们应该对加强对老年性哮喘的基础和临床研究，对其危害性给予足够的警惕，使之及早得到正确的诊断和治疗', '2018-08-18 21:06:48', null, '管理员', null, '5', null, 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', '');
INSERT INTO `news` VALUES ('14', '1', '如何有效控制哮喘患者的疾病发作', null, '2018-08-19 21:06:48', null, '管理员', null, '5', 'https://mp.weixin.qq.com/s/1srRJa05ZsW2JO9DYpDSnQ', 'http://123.206.75.169:8090/kaptcha/206a54fc-9ed9-4218-908c-1bd353db183d.jpg', '1', '');
INSERT INTO `news` VALUES ('15', '1', '她总觉的憋气，会是哮喘吗？', null, '2018-08-18 21:21:01', null, '管理员', null, '5', 'https://mp.weixin.qq.com/s/EYSGFnZumoMOc2gQnEDUKQ', 'http://123.206.75.169:8090/kaptcha/50d1e179-5220-4f5b-af7f-0dfcd1849bb2.jpg', '1', '');
INSERT INTO `news` VALUES ('16', '1', '季节性哮喘如何防', '', '2018-08-18 21:34:47', '2018-08-18 21:27:21', '管理员', null, '10', 'https://mp.weixin.qq.com/s?__biz=MzUzNjU2NzQzOQ==&mid=100000309&idx=1&sn=946bb0e4bb20970eda556179a8474a5a&scene=19#wechat_redirect\r', 'http://123.206.75.169:8090/kaptcha/e0b09ac7-30d9-4ace-bc5b-559f3e545f15.jpg', '1', '');
INSERT INTO `news` VALUES ('17', '3', '预防「花粉过敏」九妙招', '外部链接内容', '2018-08-19 08:34:14', '2018-08-19 08:16:46', '管理员', null, '10', 'https://mp.weixin.qq.com/s?__biz=MzUzNjU2NzQzOQ==&mid=100000285&idx=1&sn=a134748b6331be10a99d0d9b35f2cc50&scene=19#wechat_redirect', 'http://123.206.75.169:8090/kaptcha/81760fd3-2e92-441b-992b-6bb78c0becbb.jpg', '1', '');
INSERT INTO `news` VALUES ('18', '2', '爱你在心口难开—食物过敏', null, null, null, '管理员', null, '5', 'https://mp.weixin.qq.com/s/HVHeQ_pKXeWsPASs7SS_GA', 'http://123.206.75.169:8090/kaptcha/206a54fc-9ed9-4218-908c-1bd353db183d.jpg', '1', '');
INSERT INTO `news` VALUES ('19', '3', '过敏性鼻炎为何季节性发作？ ', '<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<span style=\"font-size:14px;\">一到换季，有人就开始鼻塞、流涕、鼻痒、打喷嚏。请注意，这可能并不是感冒，要知道此时已进入过敏性鼻炎的高发季节，发病人数最多，症状严重。&nbsp;</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<img class=\" \" style=\"height:428.41px;width:677px;\" src=\"http://123.206.75.169:8090/kaptcha/ca22c50b-8f8c-4e61-aa9e-7af31e9492e5.jpg\" /> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<h2 style=\"font-size:16px;font-weight:700;margin-left:0px;\">\r\n	<strong>感冒还是过敏性鼻炎？</strong> \r\n</h2>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<span style=\"font-size:14px;\">过敏性鼻炎4大典型症状是鼻塞、流涕、鼻痒、打喷嚏。这些症状与感冒很相似，因此不少过敏性鼻炎患者通常误认为是感冒，仅服用简单的感冒药物自己进行治疗，结果延误了正确的诊断治疗。 我们在门诊发现许多过敏性鼻炎的患者，他们自以为是顽固性的感冒或者是热伤风，结果延误了治疗。</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<h2 style=\"font-size:16px;font-weight:700;margin-left:0px;\">\r\n	<strong>小毛病，大危害</strong> \r\n</h2>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<span style=\"font-size:14px;\">过敏性鼻炎一般分为轻度和中重度两种。轻度过敏性鼻炎对患者生活并无大的影响，而中重度则已经干扰患者生活，导致生活质量下降，工作效率降低、学习成绩下降，还经常影响睡眠、娱乐，患者十分苦恼。儿童由于无法表达，经常表现为揉鼻子、做鬼脸、青眼窝等。季节性过敏性鼻炎症状更加严重，每年固定季节发作，让患者苦不堪言。如果不及时治疗过敏性鼻炎，会造成鼻窦炎、鼻息肉、中耳炎、支气管哮喘、儿童腺样体肥大。</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<h2 style=\"font-size:16px;font-weight:700;margin-left:0px;\">\r\n	<strong>生活中如何预防过敏性鼻炎？</strong> \r\n</h2>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<strong><span style=\"font-size:14px;\">目前一般从三个方面预防季节性过敏性鼻炎：&nbsp;</span></strong> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<strong><span style=\"font-size:14px;\">一是避免接触过敏原：</span></strong><span style=\"font-size:14px;\">比如使用空气净化器、防尘螨的用品。 &nbsp; &nbsp;</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<strong><span style=\"font-size:14px;\">二是脱敏治疗：</span></strong><span style=\"font-size:14px;\">即小量多次逐步增加过敏源（如花粉）的注射剂量，直至患者体内产生抗体。 &nbsp;</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<strong><span style=\"font-size:14px;\">三是药物治疗：</span></strong><span style=\"font-size:14px;\">近10年来，有效安全每日1次的药物在治疗中占首要地位，特别是针对季节性过敏性鼻炎。</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<span style=\"font-size:14px;\">&nbsp;&nbsp;</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<strong><span style=\"font-size:14px;\">特别提示：</span></strong><span style=\"font-size:14px;\">对于季节性过敏性鼻炎应该提前2－3周用药，季节过后，不能立即停药，应继续用药2周左右。</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<span style=\"font-size:14px;\">值得注意的是，在药物治疗的同时，过敏性鼻炎患者还应从日常生活细节入手预防疾病发生或加重。</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<br />\r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<strong><span style=\"font-size:14px;\">首先，</span></strong><span style=\"font-size:14px;\">注意环境卫生，避免尘螨和霉菌的滋生;最好能每两周以热水清洗枕头、被褥，打扫时应尽量带上口罩;避免过度刺激的味道，如蚊香、油漆、清洁剂等;家中应避免饲养宠物;避免吸烟及处在二手烟或污浊的空气中;皮肤过敏者应避免过度使用清洁剂。</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<strong><span style=\"font-size:14px;\">第二，</span></strong><span style=\"font-size:14px;\">注意身体保暖，卧室的温度要适中，宁可偏热，不可太冷;睡觉时要注意身体特别是脚的保暖，早晨起床后可以温热毛巾轻捂口鼻呼吸数分钟;冷天早晨出门可带上口罩，保持口鼻的温暖湿润，减少冷空气的刺激。</span> \r\n</p>\r\n<p style=\"background-color:transparent;color:#333333;font-family:-apple-system-font,BlinkMacSystemFont,&amp;font-size:17px;font-style:normal;font-weight:400;margin-left:0px;text-align:justify;text-decoration:none;text-indent:0px;\">\r\n	<strong><span style=\"font-size:14px;\">第三，</span></strong><span style=\"font-size:14px;\">保持心情愉快，避免剧烈的情绪波动。</span> \r\n</p>', '2018-08-17 22:10:23', null, '管理员', null, '2', null, 'http://123.206.75.169:8090/kaptcha/ca22c50b-8f8c-4e61-aa9e-7af31e9492e5.jpg', '1', '');

-- ----------------------------
-- Table structure for `patientuser`
-- ----------------------------
DROP TABLE IF EXISTS `patientuser`;
CREATE TABLE `patientuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '人员信息编号',
  `username` varchar(20) DEFAULT NULL,
  `cardNo` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `age` int(11) DEFAULT NULL,
  `permAddr` varchar(50) DEFAULT NULL COMMENT '长住地址',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `firstRelName` varchar(20) DEFAULT NULL,
  `firstRelMobile` varchar(11) DEFAULT NULL,
  `secondRelName` varchar(20) DEFAULT NULL,
  `secondRelMobile` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='普通用户信息表';

-- ----------------------------
-- Records of patientuser
-- ----------------------------
INSERT INTO `patientuser` VALUES ('5', null, '13223445532', null, null, '15221787738', null, null, null, null);
INSERT INTO `patientuser` VALUES ('6', '圆柱', '13223445532', '38', '上海市浦东新区', '18221787738', '五天', '18100120120', '无法', '18100120120');
INSERT INTO `patientuser` VALUES ('7', '张天爱', '4256713223445532', '30', '上海市浦东新区', '13821721101', '张天', '13100120120', '张爱', '17100120120');
INSERT INTO `patientuser` VALUES ('8', '张天爱', '4256713223445532', '30', '上海市浦东新区', '13821721301', '张天', '13100120120', '张爱', '18100120120');
INSERT INTO `patientuser` VALUES ('9', '张天爱', '4256713223445532', '30', '上海市浦东新区', '13821721401', '张天2', '13100120120', '张爱', '18100120120');
INSERT INTO `patientuser` VALUES ('11', 'dshch', '123', '21', '上海市浦东新区1', '13735592263', null, null, null, null);
INSERT INTO `patientuser` VALUES ('12', 'shch1', '1234567', '6', '上海市浦东新区张杨北路', '13735592279', '爸爸', '13735592212', '妈妈', '13735592233');
INSERT INTO `patientuser` VALUES ('14', 'shch', '123456', '28', '上海市浦东新区', '13735592262', null, null, null, null);
INSERT INTO `patientuser` VALUES ('15', 'shch329', '123456', null, 'address', '13735592260', null, null, null, null);
INSERT INTO `patientuser` VALUES ('16', 'shch3', '123456', null, '上海市普陀区', '13735592265', null, null, null, null);
INSERT INTO `patientuser` VALUES ('17', 'shch', '123456', null, '上海市浦东新区', '13735592267', null, null, null, null);
INSERT INTO `patientuser` VALUES ('18', 'shch99', '339005198912125810', null, 'address', '13735592299', null, null, null, null);
INSERT INTO `patientuser` VALUES ('19', 'shch90', '339005198912125812', null, 'address', '13735592290', null, null, null, null);
INSERT INTO `patientuser` VALUES ('20', 'shch80', '339005198912125809', null, 'address', '13736692280', null, null, null, null);
INSERT INTO `patientuser` VALUES ('21', 'shch88', '339005198912125808', null, 'address', '13735592288', null, null, null, null);
INSERT INTO `patientuser` VALUES ('22', 'shch86', '339005198912125861', null, 'address', '13735592286', null, null, null, null);
INSERT INTO `patientuser` VALUES ('23', 'shch82', '339005198912125880', null, 'address', '13735592282', null, null, null, null);
INSERT INTO `patientuser` VALUES ('24', 'shch78', '339005198912125878', null, 'address', '13735592278', null, null, null, null);
INSERT INTO `patientuser` VALUES ('25', 'shch79', '339005198912125879', null, 'address', '13735592277', null, null, null, null);
INSERT INTO `patientuser` VALUES ('26', '易猛', '123456', '30', '上海市浦东', '18817951663', '孙先生', '18917521631', '', '');
INSERT INTO `patientuser` VALUES ('27', '孙世敏', '110108196309152379', '56', '上海市长岛路728弄23号1001室', '18917521631', '夫人', '18888885555', '小孩', '12345617894');
INSERT INTO `patientuser` VALUES ('28', '李扬', '420703199401112222', '24', '湖北鄂州', '12345678911', null, null, null, null);
INSERT INTO `patientuser` VALUES ('29', '黄伟', '429006197608064266', null, '上海', '18917527030', 'MiMi', '18917527031', '', '');
INSERT INTO `patientuser` VALUES ('30', '宋颖', '310108201405122649', null, '上海市长岛路728号23楼1001室', '13391129968', null, null, null, null);
INSERT INTO `patientuser` VALUES ('31', '李云卉', '341181198410210019', '34', '上海嘉定', '13391207783', null, null, null, null);

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('24', '1', '0', '[0],', '总公司', '总公司', '', null);
INSERT INTO `sys_dept` VALUES ('25', '2', '24', '[0],[24],', '开发部', '开发部', '', null);
INSERT INTO `sys_dept` VALUES ('26', '3', '24', '[0],[24],', '运营部', '运营部', '', null);
INSERT INTO `sys_dept` VALUES ('27', '4', '24', '[0],[24],', '战略部', '战略部', '', null);

-- ----------------------------
-- Table structure for `sys_device`
-- ----------------------------
DROP TABLE IF EXISTS `sys_device`;
CREATE TABLE `sys_device` (
  `deviceNo` int(10) NOT NULL AUTO_INCREMENT COMMENT '设备编号',
  `deviceName` varchar(20) DEFAULT NULL COMMENT '设备名称',
  `type` varchar(20) DEFAULT NULL COMMENT '设备类型',
  PRIMARY KEY (`deviceNo`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_device
-- ----------------------------
INSERT INTO `sys_device` VALUES ('1', '智呼吸产品', '呼吸');
INSERT INTO `sys_device` VALUES ('5', '飞得更高', 'ad');
INSERT INTO `sys_device` VALUES ('6', '电放费', '呵呵');
INSERT INTO `sys_device` VALUES ('7', 'ae', 'de');
INSERT INTO `sys_device` VALUES ('8', 'agwe', 'dage');
INSERT INTO `sys_device` VALUES ('9', '十多万', 'ab');
INSERT INTO `sys_device` VALUES ('10', 'dfshhtj', 'gdf');
INSERT INTO `sys_device` VALUES ('12', 'dag', 'ef');
INSERT INTO `sys_device` VALUES ('13', 'dfggggf', 'ra');
INSERT INTO `sys_device` VALUES ('14', 'de', 'aa');
INSERT INTO `sys_device` VALUES ('15', '飞得更高', 'ad');
INSERT INTO `sys_device` VALUES ('16', 's单独', '的啊');

-- ----------------------------
-- Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('16', '0', '0', '状态', null);
INSERT INTO `sys_dict` VALUES ('17', '1', '16', '启用', null);
INSERT INTO `sys_dict` VALUES ('18', '2', '16', '禁用', null);
INSERT INTO `sys_dict` VALUES ('29', '0', '0', '性别', null);
INSERT INTO `sys_dict` VALUES ('30', '1', '29', '男', null);
INSERT INTO `sys_dict` VALUES ('31', '2', '29', '女', null);
INSERT INTO `sys_dict` VALUES ('35', '0', '0', '账号状态', null);
INSERT INTO `sys_dict` VALUES ('36', '1', '35', '启用', null);
INSERT INTO `sys_dict` VALUES ('37', '2', '35', '冻结', null);
INSERT INTO `sys_dict` VALUES ('38', '3', '35', '已删除', null);
INSERT INTO `sys_dict` VALUES ('39', '0', '0', '设备类型', null);
INSERT INTO `sys_dict` VALUES ('40', '1', '39', '哮喘设备', null);
INSERT INTO `sys_dict` VALUES ('41', '2', '39', '呼吸设备', null);

-- ----------------------------
-- Table structure for `sys_expense`
-- ----------------------------
DROP TABLE IF EXISTS `sys_expense`;
CREATE TABLE `sys_expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` decimal(20,2) DEFAULT NULL COMMENT '报销金额',
  `desc` varchar(255) DEFAULT '' COMMENT '描述',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `state` int(11) DEFAULT NULL COMMENT '状态: 1.待提交  2:待审核   3.审核通过 4:驳回',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `processId` varchar(255) DEFAULT NULL COMMENT '流程定义id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='报销表';

-- ----------------------------
-- Records of sys_expense
-- ----------------------------
INSERT INTO `sys_expense` VALUES ('1', '15000.00', '車旅費', '2018-04-03 17:56:34', '2', '1', '40001');

-- ----------------------------
-- Table structure for `sys_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=965 DEFAULT CHARSET=utf8 COMMENT='登录记录';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------


-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=274 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('105', 'system', '0', '[0],', '系统管理', 'fa-user', '#', '4', '1', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('106', 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', '1', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('107', 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', null, '/mgr/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('108', 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', null, '/mgr/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('109', 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', null, '/mgr/delete', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('110', 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', null, '/mgr/reset', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('111', 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', null, '/mgr/freeze', '5', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('112', 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', null, '/mgr/unfreeze', '6', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('113', 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', null, '/mgr/setRole', '7', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('114', 'role', 'system', '[0],[system],', '角色管理', null, '/role', '2', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('115', 'role_add', 'role', '[0],[system],[role],', '添加角色', null, '/role/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('116', 'role_edit', 'role', '[0],[system],[role],', '修改角色', null, '/role/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('117', 'role_remove', 'role', '[0],[system],[role],', '删除角色', null, '/role/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('118', 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', null, '/role/setAuthority', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('119', 'menu', 'system', '[0],[system],', '菜单管理', null, '/menu', '4', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('120', 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', null, '/menu/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('121', 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', null, '/menu/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('122', 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', null, '/menu/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('128', 'log', 'system', '[0],[system],', '业务日志', null, '/log', '6', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('130', 'druid', 'system', '[0],[system],', '监控管理', null, '/druid', '7', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('131', 'dept', 'system', '[0],[system],', '部门管理', null, '/dept', '3', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('132', 'dict', 'system', '[0],[system],', '字典管理', null, '/dict', '4', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('133', 'loginLog', 'system', '[0],[system],', '登录日志', null, '/loginLog', '6', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('134', 'log_clean', 'log', '[0],[system],[log],', '清空日志', null, '/log/delLog', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('135', 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', null, '/dept/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('136', 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', null, '/dept/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('137', 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', null, '/dept/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('138', 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', null, '/dict/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('139', 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', null, '/dict/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('140', 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', null, '/dict/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('141', 'notice', 'system', '[0],[system],', '通知管理', null, '/notice', '9', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('142', 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', null, '/notice/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('143', 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', null, '/notice/update', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('144', 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', null, '/notice/delete', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('145', 'hello', '0', '[0],', '通知', 'fa-rocket', '/notice/hello', '1', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('148', 'code', '0', '[0],', '代码生成', 'fa-code', '/code', '3', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('149', 'api_mgr', '0', '[0],', '接口文档', 'fa-leaf', '/swagger-ui.html', '2', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('150', 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('151', 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('152', 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('153', 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('154', 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('155', 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('156', 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('157', 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('158', 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('159', 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('160', 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('161', 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('162', 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('163', 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('164', 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', '7', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('165', 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', '8', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('166', 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', '9', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('167', 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', '10', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('168', 'expense', '0', '[0],', '报销管理', 'fa-clone', '#', '5', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('169', 'expense_fill', 'expense', '[0],[expense],', '报销申请', '', '/expense', '1', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('170', 'expense_progress', 'expense', '[0],[expense],', '报销审批', '', '/process', '2', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('171', 'dev', '0', '[0],', '设备管理', 'fa-tablet', '/device', '10', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('172', 'device_add', 'dev', '[0],[dev],', '添加设备', '2', '/device/add', '5', '2', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('174', '查看设备', 'dev', '[0],[dev],', '查看设备', '', '/device/detail', '2', '2', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('175', '修改设备', 'dev', '[0],[dev],', '修改设备', 'fa-update', '/device/update', '3', '2', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('176', '删除设备', 'dev', '[0],[dev],', '删除设备', 'fa-delete', '/device/delete', '4', '2', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('178', 'api_manage', 'business_manage', '[0],[business_manage],', '接口管理', 'fa-api', '#', '1', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('193', 'business_manage', '0', '[0],', '业务管理', '', '#', '7', '1', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('194', 'api_device_manage', 'api_manage', '[0],[business_manage],[api_manage],', 'API设备管理', '', '#', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('195', 'api_device_add', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '新增设备', '', '/api/service/device/add', '2', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('196', 'api_device_view', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '查看设备', '', '/api/service/device/view', '3', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('197', 'api_device_delete', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '删除设备', '', '/api/service/device/delete', '3', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('198', 'api_device_update', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '更新设备', '', '/api/service/device/update', '4', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('199', 'api_device_list', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '获取列表', '', '/api/service/device/list', '5', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('200', 'api_udevice_add', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '新增用户设备', '', '/api/service/udevice/add', '1', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('201', 'api_udevice_list', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '获取用户设备列表', '', '/api/service/udevice/list', '2', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('202', 'api_udevice_delete', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '删除用户设备', '', '/api/service/udevice/delete', '3', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('203', 'api_udevice_view', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '查看用户设备', '', '/api/service/udevice/view', '4', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('204', 'api_udevice_update', 'api_device_manage', '[0],[business_manage],[api_manage],[api_device_manage],', '更新用户设备', '', '/api/service/udevice/update', '5', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('222', 'api_meg_manage', 'api_manage', '[0],[business_manage],[api_manage],', '留言管理', '', '#', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('223', 'api_meg_listMegs', 'api_meg_manage', '[0],[business_manage],[api_manage],[api_meg_manage],', '查询聊天记录', 'fa-message', '/api/service/meg/listMegs', '1', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('224', 'api_meg_list', 'api_meg_manage', '[0],[business_manage],[api_manage],[api_meg_manage],', '查询留言列表', '', '/api/service/meg/list', '5', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('225', 'api_meg_add', 'api_meg_manage', '[0],[business_manage],[api_manage],[api_meg_manage],', '新增留言', '', '/api/service/meg/add', '2', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('226', 'api_meg_del', 'api_meg_manage', '[0],[business_manage],[api_manage],[api_meg_manage],', '删除留言', '', '/api/service/meg/delete', '3', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('227', 'api_meg_detail', 'api_meg_manage', '[0],[business_manage],[api_manage],[api_meg_manage],', '查看留言', '', '/api/service/meg/detail', '5', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('228', 'api_news_manage', 'api_manage', '[0],[business_manage],[api_manage],', 'API资讯管理', '', '#', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('229', 'api_news_list', 'api_news_manage', '[0],[business_manage],[api_manage],[api_news_manage],', '新闻列表', '', '/api/service/news/list', '1', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('230', 'api_news_seclist', 'api_news_manage', '[0],[business_manage],[api_manage],[api_news_manage],', '条件查询', '', '/api/service/news/seclist', '2', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('231', 'api_news_add', 'api_news_manage', '[0],[business_manage],[api_manage],[api_news_manage],', '新增资讯', '', '/api/service/news/add', '3', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('232', 'api_news_del', 'api_news_manage', '[0],[business_manage],[api_manage],[api_news_manage],', '删除资讯', '', '/api/service/news/delete', '4', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('233', 'api_news_update', 'api_news_manage', '[0],[business_manage],[api_manage],[api_news_manage],', '修改资讯', '', '/api/service/news/upate', '6', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('234', 'api_news_detail', 'api_news_manage', '[0],[business_manage],[api_manage],[api_news_manage],', '查看资讯', '', '/api/service/news/detail', '6', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('250', 'api_user_manage', 'api_manage', '[0],[business_manage],[api_manage],', 'API用户管理', '', '#', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('251', 'api_user_register', 'api_user_manage', '[0],[business_manage],[api_manage],[api_user_manage],', 'api用户注册', '', '/api/service/user/register', '1', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('252', 'api_user_signin', 'api_user_manage', '[0],[business_manage],[api_manage],[api_user_manage],', 'api用户登录', '', '/api/service/user/signin', '2', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('253', 'api_user_edit', 'api_user_manage', '[0],[business_manage],[api_manage],[api_user_manage],', 'api用户编辑', '', '/api/service/user/edit', '3', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('254', 'api_user_changePwd', 'api_user_manage', '[0],[business_manage],[api_manage],[api_user_manage],', '修改密码', '', '/api/service/user/changePwd', '4', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('255', 'api_user_getlist', 'api_user_manage', '[0],[business_manage],[api_manage],[api_user_manage],', 'api查询用户', '', '/api/service/user/getlist', '5', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('256', 'api_user_logout', 'api_user_manage', '[0],[business_manage],[api_manage],[api_user_manage],', '退出登录', '', '/api/service/user/logout', '5', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('257', 'api_user_view', 'api_user_manage', '[0],[business_manage],[api_manage],[api_user_manage],', '查看信息', '', '/api/service/user/view', '6', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('258', 'api_user_upload', 'api_user_manage', '[0],[business_manage],[api_manage],[api_user_manage],', '上传图片', '', '/api/service/user/upload', '7', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('259', '5', 'api_manage', '[0],[business_manage],[api_manage],', 'API药物管理', '', '#', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('260', 'api_drug_add', '5', '[0],[business_manage],[api_manage],[5],', '新增药物', '', '/api/service/drug/add', '1', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('261', 'api_drug_update', '5', '[0],[business_manage],[api_manage],[5],', '更新药物', '', '/api/service/drug/update', '2', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('262', 'api_drug_list', '5', '[0],[business_manage],[api_manage],[5],', '药物列表', '', '/api/service/drug/list', '3', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('263', 'api_drug_del', '5', '[0],[business_manage],[api_manage],[5],', '删除药物', '', '/api/service/drug/delete', '4', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('264', 'api_drug_detail', '5', '[0],[business_manage],[api_manage],[5],', '查看药物', '', '/api/service/drug/detail', '6', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('265', 'api_evarecord_manage', 'api_manage', '[0],[business_manage],[api_manage],', 'API评测管理', '', '#', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('266', 'api_evaRec_add', 'api_evarecord_manage', '[0],[business_manage],[api_manage],[api_evarecord_manage],', '新增评测', '', '/api/service/evaRec/add', '1', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('267', 'api_evaRec_del', 'api_evarecord_manage', '[0],[business_manage],[api_manage],[api_evarecord_manage],', '删除评测', '', '/api/service/evaRec/delete', '2', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('268', 'api_evaRec_detail', 'api_evarecord_manage', '[0],[business_manage],[api_manage],[api_evarecord_manage],', '评测详情', '', '/api/service/evaRec/detail', '2', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('269', 'api_evaRec_getlist', 'api_evarecord_manage', '[0],[business_manage],[api_manage],[api_evarecord_manage],', '评测列表', '', '/api/service/evaRec/getList', '3', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('270', 'api_evaRec_list', 'api_evarecord_manage', '[0],[business_manage],[api_manage],[api_evarecord_manage],', '评测全部列表', '', '/api/service/evaRec/list', '4', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('271', 'api_evaRec_listEva', 'api_evarecord_manage', '[0],[business_manage],[api_manage],[api_evarecord_manage],', '查询评测', '', '/api/service/evaRec/listEva', '5', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('272', 'api_evaRec_stat', 'api_evarecord_manage', '[0],[business_manage],[api_manage],[api_evarecord_manage],', '统计评测', '', '/api/service/evaRec/statSymp', '5', '4', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('273', 'api_evaRec_update', 'api_evarecord_manage', '[0],[business_manage],[api_manage],[api_evarecord_manage],', '更新评测', '', '/api/service/evaRec/update', '6', '4', '0', null, '1', null);

-- ----------------------------
-- Table structure for `sys_notice`
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='通知表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('6', 'hello世界', '10', '欢迎使用后台管理系统<p><br></p>', '2017-01-11 08:53:20', '1');
INSERT INTO `sys_notice` VALUES ('8', '你好', null, '你好', '2017-05-10 19:28:57', '1');
INSERT INTO `sys_notice` VALUES ('9', '测试通知', null, '<p>大家好，come on</p>', '2018-03-17 18:31:25', '1');

-- ----------------------------
-- Table structure for `sys_operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3853 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------


-- ----------------------------
-- Table structure for `sys_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` bigint(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5100 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
INSERT INTO `sys_relation` VALUES ('3377', '105', '5');
INSERT INTO `sys_relation` VALUES ('3378', '106', '5');
INSERT INTO `sys_relation` VALUES ('3379', '107', '5');
INSERT INTO `sys_relation` VALUES ('3380', '108', '5');
INSERT INTO `sys_relation` VALUES ('3381', '109', '5');
INSERT INTO `sys_relation` VALUES ('3382', '110', '5');
INSERT INTO `sys_relation` VALUES ('3383', '111', '5');
INSERT INTO `sys_relation` VALUES ('3384', '112', '5');
INSERT INTO `sys_relation` VALUES ('3385', '113', '5');
INSERT INTO `sys_relation` VALUES ('3386', '114', '5');
INSERT INTO `sys_relation` VALUES ('3387', '115', '5');
INSERT INTO `sys_relation` VALUES ('3388', '116', '5');
INSERT INTO `sys_relation` VALUES ('3389', '117', '5');
INSERT INTO `sys_relation` VALUES ('3390', '118', '5');
INSERT INTO `sys_relation` VALUES ('3391', '119', '5');
INSERT INTO `sys_relation` VALUES ('3392', '120', '5');
INSERT INTO `sys_relation` VALUES ('3393', '121', '5');
INSERT INTO `sys_relation` VALUES ('3394', '122', '5');
INSERT INTO `sys_relation` VALUES ('3395', '150', '5');
INSERT INTO `sys_relation` VALUES ('3396', '151', '5');
INSERT INTO `sys_relation` VALUES ('4257', '105', '6');
INSERT INTO `sys_relation` VALUES ('4258', '106', '6');
INSERT INTO `sys_relation` VALUES ('4259', '107', '6');
INSERT INTO `sys_relation` VALUES ('4260', '108', '6');
INSERT INTO `sys_relation` VALUES ('4261', '109', '6');
INSERT INTO `sys_relation` VALUES ('4262', '110', '6');
INSERT INTO `sys_relation` VALUES ('4263', '111', '6');
INSERT INTO `sys_relation` VALUES ('4264', '112', '6');
INSERT INTO `sys_relation` VALUES ('4265', '113', '6');
INSERT INTO `sys_relation` VALUES ('4266', '165', '6');
INSERT INTO `sys_relation` VALUES ('4267', '166', '6');
INSERT INTO `sys_relation` VALUES ('4268', '167', '6');
INSERT INTO `sys_relation` VALUES ('4269', '119', '6');
INSERT INTO `sys_relation` VALUES ('4270', '120', '6');
INSERT INTO `sys_relation` VALUES ('4271', '121', '6');
INSERT INTO `sys_relation` VALUES ('4272', '122', '6');
INSERT INTO `sys_relation` VALUES ('4273', '150', '6');
INSERT INTO `sys_relation` VALUES ('4274', '151', '6');
INSERT INTO `sys_relation` VALUES ('4275', '128', '6');
INSERT INTO `sys_relation` VALUES ('4276', '134', '6');
INSERT INTO `sys_relation` VALUES ('4277', '158', '6');
INSERT INTO `sys_relation` VALUES ('4278', '159', '6');
INSERT INTO `sys_relation` VALUES ('4279', '131', '6');
INSERT INTO `sys_relation` VALUES ('4280', '135', '6');
INSERT INTO `sys_relation` VALUES ('4281', '136', '6');
INSERT INTO `sys_relation` VALUES ('4282', '137', '6');
INSERT INTO `sys_relation` VALUES ('4283', '152', '6');
INSERT INTO `sys_relation` VALUES ('4284', '153', '6');
INSERT INTO `sys_relation` VALUES ('4285', '154', '6');
INSERT INTO `sys_relation` VALUES ('4286', '132', '6');
INSERT INTO `sys_relation` VALUES ('4287', '138', '6');
INSERT INTO `sys_relation` VALUES ('4288', '139', '6');
INSERT INTO `sys_relation` VALUES ('4289', '140', '6');
INSERT INTO `sys_relation` VALUES ('4290', '155', '6');
INSERT INTO `sys_relation` VALUES ('4291', '156', '6');
INSERT INTO `sys_relation` VALUES ('4292', '157', '6');
INSERT INTO `sys_relation` VALUES ('4293', '133', '6');
INSERT INTO `sys_relation` VALUES ('4294', '160', '6');
INSERT INTO `sys_relation` VALUES ('4295', '161', '6');
INSERT INTO `sys_relation` VALUES ('4296', '141', '6');
INSERT INTO `sys_relation` VALUES ('4297', '142', '6');
INSERT INTO `sys_relation` VALUES ('4298', '143', '6');
INSERT INTO `sys_relation` VALUES ('4299', '144', '6');
INSERT INTO `sys_relation` VALUES ('4300', '178', '6');
INSERT INTO `sys_relation` VALUES ('4308', '145', '6');
INSERT INTO `sys_relation` VALUES ('4309', '149', '6');
INSERT INTO `sys_relation` VALUES ('4310', '171', '6');
INSERT INTO `sys_relation` VALUES ('4311', '172', '6');
INSERT INTO `sys_relation` VALUES ('4312', '174', '6');
INSERT INTO `sys_relation` VALUES ('4313', '175', '6');
INSERT INTO `sys_relation` VALUES ('4314', '176', '6');
INSERT INTO `sys_relation` VALUES ('4978', '105', '9');
INSERT INTO `sys_relation` VALUES ('4979', '128', '9');
INSERT INTO `sys_relation` VALUES ('4980', '134', '9');
INSERT INTO `sys_relation` VALUES ('4981', '158', '9');
INSERT INTO `sys_relation` VALUES ('4982', '159', '9');
INSERT INTO `sys_relation` VALUES ('4983', '130', '9');
INSERT INTO `sys_relation` VALUES ('4984', '133', '9');
INSERT INTO `sys_relation` VALUES ('4985', '160', '9');
INSERT INTO `sys_relation` VALUES ('4986', '161', '9');
INSERT INTO `sys_relation` VALUES ('4987', '145', '9');
INSERT INTO `sys_relation` VALUES ('4988', '149', '9');
INSERT INTO `sys_relation` VALUES ('4989', '193', '9');
INSERT INTO `sys_relation` VALUES ('4990', '178', '9');
INSERT INTO `sys_relation` VALUES ('4991', '194', '9');
INSERT INTO `sys_relation` VALUES ('4992', '195', '9');
INSERT INTO `sys_relation` VALUES ('4993', '196', '9');
INSERT INTO `sys_relation` VALUES ('4994', '197', '9');
INSERT INTO `sys_relation` VALUES ('4995', '198', '9');
INSERT INTO `sys_relation` VALUES ('4996', '199', '9');
INSERT INTO `sys_relation` VALUES ('4997', '200', '9');
INSERT INTO `sys_relation` VALUES ('4998', '201', '9');
INSERT INTO `sys_relation` VALUES ('4999', '202', '9');
INSERT INTO `sys_relation` VALUES ('5000', '203', '9');
INSERT INTO `sys_relation` VALUES ('5001', '204', '9');
INSERT INTO `sys_relation` VALUES ('5002', '222', '9');
INSERT INTO `sys_relation` VALUES ('5003', '223', '9');
INSERT INTO `sys_relation` VALUES ('5004', '224', '9');
INSERT INTO `sys_relation` VALUES ('5005', '225', '9');
INSERT INTO `sys_relation` VALUES ('5006', '226', '9');
INSERT INTO `sys_relation` VALUES ('5007', '227', '9');
INSERT INTO `sys_relation` VALUES ('5008', '228', '9');
INSERT INTO `sys_relation` VALUES ('5009', '229', '9');
INSERT INTO `sys_relation` VALUES ('5010', '230', '9');
INSERT INTO `sys_relation` VALUES ('5011', '231', '9');
INSERT INTO `sys_relation` VALUES ('5012', '232', '9');
INSERT INTO `sys_relation` VALUES ('5013', '233', '9');
INSERT INTO `sys_relation` VALUES ('5014', '234', '9');
INSERT INTO `sys_relation` VALUES ('5015', '250', '9');
INSERT INTO `sys_relation` VALUES ('5016', '251', '9');
INSERT INTO `sys_relation` VALUES ('5017', '252', '9');
INSERT INTO `sys_relation` VALUES ('5018', '253', '9');
INSERT INTO `sys_relation` VALUES ('5019', '254', '9');
INSERT INTO `sys_relation` VALUES ('5020', '255', '9');
INSERT INTO `sys_relation` VALUES ('5021', '256', '9');
INSERT INTO `sys_relation` VALUES ('5022', '257', '9');
INSERT INTO `sys_relation` VALUES ('5023', '258', '9');
INSERT INTO `sys_relation` VALUES ('5024', '259', '9');
INSERT INTO `sys_relation` VALUES ('5025', '260', '9');
INSERT INTO `sys_relation` VALUES ('5026', '261', '9');
INSERT INTO `sys_relation` VALUES ('5027', '262', '9');
INSERT INTO `sys_relation` VALUES ('5028', '263', '9');
INSERT INTO `sys_relation` VALUES ('5029', '264', '9');
INSERT INTO `sys_relation` VALUES ('5030', '265', '9');
INSERT INTO `sys_relation` VALUES ('5031', '266', '9');
INSERT INTO `sys_relation` VALUES ('5032', '267', '9');
INSERT INTO `sys_relation` VALUES ('5033', '268', '9');
INSERT INTO `sys_relation` VALUES ('5034', '269', '9');
INSERT INTO `sys_relation` VALUES ('5035', '270', '9');
INSERT INTO `sys_relation` VALUES ('5036', '271', '9');
INSERT INTO `sys_relation` VALUES ('5037', '272', '9');
INSERT INTO `sys_relation` VALUES ('5038', '273', '9');
INSERT INTO `sys_relation` VALUES ('5039', '105', '1');
INSERT INTO `sys_relation` VALUES ('5040', '106', '1');
INSERT INTO `sys_relation` VALUES ('5041', '107', '1');
INSERT INTO `sys_relation` VALUES ('5042', '108', '1');
INSERT INTO `sys_relation` VALUES ('5043', '109', '1');
INSERT INTO `sys_relation` VALUES ('5044', '110', '1');
INSERT INTO `sys_relation` VALUES ('5045', '111', '1');
INSERT INTO `sys_relation` VALUES ('5046', '112', '1');
INSERT INTO `sys_relation` VALUES ('5047', '113', '1');
INSERT INTO `sys_relation` VALUES ('5048', '165', '1');
INSERT INTO `sys_relation` VALUES ('5049', '166', '1');
INSERT INTO `sys_relation` VALUES ('5050', '167', '1');
INSERT INTO `sys_relation` VALUES ('5051', '114', '1');
INSERT INTO `sys_relation` VALUES ('5052', '115', '1');
INSERT INTO `sys_relation` VALUES ('5053', '116', '1');
INSERT INTO `sys_relation` VALUES ('5054', '117', '1');
INSERT INTO `sys_relation` VALUES ('5055', '118', '1');
INSERT INTO `sys_relation` VALUES ('5056', '162', '1');
INSERT INTO `sys_relation` VALUES ('5057', '163', '1');
INSERT INTO `sys_relation` VALUES ('5058', '164', '1');
INSERT INTO `sys_relation` VALUES ('5059', '119', '1');
INSERT INTO `sys_relation` VALUES ('5060', '120', '1');
INSERT INTO `sys_relation` VALUES ('5061', '121', '1');
INSERT INTO `sys_relation` VALUES ('5062', '122', '1');
INSERT INTO `sys_relation` VALUES ('5063', '150', '1');
INSERT INTO `sys_relation` VALUES ('5064', '151', '1');
INSERT INTO `sys_relation` VALUES ('5065', '128', '1');
INSERT INTO `sys_relation` VALUES ('5066', '134', '1');
INSERT INTO `sys_relation` VALUES ('5067', '158', '1');
INSERT INTO `sys_relation` VALUES ('5068', '159', '1');
INSERT INTO `sys_relation` VALUES ('5069', '130', '1');
INSERT INTO `sys_relation` VALUES ('5070', '131', '1');
INSERT INTO `sys_relation` VALUES ('5071', '135', '1');
INSERT INTO `sys_relation` VALUES ('5072', '136', '1');
INSERT INTO `sys_relation` VALUES ('5073', '137', '1');
INSERT INTO `sys_relation` VALUES ('5074', '152', '1');
INSERT INTO `sys_relation` VALUES ('5075', '153', '1');
INSERT INTO `sys_relation` VALUES ('5076', '154', '1');
INSERT INTO `sys_relation` VALUES ('5077', '132', '1');
INSERT INTO `sys_relation` VALUES ('5078', '138', '1');
INSERT INTO `sys_relation` VALUES ('5079', '139', '1');
INSERT INTO `sys_relation` VALUES ('5080', '140', '1');
INSERT INTO `sys_relation` VALUES ('5081', '155', '1');
INSERT INTO `sys_relation` VALUES ('5082', '156', '1');
INSERT INTO `sys_relation` VALUES ('5083', '157', '1');
INSERT INTO `sys_relation` VALUES ('5084', '133', '1');
INSERT INTO `sys_relation` VALUES ('5085', '160', '1');
INSERT INTO `sys_relation` VALUES ('5086', '161', '1');
INSERT INTO `sys_relation` VALUES ('5087', '141', '1');
INSERT INTO `sys_relation` VALUES ('5088', '142', '1');
INSERT INTO `sys_relation` VALUES ('5089', '143', '1');
INSERT INTO `sys_relation` VALUES ('5090', '144', '1');
INSERT INTO `sys_relation` VALUES ('5091', '145', '1');
INSERT INTO `sys_relation` VALUES ('5092', '148', '1');
INSERT INTO `sys_relation` VALUES ('5093', '149', '1');
INSERT INTO `sys_relation` VALUES ('5094', '171', '1');
INSERT INTO `sys_relation` VALUES ('5095', '172', '1');
INSERT INTO `sys_relation` VALUES ('5096', '174', '1');
INSERT INTO `sys_relation` VALUES ('5097', '175', '1');
INSERT INTO `sys_relation` VALUES ('5098', '176', '1');
INSERT INTO `sys_relation` VALUES ('5099', '178', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '0', '超级管理员', '24', 'administrator', '1');
INSERT INTO `sys_role` VALUES ('5', '2', '1', '临时', '26', 'temp', null);
INSERT INTO `sys_role` VALUES ('6', '1', '1', '管理员', '26', 'ZYAdmin', null);
INSERT INTO `sys_role` VALUES ('7', '1', '6', '普通用户', '26', 'General_users', null);
INSERT INTO `sys_role` VALUES ('8', '2', '6', '医生用户', '26', 'Doctor_users', null);
INSERT INTO `sys_role` VALUES ('9', '1', '6', '接口用户', '26', 'APIUser_role', null);

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userid` int(11) DEFAULT NULL COMMENT '用户信息表id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, 'e1bce274-133f-464e-8e66-5560e41f906e.jpg', 'admin', 'ecfadcde9305f8891bcfe5a1e28c253e', '8pgby', '张三', '2017-05-10 00:00:00', '2', '100@qq.com', '18200000000', '1', '24', '1', '2016-01-29 08:49:53', '25');
INSERT INTO `sys_user` VALUES ('44', null, null, 'test', '45abb7879f6a8268f1ef600e6038ac73', 'ssts3', 'test', '2017-05-01 00:00:00', '1', 'abc@123.com', '', '5', '26', '3', '2017-05-16 20:33:37', null);
INSERT INTO `sys_user` VALUES ('45', null, null, 'boss', 'f29f221ea7dd8f396dfe3e2bec381443', 'x6jcz', '老板', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:02', null);
INSERT INTO `sys_user` VALUES ('46', null, null, 'manager', 'b53cac62e7175637d4beb3b16b2f7915', 'j3cs9', '经理', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:24', null);
INSERT INTO `sys_user` VALUES ('47', null, null, 'zyAdmin', 'de1fef0e079cb7a51cd894eea5c65180', 'otmk1', '孙先生', '1965-03-15 00:00:00', '1', 'mengiy@126.com', '189175211631', '6', '24', '1', '2018-03-17 18:30:12', null);
INSERT INTO `sys_user` VALUES ('55', null, '4c8f40f4-355f-4734-8cef-06e013e4ce27.jpg', 'lisi', 'd58ad1ab710027671cc8a17fd0f743ba', 'cjg65', '李四', '1986-12-25 00:00:00', '2', 'meigui@qq.com', '15221787738', '7', '26', '1', '2018-03-20 16:12:59', '25');
INSERT INTO `sys_user` VALUES ('56', null, '4c8f40f4-355f-4734-8cef-06e013e4ce27.jpg', 'liansi', '7e5e85462d1468f81b9c83e9052469d0', 'wb6k3', '李四', '1986-12-25 00:00:00', '2', 'meigui@qq.com', '18221787738', '7', '26', '1', '2018-03-20 16:41:09', '25');
INSERT INTO `sys_user` VALUES ('57', null, '4c8f40f4-355f-4734-8cef-06e013e4ce27.jpg', 'liyisheng', '196b3d37b943327e7cab39d856900711', 'kxdel', '李医生', '1986-12-25 00:00:00', '1', 'liyisheng@qq.com', '18321787738', '8', '26', '1', '2018-03-20 20:43:39', '25');
INSERT INTO `sys_user` VALUES ('58', null, '204ecb0b-8bb0-4641-ad85-ef0f5ccf95ae.jpg', 'apiUser', '3466a030333938e4be607300f28f5310', 'spux2', '乐康业务员', '1992-12-25 00:00:00', '2', 'lekang@qq.com', '13700000000', '9,8', '26', '1', '2018-03-21 13:33:27', '25');
INSERT INTO `sys_user` VALUES ('59', null, '4c8f40f4-355f-4734-8cef-06e013e4ce27.jpg', 'zhangtianai', '8c1f91ef784208a04a6097da01f1b562', '8b575', '张天爱', '1988-12-25 00:00:00', '2', 'zhangtianai@126.com', '13821721101', '7', '26', '1', '2018-03-26 18:24:27', '25');
INSERT INTO `sys_user` VALUES ('60', null, '4c8f40f4-355f-4734-8cef-06e013e4ce27.jpg', 'zhangtianai2', 'f7b46eab02e30e2fd91f2a1f5589b139', 'lu9tn', '张天爱2', '1988-12-25 00:00:00', '2', 'zhangtianai@126.com', '13821721301', '7', '26', '1', '2018-03-28 12:49:41', '25');
INSERT INTO `sys_user` VALUES ('61', null, '4c8f40f4-355f-4734-8cef-06e013e4ce27.jpg', 'zhangtianai3', '169d0621f2ab8c830603d3a2437ca1a8', '1f9w7', '张天爱2', '1988-12-25 00:00:00', '2', 'zhangtianai@126.com', '13821721401', '7', '26', '1', '2018-03-28 19:37:38', '25');
INSERT INTO `sys_user` VALUES ('63', null, '0eeabafd-91b6-4cc5-9976-fa0d5ed0b14f.jpg', 'shch', '2b1749038318ee92221ee3aca1f8df7e', 'eldoy', 'shch', '1986-12-25 00:00:00', '2', null, '13735592279', '7', '26', '1', '2018-03-28 20:22:32', null);
INSERT INTO `sys_user` VALUES ('64', null, null, '13735592261', '6d21949af2cc763b68a1e08200de21ef', 'm5t5q', 'shch2', null, '2', null, '13735592261', '7', '26', '1', '2018-03-28 20:24:50', null);
INSERT INTO `sys_user` VALUES ('65', null, '984ff374-a4c9-4f5d-bab4-314e2be41aa5.jpg', '13735592263', 'bf5380332e04dc80600d785545d29083', 'wff7k', 'shch1', null, '2', null, '13735592263', '8', '26', '1', '2018-03-28 20:35:34', null);
INSERT INTO `sys_user` VALUES ('67', null, null, 'shch3', 'ec8d160a4a5803b4f2ef0d4f200c4171', '0bais', 'shch', '1986-12-25 00:00:00', '2', null, '13735592265', '7', '26', '1', '2018-03-29 18:11:04', null);
INSERT INTO `sys_user` VALUES ('68', null, null, '13735592260', 'd9c9a7a6c04c2edbc2b417f0013e0dca', 'a7nj6', 'shch329', null, null, null, '13735592260', '7', '26', '1', '2018-03-29 20:37:23', null);
INSERT INTO `sys_user` VALUES ('69', null, null, '13735592270', 'd9e4078ec21cbc7843866ee5baeb8526', 'd32zi', 'shch70', null, null, null, '13735592270', '8', '26', '1', '2018-03-29 20:43:20', null);
INSERT INTO `sys_user` VALUES ('70', null, null, '', '657707055af33e9364626961af75e883', 'hxdk4', '', null, null, null, '', '7', '26', '1', '2018-03-29 20:46:45', null);
INSERT INTO `sys_user` VALUES ('71', null, null, 'shch5', '1bf5378caabcd7a1a091b7b547ea9402', 'otodu', 'shch5', '1986-12-25 00:00:00', '2', null, '13735592267', '7', '26', '1', '2018-03-30 21:56:31', null);
INSERT INTO `sys_user` VALUES ('72', null, null, '13795376092', '0e25605a1b0a881a9be20b18e4887da3', 'atl38', '小小明', null, null, null, '13795376092', '8', '26', '1', '2018-04-13 15:04:48', null);
INSERT INTO `sys_user` VALUES ('78', null, '', '1', 'e17939cadee94134c1da374cd95990ba', '4q5fk', '1', null, null, null, '1', '8', '26', '1', '2018-05-13 00:30:52', null);
INSERT INTO `sys_user` VALUES ('80', null, null, '13735592299', 'fec8ba8f01bb795fbb1a975416f032aa', '3hmpo', 'shch99', null, null, null, '13735592299', '7', '26', '1', '2018-07-07 20:34:48', null);
INSERT INTO `sys_user` VALUES ('81', null, null, '13735592290', '221998c50dc321f92834298075d74c99', 'ros7v', 'shch90', null, null, null, '13735592290', '7', '26', '1', '2018-07-07 20:37:40', null);
INSERT INTO `sys_user` VALUES ('82', null, null, '13736692280', '176c1c12df589c56bb93f970814329b6', 'fpoi7', 'shch80', null, null, null, '13736692280', '7', '26', '1', '2018-07-07 20:39:28', null);
INSERT INTO `sys_user` VALUES ('83', null, null, '13735592288', '1867751e89e5badb863766fb112bd21d', '6afo6', 'shch88', null, null, null, '13735592288', '7', '26', '1', '2018-07-07 20:41:17', null);
INSERT INTO `sys_user` VALUES ('84', null, null, '13735592286', '4f872179acaa1a0c6b241f9679561baa', '5mmdq', 'shch86', null, null, null, '13735592286', '7', '26', '1', '2018-07-07 20:42:23', null);
INSERT INTO `sys_user` VALUES ('85', null, null, '13735592282', 'ea6eda827db7435584ae2c1a019125a6', 'n1j4o', 'shch82', null, null, null, '13735592282', '7', '26', '1', '2018-07-07 20:55:02', null);
INSERT INTO `sys_user` VALUES ('86', null, null, '13735592278', '4e876721a4bef2097ce275f837475b68', '629e1', 'shch78', null, null, null, '13735592278', '7', '26', '1', '2018-07-07 21:01:49', null);
INSERT INTO `sys_user` VALUES ('87', null, null, '13735592277', '36abdf6966256fa85bd9ef2618b70dbc', 's0xd5', 'shch79', null, null, null, '13735592277', '7', '26', '1', '2018-07-07 21:03:41', null);
INSERT INTO `sys_user` VALUES ('88', null, null, '13735592200', '3f5108f9d3852487dae3e118422c9b88', 'o7ykv', 'shch00', null, null, null, '13735592200', '8', '26', '1', '2018-07-07 21:05:24', null);
INSERT INTO `sys_user` VALUES ('89', null, '', '18817951663', 'bf9baa19e977f85c18136408751fb86b', 'b8il2', '易猛', null, null, null, '18817951663', '7', '26', '1', '2018-07-07 21:27:58', null);
INSERT INTO `sys_user` VALUES ('90', null, '', '18917521631', 'e41af363ddaa7078ff81584d8c4c84e1', 'z1p9t', '孙世敏', null, null, null, '18917521631', '7', '26', '1', '2018-07-11 20:44:21', null);
INSERT INTO `sys_user` VALUES ('91', null, '', '13588515460', '1151a4aa058da56b051fd67e673de68b', 'ytrpt', '黄新园', null, null, null, '13588515460', '8', '26', '1', '2018-07-12 07:54:17', null);
INSERT INTO `sys_user` VALUES ('92', null, '', '12345678911', 'a6053642f09a3134156c1dcb6897e065', 'utg32', '李扬', null, null, null, '12345678911', '7', '26', '1', '2018-07-13 17:08:20', null);
INSERT INTO `sys_user` VALUES ('93', null, null, '18917527030', '7ad6e466189c3c288431f49a15d1207a', 'oq6kl', '黄伟', null, null, null, '18917527030', '7', '26', '1', '2018-08-03 10:03:58', null);
INSERT INTO `sys_user` VALUES ('94', null, null, '13391129968', '5bea32da78f51cc34501fa406d7df5de', '3ml2p', '宋颖', null, null, null, '13391129968', '7', '26', '1', '2018-08-10 17:47:19', null);
INSERT INTO `sys_user` VALUES ('95', null, null, '13222222222', 'cb4f89aa7fb75c74bffbb3256b78de46', 'mi670', '曹华', null, null, null, '13222222222', '8', '26', '1', '2018-08-10 18:02:30', null);
INSERT INTO `sys_user` VALUES ('96', null, '', '13391207783', '09b0fd9fd10ea7048f9f194976f459ab', 'hmyvy', '李云卉', null, null, null, '13391207783', '7', '26', '1', '2018-08-12 08:22:50', null);

-- ----------------------------
-- Table structure for `userdevice`
-- ----------------------------
DROP TABLE IF EXISTS `userdevice`;
CREATE TABLE `userdevice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号，主键',
  `uid` int(11) DEFAULT NULL,
  `deviceId` int(11) DEFAULT NULL,
  `leaseStartTime` datetime DEFAULT NULL COMMENT '设备租赁开始时间',
  `leaseTime` int(11) DEFAULT NULL COMMENT '租赁时长',
  `deviceInitValue` float DEFAULT NULL COMMENT '设备初始最佳值',
  `altercol` varchar(255) DEFAULT NULL COMMENT '备选列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户设备关系表';

-- ----------------------------
-- Records of userdevice
-- ----------------------------
INSERT INTO `userdevice` VALUES ('1', '63', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `userdrugrecord`
-- ----------------------------
DROP TABLE IF EXISTS `userdrugrecord`;
CREATE TABLE `userdrugrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户编号',
  `drugId` int(11) DEFAULT NULL COMMENT '药物编号',
  `startUseTime` datetime DEFAULT NULL COMMENT '开始使用时间',
  `endUseTime` datetime DEFAULT NULL COMMENT '结束使用时间',
  `drugNum` int(11) DEFAULT NULL COMMENT '用药数量',
  `recordTime` datetime DEFAULT NULL COMMENT '记录时间',
  `altercol` varchar(255) DEFAULT NULL COMMENT '备选列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户用药记录表';

-- ----------------------------
-- Records of userdrugrecord
-- ----------------------------
