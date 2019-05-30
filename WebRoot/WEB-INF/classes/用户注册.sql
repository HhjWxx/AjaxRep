-- 删除数据库
DROP DATABASE IF EXISTS ajaxdb;
-- 创建数据库
CREATE DATABASE ajaxdb CHARACTER SET UTF8;
-- 使用数据库
USE ajaxdb;
-- 删除数据表
DROP TABLE IF EXISTS member;
-- 创建数据表
CREATE TABLE member(
	mid VARCHAR(50),
	password VARCHAR(32),
	CONSTRAINT pk_mid PRIMARY KEY(mid)
);
-- 增加测试数据
INSERT INTO member(mid,password) VALUES('admin','5F4DCC3B5AA765D61D8327DEB882CF99');