--
--    Copyright 2010-2022 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       https://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

/*
Navicat MySQL Data Transfer

Source Server         : UCloud-117.50.177.58-3306
Source Server Version : 50724
Source Host           : 117.50.177.58:3306
Source Database       : pig

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2022-12-15 11:33:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `component` varchar(64) DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序值',
  `keep_alive` char(1) DEFAULT '0' COMMENT '0-开启，1- 关闭',
  `type` char(1) DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '逻辑删除标记(0--正常 1--删除)',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1000', '权限管理', null, '/admin', '-1', 'icon-quanxianguanli', null, '0', '0', '0', '2018-09-28 08:29:53', '2020-03-11 23:58:18', '0');
INSERT INTO `sys_menu` VALUES ('1100', '用户管理', null, '/admin/user/index', '1000', 'icon-yonghuguanli', null, '1', '0', '0', '2017-11-02 22:24:37', '2020-03-12 00:12:57', '0');
INSERT INTO `sys_menu` VALUES ('1101', '用户新增', 'sys_user_add', null, '1100', null, null, '1', '0', '1', '2017-11-08 09:52:09', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1102', '用户修改', 'sys_user_edit', null, '1100', null, null, '1', '0', '1', '2017-11-08 09:52:48', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1103', '用户删除', 'sys_user_del', null, '1100', null, null, '1', '0', '1', '2017-11-08 09:54:01', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1200', '菜单管理', null, '/admin/menu/index', '1000', 'icon-caidanguanli', null, '2', '0', '0', '2017-11-08 09:57:27', '2020-03-12 00:13:52', '0');
INSERT INTO `sys_menu` VALUES ('1201', '菜单新增', 'sys_menu_add', null, '1200', null, null, '1', '0', '1', '2017-11-08 10:15:53', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1202', '菜单修改', 'sys_menu_edit', null, '1200', null, null, '1', '0', '1', '2017-11-08 10:16:23', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1203', '菜单删除', 'sys_menu_del', null, '1200', null, null, '1', '0', '1', '2017-11-08 10:16:43', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1300', '角色管理', null, '/admin/role/index', '1000', 'icon-jiaoseguanli', null, '3', '0', '0', '2017-11-08 10:13:37', '2020-03-12 00:15:40', '0');
INSERT INTO `sys_menu` VALUES ('1301', '角色新增', 'sys_role_add', null, '1300', null, null, '1', '0', '1', '2017-11-08 10:14:18', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1302', '角色修改', 'sys_role_edit', null, '1300', null, null, '1', '0', '1', '2017-11-08 10:14:41', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1303', '角色删除', 'sys_role_del', null, '1300', null, null, '1', '0', '1', '2017-11-08 10:14:59', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1304', '分配权限', 'sys_role_perm', null, '1300', null, null, '1', '0', '1', '2018-04-20 07:22:55', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1400', '部门管理', null, '/admin/dept/index', '1000', 'icon-web-icon-', null, '4', '0', '0', '2018-01-20 13:17:19', '2020-03-12 00:15:44', '0');
INSERT INTO `sys_menu` VALUES ('1401', '部门新增', 'sys_dept_add', null, '1400', null, null, '1', '0', '1', '2018-01-20 14:56:16', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1402', '部门修改', 'sys_dept_edit', null, '1400', null, null, '1', '0', '1', '2018-01-20 14:56:59', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('1403', '部门删除', 'sys_dept_del', null, '1400', null, null, '1', '0', '1', '2018-01-20 14:57:28', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('2000', '系统管理', null, '/setting', '-1', 'icon-xitongguanli', null, '1', '0', '0', '2017-11-07 20:56:00', '2020-03-11 23:52:53', '0');
INSERT INTO `sys_menu` VALUES ('2100', '日志管理', null, '/admin/log/index', '2000', 'icon-rizhiguanli', null, '5', '0', '0', '2017-11-20 14:06:22', '2020-03-12 00:15:49', '0');
INSERT INTO `sys_menu` VALUES ('2101', '日志删除', 'sys_log_del', null, '2100', null, null, '1', '0', '1', '2017-11-20 20:37:37', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('2200', '字典管理', null, '/admin/dict/index', '2000', 'icon-navicon-zdgl', null, '6', '0', '0', '2017-11-29 11:30:52', '2020-03-12 00:15:58', '0');
INSERT INTO `sys_menu` VALUES ('2201', '字典删除', 'sys_dict_del', null, '2200', null, null, '1', '0', '1', '2017-11-29 11:30:11', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('2202', '字典新增', 'sys_dict_add', null, '2200', null, null, '1', '0', '1', '2018-05-11 22:34:55', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('2203', '字典修改', 'sys_dict_edit', null, '2200', null, null, '1', '0', '1', '2018-05-11 22:36:03', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('2300', '令牌管理', null, '/admin/token/index', '2000', 'icon-denglvlingpai', null, '11', '0', '0', '2018-09-04 05:58:41', '2020-03-13 12:57:25', '0');
INSERT INTO `sys_menu` VALUES ('2301', '令牌删除', 'sys_token_del', null, '2300', null, null, '1', '0', '1', '2018-09-04 05:59:50', '2020-03-13 12:57:34', '0');
INSERT INTO `sys_menu` VALUES ('2400', '终端管理', '', '/admin/client/index', '2000', 'icon-shouji', null, '9', '0', '0', '2018-01-20 13:17:19', '2020-03-12 00:15:54', '0');
INSERT INTO `sys_menu` VALUES ('2401', '客户端新增', 'sys_client_add', null, '2400', '1', null, '1', '0', '1', '2018-05-15 21:35:18', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('2402', '客户端修改', 'sys_client_edit', null, '2400', null, null, '1', '0', '1', '2018-05-15 21:37:06', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('2403', '客户端删除', 'sys_client_del', null, '2400', null, null, '1', '0', '1', '2018-05-15 21:39:16', '2021-05-25 06:48:34', '0');
INSERT INTO `sys_menu` VALUES ('2500', '服务监控', null, 'http://localhost:5001', '2000', 'icon-server', null, '10', '0', '0', '2018-06-26 10:50:32', '2019-02-01 20:41:30', '0');
INSERT INTO `sys_menu` VALUES ('3000', '开发平台', null, '/gen', '-1', 'icon-shejiyukaifa-', null, '3', '1', '0', '2020-03-11 22:15:40', '2020-03-11 23:52:54', '0');
INSERT INTO `sys_menu` VALUES ('3100', '数据源管理', null, '/gen/datasource', '3000', 'icon-mysql', null, '1', '1', '0', '2020-03-11 22:17:05', '2020-03-12 00:16:09', '0');
INSERT INTO `sys_menu` VALUES ('3200', '代码生成', null, '/gen/index', '3000', 'icon-weibiaoti46', null, '2', '0', '0', '2020-03-11 22:23:42', '2020-03-12 00:16:14', '0');
INSERT INTO `sys_menu` VALUES ('3300', '表单管理', null, '/gen/form', '3000', 'icon-record', null, '3', '1', '0', '2020-03-11 22:19:32', '2020-03-12 00:16:18', '0');
INSERT INTO `sys_menu` VALUES ('3301', '表单新增', 'gen_form_add', null, '3300', '', null, '0', '0', '1', '2018-05-15 21:35:18', '2020-03-11 22:39:08', '0');
INSERT INTO `sys_menu` VALUES ('3302', '表单修改', 'gen_form_edit', null, '3300', '', null, '1', '0', '1', '2018-05-15 21:35:18', '2020-03-11 22:39:09', '0');
INSERT INTO `sys_menu` VALUES ('3303', '表单删除', 'gen_form_del', null, '3300', '', null, '2', '0', '1', '2018-05-15 21:35:18', '2020-03-11 22:39:11', '0');
INSERT INTO `sys_menu` VALUES ('3400', '表单设计', null, '/gen/design', '3000', 'icon-biaodanbiaoqian', null, '4', '1', '0', '2020-03-11 22:18:05', '2020-03-12 00:16:25', '0');
INSERT INTO `sys_menu` VALUES ('9999', '系统官网', null, 'https://pig4cloud.com/#/', '-1', 'icon-guanwangfangwen', null, '9', '0', '0', '2019-01-17 17:05:19', '2020-03-11 23:52:57', '0');
