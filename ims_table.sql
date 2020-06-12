create database if not exists  databaseproject;
use databaseproject;

CREATE TABLE customer (
customer_ID int NOT NULL auto_increment,
name varchar(100) NOT NULL,
address varchar (100) NOT NULL,
password varchar (70) NOT NULL,
primary key(customer_ID)
);

CREATE TABLE item (
item_ID int NOT NULL auto_increment,
item_name varchar(80) NOT NULL,
quantity int NOT NULL,
item_price dec (7,2) NOT NULL,
primary key(item_ID)
);

CREATE TABLE orders (
orders_ID int NOT NULL auto_increment,
customer_ID int NOT NULL,
placed date,
total_order dec(7,2),
primary key(orders_ID),
foreign key(customer_ID) REFERENCES customer (customer_ID)
);

CREATE TABLE orderline (
line_ID int NOT NULL auto_increment,
orders_ID int NOT NULL,
item_ID int NOT NULL,
quantity_ordered int,
primary key (line_ID),
foreign key(orders_ID) REFERENCES orders (orders_ID),
foreign key(item_ID) REFERENCES item (item_ID)
);