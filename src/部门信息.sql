-- 删除数据库
-- DROP DATABASE IF EXISTS ajaxdb;
-- 创建数据库
-- CREATE DATABASE ajaxdb CHARACTER SET UTF8;
-- 使用数据库
-- USE ajaxdb;
-- 删除数据表
DROP TABLE IF EXISTS dept;
-- 创建数据表
CREATE TABLE dept(
	did  INT AUTO_INCREMENT,
	dname VARCHAR(50),
	loc VARCHAR(50),
	CONSTRAINT pk_did primary key(did)
 );
-- 测试数据
INSERT INTO dept(dname,loc) VALUES('技术部','北京');
INSERT INTO dept(dname,loc) VALUES('人事部','上海');
INSERT INTO dept(dname,loc) VALUES('管理部','广州');
INSERT INTO dept(dname,loc) VALUES('维修部','深圳');

















