use imstest;
select * from customers;
select * from items;
select * from order_items;
select * from orders;

CREATE  TABLE customers(
  c_id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(40) DEFAULT NULL,
    surname VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`c_id`)
);
create table items(
item_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
name varchar(20) DEFAULT NULL,
price  decimal(12, 2) NOT NULL
);

create table orders(
order_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
c_id int NOT NULL,
total_cost decimal(55,2),
 FOREIGN KEY (C_id) REFERENCES CUSTOMERS(C_id)
);

CREATE TABLE order_items (
order_items_id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT NOT NULL,
item_id INT NOT NULL,
quantity INT NOT null,
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (item_id) REFERENCES items(item_id)
  );