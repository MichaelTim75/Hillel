create schema if not exists hillel;

create table if not exists hillel.products
(
    id   int            not null,
    name text           not null,
    cost decimal(16, 2) not null,
    constraint products_pk primary key (id)
);

insert into hillel.products(id, name, cost) VALUES (1,'bread',1.2);
insert into hillel.products(id, name, cost) VALUES (2,'milk',2.8);
insert into hillel.products(id, name, cost) VALUES (3,'sugar',1.7);
insert into hillel.products(id, name, cost) VALUES (4,'salt',0.5);
insert into hillel.products(id, name, cost) VALUES (5,'meat',20);

create table if not exists hillel.orders
(
    id   serial not null,
    date date   not null,
    constraint orders_pk primary key (id)
);

create table if not exists hillel.orders_products
(
    order_id   int not null,
    product_id int not null,
    cnt int not null,
    constraint orders_products_pk primary key (order_id, product_id),
    constraint orders_products__orders__fk foreign key (order_id) references hillel.orders (id),
    constraint orders_products__products__fk foreign key (product_id) references hillel.products (id)
);
