#customer
use customer;
describe customer;

INSERT INTO customer (customer_name, customer_lastname, address, password, email) VALUES ('Akwua', 'Adu', '64 Zoo Lane',  '90dayfiancay', 'bev@mail.co.uk');
INSERT INTO customer (customer_name,customer_lastname, address, password, email) VALUES ('Tonii', 'Marelli', '56 Antlanta Georgia', 'squirrelfriend2012', 'tony***@gmail.com');
INSERT INTO customer (customer_name,customer_lastname, address, password, email) VALUES ('Emilia', 'Adu', '5 Kaabroni Way', 'passmetherote', 'yaw@mail.com');

ALTER TABLE customer ADD email varchar(80);
ALTER TABLE customer ADD customer_lastname varchar(80);
ALTER TABLE customer DROP name;

UPDATE customer set customer_lastname= 'Marellz' where customer_ID=2;
UPDATE customer set password='passmetheremote' where customer_name='Emilia';

SELECT * from customer;
SELECT DISTINCT password from customer;

DELETE from customer where email='tony***@gmail.com';

DROP TABLE customer;

#item
use item;
describe item;

INSERT INTO item (item_name, quantity, item_price) VALUES ('Final Fantasy 7 Remix', 1 , 59.99);
INSERT INTO item (item_name, quantity, item_price) VALUES ('Super Sky Scraper Stiletto Heels', 2, 38.75);
INSERT INTO item (item_name, quantity, item_price) VALUES ('BLM T-Shirt', 10, 22.56);

UPDATE item set quantity= 4 where item_price = 22.56;
UPDATE item set item_price= 98.27 where item_name = 'Super Sky Scraper Stiletto Heels';

SELECT item_name, item_price from item;
SELECT * from item;
SELECT * from item where item_name like 's%';

DELETE from item where quantitiy =2;

DROP TABLE items;

#orders
use orders;
describe orders;

INSERT INTO orders (customer_ID, order_date, total_order) VALUES (1, 2020-05-03, 98.27);
INSERT INTO orders (customer_ID, order_date, total_order) VALUES (2, 2020-02-22, 82.55);
INSERT INTO orders (customer_ID, order_date, total_order) VALUES (3, 2020-06-03, 38.75);

ALTER table orders DROP order_date;
ALTER TABLE orders ADD order_date int(80);

SELECT * from orders;

DELETE from orders where total_order=98.27;

DROP TABLE orders;

#orderline
use orderline;
describe orderline;

INSERT INTO orderline (orders_ID, item_ID, quantity_ordered) VALUES (2, 2,2);
INSERT INTO orderline (orders_ID, item_ID, quantity_ordered) VALUES (1,1,3);
INSERT INTO orderline (orders_ID, item_ID, quantity_ordered) VALUES (3,3,10);

UPDATE orderline set quantity_ordered = 1 where orders_ID=1;

DELETE from orderline where orders_ID=3;

SELECT * from orderline;

DROP TABLE orderline;