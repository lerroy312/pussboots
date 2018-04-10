SET NAMES 'utf8';
DROP TABLE IF EXISTS bp_instance;
CREATE TABLE `bp_instance` (
  `id` varchar(128)  NOT NULL COMMENT '主键',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `property` longblob DEFAULT NULL COMMENT 'propery',
  PRIMARY KEY (`id`)
) ;
