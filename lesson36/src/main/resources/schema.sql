drop table if exists users CASCADE;
create table users
(
    id       serial primary key,
    status   varchar(10),
    password varchar(255),
    username varchar(255) unique
);

drop table if exists roles CASCADE;
create table roles
(
    id   serial primary key,
    name varchar(50) not null
);
drop table if exists user_roles CASCADE;
create table user_roles
(
    user_id bigint not null references users,
    role_id bigint not null references roles,
    unique (user_id, role_id)
);

drop table if exists products;
create table products(
    id serial primary key,
    name varchar(100) not null unique,
    cost decimal(16,2) not null
);