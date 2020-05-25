CREATE TABLE enterprise (
  enterprise_id int NOT NULL AUTO_INCREMENT,
  enterprise_name varchar(50) NOT NULL,
  PRIMARY KEY (enterprise_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE unit (
  enterprise_id int NOT NULL,
  unit_id int(11) NOT NULL  AUTO_INCREMENT,
  unit_name varchar(25) NOT NULL,
  PRIMARY KEY (unit_id),
  CONSTRAINT unit_fk_1 FOREIGN KEY (enterprise_id) REFERENCES enterprise (enterprise_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE size (
  enterprise_id int NOT NULL,	
  size_id int NOT NULL  AUTO_INCREMENT,
  size_code varchar(5) NOT NULL,
  size_name varchar(25) NOT NULL,
  PRIMARY KEY (size_id),
  CONSTRAINT size_fk_1 FOREIGN KEY (enterprise_id) REFERENCES enterprise (enterprise_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE color (
  enterprise_id int NOT NULL,	
  color_id int NOT NULL  AUTO_INCREMENT,
  color_code varchar(20) NOT NULL,
  color_name varchar(50) NOT NULL,
  PRIMARY KEY (color_id),
  CONSTRAINT color_fk_1 FOREIGN KEY (enterprise_id) REFERENCES enterprise (enterprise_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE size_color (
  enterprise_id int NOT NULL,	
  size_id int NOT NULL,
  color_id int NOT NULL,
  PRIMARY KEY (size_id,color_id),
  CONSTRAINT size_color_fk_1 FOREIGN KEY (enterprise_id) REFERENCES enterprise (enterprise_id),
  CONSTRAINT size_color_fk_2 FOREIGN KEY (size_id) REFERENCES size (size_id),
  CONSTRAINT size_color_fk_3 FOREIGN KEY (color_id) REFERENCES color (color_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE item (
  enterprise_id int NOT NULL,
  item_id int(11) NOT NULL AUTO_INCREMENT,
  item_name varchar(50) NOT NULL,
  item_desc varchar(100) DEFAULT NULL,
  item_price double DEFAULT NULL,
  item_quantity int(11) DEFAULT NULL,
  item_unit int(11) DEFAULT NULL,
  created_date datetime NOT NULL,
  modified_date datetime DEFAULT NULL,
  image_name varchar(30) DEFAULT NULL,
  created_user varchar(50) NOT NULL,
  modified_user varchar(50) DEFAULT NULL,
  PRIMARY KEY (item_id),
  CONSTRAINT item_ibfk_1 FOREIGN KEY (item_unit) REFERENCES unit (unit_id),
  CONSTRAINT item_ibfk_2 FOREIGN KEY (enterprise_id) REFERENCES enterprise (enterprise_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table represents Item entity';

CREATE TABLE orders(
  enterprise_id int NOT NULL,	
  order_id int(11) NOT NULL AUTO_INCREMENT,
  order_name varchar(50) NOT NULL,
  order_date datetime NOT NULL,
  delivered int(11) DEFAULT NULL,
  total_quantity int(11) DEFAULT NULL,
  total_amount varchar(50) DEFAULT NULL,
  user_id varchar(50) DEFAULT NULL,
  PRIMARY KEY (order_id),
  CONSTRAINT order_fk_1 FOREIGN KEY (enterprise_id) REFERENCES enterprise (enterprise_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE order_item (
  enterprise_id int NOT NULL,	
  order_id int(11) NOT NULL,
  item_id int(11) NOT NULL,
  item_purchased_price double NOT NULL,
  order_quantity int(11) NOT NULL,
  item_name varchar(50) DEFAULT NULL,
  item_image varchar(50) DEFAULT NULL,
  CONSTRAINT oritm_fk_1 FOREIGN KEY (order_id) REFERENCES orders (order_id),
  CONSTRAINT oritm_fk_2 FOREIGN KEY (enterprise_id) REFERENCES enterprise (enterprise_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

