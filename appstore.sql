/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.25-log : Database - appmanage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`appmanage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `appstore`;

/*Table structure for table `ad_promotion` */

DROP TABLE IF EXISTS `ad_promotion`;

CREATE TABLE `ad_promotion` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键(广告宣传表)',
  `appId` bigint(30) DEFAULT NULL COMMENT '外键(app_info{id})',
  `adPicPath` varchar(30) DEFAULT NULL COMMENT '图片路径',
  `adPV` bigint(50) DEFAULT NULL COMMENT '点击量',
  `carouselPosition` int(30) DEFAULT NULL COMMENT '轮播所处位置',
  `startTime` datetime DEFAULT NULL COMMENT '开始生效时间',
  `endTime` datetime DEFAULT NULL COMMENT '广告失效时间',
  `createBy` bigint(30) DEFAULT NULL COMMENT '由谁生成(外键，bacaend_user{id})',
  `creationDate` datetime DEFAULT NULL COMMENT '生成时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '被谁修改(外键，bacaend_user{id}',
  `modifyDate` datetime DEFAULT NULL COMMENT '上次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ad_promotion` */

/*Table structure for table `app_category` */

DROP TABLE IF EXISTS `app_category`;

CREATE TABLE `app_category` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键(类型表)',
  `categoryCode` varchar(50) DEFAULT NULL COMMENT '类型编码',
  `categoryName` varchar(50) DEFAULT NULL COMMENT '类型名',
  `parentId` bigint(30) DEFAULT NULL COMMENT '父类型id',
  `createBy` bigint(30) DEFAULT NULL COMMENT '谁创建的(外键backend_user{id})',
  `creationTime` datetime DEFAULT NULL,
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '修改人(外键backend_user{id})',
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_category` */

/*Table structure for table `app_info` */

DROP TABLE IF EXISTS `app_info`;

CREATE TABLE `app_info` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键(APP信息表)',
  `softwareName` varchar(50) DEFAULT NULL COMMENT '软件名',
  `APKName` varchar(50) DEFAULT NULL COMMENT 'APK名',
  `supportROM` varchar(50) DEFAULT NULL COMMENT '支持的ROM',
  `interfaceLanguage` varchar(50) DEFAULT NULL COMMENT '界面所用语言',
  `softWareSize` decimal(20,2) DEFAULT NULL COMMENT '软件的大小(Mb)',
  `updateDate` date DEFAULT NULL COMMENT '更新时间',
  `devId` bigint(30) DEFAULT NULL COMMENT '开发者Id',
  `appInfo` varchar(5000) DEFAULT NULL COMMENT 'app基本信息',
  `status` bigint(30) DEFAULT NULL COMMENT '状态（对应：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）',
  `onSaleDate` datetime DEFAULT NULL COMMENT '上架时间',
  `offSaleDate` datetime DEFAULT NULL COMMENT '下架时间',
  `floatFormId` bigint(30) DEFAULT NULL COMMENT '平台类型(对应date_dictionary，1，手机，2，平板，3，通用)',
  `categpryLevel3` bigint(30) DEFAULT NULL COMMENT '三级分类id（来自data_dictionary）',
  `downloads` bigint(30) DEFAULT NULL COMMENT '下载量',
  `createBby` bigint(30) DEFAULT NULL COMMENT '谁添加的(对应dev_user{id})',
  `creationDate` datetime DEFAULT NULL COMMENT '添加时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者id（对应dev_user{id}）',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `categoryLevel1` bigint(30) DEFAULT NULL COMMENT '一级分类id（来自data_dictionary）',
  `categoryLevel2` bigint(30) DEFAULT NULL COMMENT '二级分类id（来自data_dictionary）',
  `logoLocPath` varchar(500) DEFAULT NULL COMMENT 'logo存储在本地电脑的路径',
  `versionId` bigint(30) DEFAULT NULL COMMENT '版本id',
  `logoWebPath` varchar(500) DEFAULT NULL COMMENT 'logo在web服务器存储路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_info` */

/*Table structure for table `app_version` */

DROP TABLE IF EXISTS `app_version`;

CREATE TABLE `app_version` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键(app版本表)',
  `appId` bigint(30) DEFAULT NULL COMMENT 'app的id（外键app_info{id}）,',
  `versionNo` varchar(50) DEFAULT NULL COMMENT '版本编号',
  `versionInfo` varchar(2000) DEFAULT NULL COMMENT '版本信息',
  `publishStatus` bigint(30) DEFAULT NULL COMMENT '发布状态，对应data_dictionary，1 不发布 2 已发布 3 预发布',
  `downloadLink` varchar(500) DEFAULT NULL COMMENT '下载链接',
  `versionSize` decimal(20,2) DEFAULT NULL COMMENT '版本大小',
  `createBy` bigint(30) DEFAULT NULL COMMENT '创建者id（外键dev_user{id}）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建日期时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '修改者id（外键dev_user{id}）',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `apkLocPath` varchar(500) DEFAULT NULL COMMENT 'apk在服务器的存储路径',
  `apkFileName` varchar(500) DEFAULT NULL COMMENT 'apl文件名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `app_version` */

/*Table structure for table `backend_user` */

DROP TABLE IF EXISTS `backend_user`;

CREATE TABLE `backend_user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键(后台人员表)',
  `userCode` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `username` varchar(50) DEFAULT NULL COMMENT '姓名',
  `userType` bigint(30) DEFAULT NULL COMMENT '角色类型id（对应data_dictionary）',
  `createBy` bigint(30) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` bigint(30) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `userPassword` varchar(100) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `backend_user` */

/*Table structure for table `data_dictionary` */

DROP TABLE IF EXISTS `data_dictionary`;

CREATE TABLE `data_dictionary` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键(数据字典表)',
  `typeCode` varchar(50) DEFAULT NULL COMMENT '类型编号',
  `typeName` varchar(50) DEFAULT NULL COMMENT '类型名',
  `valueId` bigint(30) DEFAULT NULL COMMENT '类型值id',
  `valueName` varchar(50) DEFAULT NULL COMMENT '类型值名字',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '谁创建的(外键backend_user{id})',
  `creationDate` datetime DEFAULT NULL,
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '谁创建的(外键backend_user{id})',
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `data_dictionary` */

/*Table structure for table `dev_user` */

DROP TABLE IF EXISTS `dev_user`;

CREATE TABLE `dev_user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键(开发者表)',
  `devCode` varchar(50) DEFAULT NULL COMMENT '账号',
  `devName` varchar(50) DEFAULT NULL COMMENT '姓名',
  `devPassword` varchar(100) DEFAULT NULL COMMENT '密码',
  `devEmail` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `devInfo` varchar(500) DEFAULT NULL COMMENT '介绍',
  `createBy` bigint(30) DEFAULT NULL COMMENT '谁创建的(外键backend_user{id})',
  `creationDate` datetime DEFAULT NULL COMMENT '注册时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '谁创建的(外键backend_user{id})',
  `modifyDate` datetime DEFAULT NULL COMMENT '最近信息修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dev_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
