-- drop table buyers_products if exists;
drop table ORDERS if exists;
drop table PRODUCTS if exists;
drop table BUYERS if exists;


create table IF NOT EXISTS PRODUCTS (id bigserial, name varchar(255), cost double);
insert INTO PRODUCTS (name, cost) values ('Noski', 100.1), ('Jeans', 200.1),('T-shirt', 300.1),('Iphone', 400.4),('Notebook', 500.5);


create table IF NOT EXISTS BUYERS (id bigserial, name varchar(255));
insert INTO BUYERS (name) values ('Boris'), ('Anna'),('Dime');

create table IF NOT EXISTS ORDERS (id bigserial, cost double, buyerId bigint, productId bigint);
--

-- create table IF NOT EXISTS buyers_products (buyer_id bigint, product_id bigint);
-- insert into buyers_products (buyer_id, product_id) VALUES (1,1),(1,2),(2,4),(3,2),(3,3);
