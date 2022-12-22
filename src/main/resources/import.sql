drop table buyers_products if exists;
drop table PRODUCTS if exists;
drop table BUYERS if exists;

create table IF NOT EXISTS PRODUCTS (id bigserial, name varchar(255), cost double);
insert INTO PRODUCTS (name, cost) values ('product1', 100.1), ('product2', 200.1),('product3', 300.1),('product4', 400.4),('product5', 500.5);


create table IF NOT EXISTS BUYERS (id bigserial, name varchar(255));
insert INTO BUYERS (name) values ('buyer1'), ('buyer2'),('buyer3');


create table IF NOT EXISTS buyers_products (buyer_id bigint, product_id bigint);
insert into buyers_products (buyer_id, product_id) VALUES (1,1),(1,2),(2,4),(3,2),(3,3);
