CREATE TABLE pachakari.unit(
	unit_id VARCHAR(5) NOT NULL,
	unit_name VARCHAR(25) NOT NULL,
	PRIMARY KEY (unit_id)	
);

CREATE TABLE IF NOT EXISTS pachakari.item (
  item_id INT NOT NULL AUTO_INCREMENT,
  item_name VARCHAR(50) NOT NULL,
  item_desc VARCHAR(100),
  item_price DOUBLE NULL,
  item_quantity INT,
  item_unit VARCHAR(5),
  created_date DATETIME NOT NULL,
  modified_date DATETIME,
  image_name varchar(30),
  PRIMARY KEY (item_id),
  FOREIGN KEY (item_unit) REFERENCES pachakari.unit(unit_id))
COMMENT = 'This table represents Item entity';

CREATE TABLE  IF NOT EXISTS pachakari.order(
	order_id INT NOT NULL AUTO_INCREMENT,
	order_name VARCHAR(50) NOT NULL, 
	user_id INT NOT NULL,
	order_date DATETIME  NOT NULL,
	PRIMARY KEY (order_id));

CREATE TABLE  IF NOT EXISTS pachakari.order_item(
	order_id INT NOT NULL,
	item_id INT NOT NULL,
	item_purchased_price DOUBLE NOT NULL,
	order_quantity INT NOT NULL
	);

