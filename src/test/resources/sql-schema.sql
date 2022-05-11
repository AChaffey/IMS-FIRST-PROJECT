DROP TABLE order_items;  
 DROP TABLE orders;
 DROP TABLE items; 
 DROP TABLE customers;
CREATE TABLE IF NOT EXISTS customers (
id int NOT NULL AUTO_INCREMENT,
first_name VARCHAR (50) NOT NULL,
surname VARCHAR (50) NOT NULL,
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS items (
id int NOT NULL AUTO_INCREMENT,
item_name VARCHAR (100),
item_price DOUBLE NOT NULL,
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS orders (
id int NOT NULL AUTO_INCREMENT,
customer_id int,
PRIMARY KEY (id),
FOREIGN KEY (customer_id) REFERENCES customers (id));

CREATE TABLE IF NOT EXISTS order_items(
id int NOT NULL AUTO_INCREMENT,
order_id int NOT NULL,
item_id int NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (order_id) REFERENCES orders (id),
FOREIGN KEY (item_id) REFERENCES items (id)
);