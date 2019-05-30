-- 删除数据库
-- DROP DATABASE IF EXISTS ajaxdb;
-- 创建数据库
-- CREATE DATABASE ajaxdb CHARACTER SET UTF8;
-- 使用数据库
-- USE ajaxdb;
-- 删除数据表
DROP TABLE IF EXISTS menu;
-- 创建数据表
CREATE TABLE menu(
	mid  INT AUTO_INCREMENT,
	title VARCHAR(200),
	fmid INT,
	CONSTRAINT pk_mid2 PRIMARY KEY(mid)	
 );
-- 增加外键信息
alter table menu add constraint FK_ID foreign key(fmid) REFERENCES menu(mid) ON DELETE CASCADE;
-- 增加测试数据 一级菜单
INSERT INTO menu(title) VALUES('居家生活');
INSERT INTO menu(title) VALUES('电脑办公');
INSERT INTO menu(title) VALUES('食品饮料');
INSERT INTO menu(title) VALUES('首饰');
INSERT INTO menu(title) VALUES('图书');
INSERT INTO menu(title) VALUES('箱包服饰');
INSERT INTO menu(title) VALUES('生鲜果蔬');

-- 增加测试数据 二级菜单
INSERT INTO menu(title,fmid) VALUES('锅',1);
INSERT INTO menu(title,fmid) VALUES('碗',1);
INSERT INTO menu(title,fmid) VALUES('瓢',1);
INSERT INTO menu(title,fmid) VALUES('盆',1);
INSERT INTO menu(title,fmid) VALUES('鼠标',2);
INSERT INTO menu(title,fmid) VALUES('键盘',2);
INSERT INTO menu(title,fmid) VALUES('机箱',2);
INSERT INTO menu(title,fmid) VALUES('配件',2);
INSERT INTO menu(title,fmid) VALUES('粮油',3);
INSERT INTO menu(title,fmid) VALUES('零食',3);
INSERT INTO menu(title,fmid) VALUES('饮料',3);
INSERT INTO menu(title,fmid) VALUES('白饭',3);
INSERT INTO menu(title,fmid) VALUES('项链',3);
INSERT INTO menu(title,fmid) VALUES('耳环',4);
INSERT INTO menu(title,fmid) VALUES('鼻环',4);
INSERT INTO menu(title,fmid) VALUES('眼镜',4);
INSERT INTO menu(title,fmid) VALUES('手环',4);
INSERT INTO menu(title,fmid) VALUES('java',5);
INSERT INTO menu(title,fmid) VALUES('android',5);
INSERT INTO menu(title,fmid) VALUES('php',5);
INSERT INTO menu(title,fmid) VALUES('python',5);
INSERT INTO menu(title,fmid) VALUES('行李箱',6);
INSERT INTO menu(title,fmid) VALUES('衣服',6);
INSERT INTO menu(title,fmid) VALUES('裤子',6);
INSERT INTO menu(title,fmid) VALUES('鞋子',6);
INSERT INTO menu(title,fmid) VALUES('菜',7);
INSERT INTO menu(title,fmid) VALUES('水果',7);

-- 增加测试数据 二级菜单
INSERT INTO menu(title,fmid) VALUES('大锅',8);
INSERT INTO menu(title,fmid) VALUES('中碗',8);
INSERT INTO menu(title,fmid) VALUES('小瓢',8);
INSERT INTO menu(title,fmid) VALUES('大碗',9);
INSERT INTO menu(title,fmid) VALUES('中碗',9);
INSERT INTO menu(title,fmid) VALUES('小碗',9);
INSERT INTO menu(title,fmid) VALUES('大瓢',10);
INSERT INTO menu(title,fmid) VALUES('中瓢',10);
INSERT INTO menu(title,fmid) VALUES('小瓢',10);
INSERT INTO menu(title,fmid) VALUES('大盆',11);
INSERT INTO menu(title,fmid) VALUES('中盆',11);
INSERT INTO menu(title,fmid) VALUES('小盆',11);
INSERT INTO menu(title,fmid) VALUES('雷蛇鼠标',12);
INSERT INTO menu(title,fmid) VALUES('赛睿鼠标',12);
INSERT INTO menu(title,fmid) VALUES('机械鼠标',12);
INSERT INTO menu(title,fmid) VALUES('雷蛇键盘',13);
INSERT INTO menu(title,fmid) VALUES('赛睿键盘',13);
INSERT INTO menu(title,fmid) VALUES('机械键盘',13);
INSERT INTO menu(title,fmid) VALUES('大机箱',14);
INSERT INTO menu(title,fmid) VALUES('中机箱',14);
INSERT INTO menu(title,fmid) VALUES('小机箱',14);
INSERT INTO menu(title,fmid) VALUES('配件-1',15);
INSERT INTO menu(title,fmid) VALUES('配件-2',15);
INSERT INTO menu(title,fmid) VALUES('配件-3',15);
INSERT INTO menu(title,fmid) VALUES('粮油-1',16);
INSERT INTO menu(title,fmid) VALUES('粮油-2',16);
INSERT INTO menu(title,fmid) VALUES('粮油-3',16);

















