
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '��Ʒ����',
  `price` float(10,1) NOT NULL COMMENT '��Ʒ����',
  `detail` text COMMENT '��Ʒ����',
  `pic` varchar(64) DEFAULT NULL COMMENT '��ƷͼƬ',
  `createtime` datetime NOT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) NOT NULL COMMENT '����id',
  `items_id` int(11) NOT NULL COMMENT '��Ʒid',
  `items_num` int(11) DEFAULT NULL COMMENT '��Ʒ��������',
  PRIMARY KEY (`id`),
  KEY `FK_orderdetail_1` (`orders_id`),
  KEY `FK_orderdetail_2` (`items_id`),
  CONSTRAINT `FK_orderdetail_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_orderdetail_2` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '�µ��û�id',
  `number` varchar(32) NOT NULL COMMENT '������',
  `createtime` datetime NOT NULL COMMENT '��������ʱ��',
  `note` varchar(100) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`id`),
  KEY `FK_orders_1` (`user_id`),
  CONSTRAINT `FK_orders_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '�û�����',
  `birthday` date DEFAULT NULL COMMENT '����',
  `sex` char(1) DEFAULT NULL COMMENT '�Ա�',
  `address` varchar(256) DEFAULT NULL COMMENT '��ַ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

