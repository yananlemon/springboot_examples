/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.44 : Database - spring-security
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring-security` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `spring-security`;

/*Table structure for table `t_permissions` */

DROP TABLE IF EXISTS `t_permissions`;

CREATE TABLE `t_permissions` (
  `permission_code` varchar(20) NOT NULL COMMENT '权限编码，主键。',
  `parent_permission_code` varchar(20) DEFAULT NULL COMMENT '权限父编码',
  `permission_type` varchar(20) DEFAULT NULL,
  `permission_text` varchar(50) DEFAULT NULL COMMENT '权限文本',
  `permission_url` varchar(100) DEFAULT NULL COMMENT '权限url',
  PRIMARY KEY (`permission_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_permissions` */

insert  into `t_permissions`(`permission_code`,`parent_permission_code`,`permission_type`,`permission_text`,`permission_url`) values ('01','root',NULL,'模块1',NULL),('0101','01',NULL,'模块1-权限1',''),('0102','01',NULL,'模块1-权限2',''),('0103','01',NULL,'模块1-权限3',''),('0104','01',NULL,'模块1-权限4',''),('02','root',NULL,'模块2',NULL),('0201','02',NULL,'模块2-权限1',''),('0202','02',NULL,'模块2-权限2',NULL);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `flag` int(1) DEFAULT NULL COMMENT '标识符,0:可用;1:禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(50) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`role_name`,`role_desc`,`flag`,`create_time`,`create_by`,`update_time`,`update_by`) values (1,'角色1','desc',NULL,'2020-01-09 17:22:16',NULL,'0000-00-00 00:00:00',NULL),(2,'角色2','desc',NULL,'2020-01-09 17:22:20',NULL,'0000-00-00 00:00:00',NULL);

/*Table structure for table `t_role_permissions` */

DROP TABLE IF EXISTS `t_role_permissions`;

CREATE TABLE `t_role_permissions` (
  `role_id` int(8) DEFAULT NULL,
  `permission_code` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role_permissions` */

insert  into `t_role_permissions`(`role_id`,`permission_code`) values (1,'01'),(1,'0101'),(1,'0102'),(1,'0103'),(1,'0104'),(2,'02'),(2,'02'),(2,'0201'),(2,'0202');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键，自动增长。',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`) values (56,'test','$2a$10$rW.KVdIyRF.ZyQjEIfx.0.im9aSWXjn.9YdG1Oo0zwT.DuXqcvcxq'),(57,'test3','$2a$10$8Ii19mVILG1gwWJaQR3nN.RX0Phef3ay/HeqKJkWUpqoyVt7h5gry');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`user_id`,`role_id`) values (1,56,1),(2,56,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
