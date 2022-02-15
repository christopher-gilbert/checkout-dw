--liquibase formatted sql

--changeset chris:1
create table item (
  id varchar(50) primary key,
  sku varchar(10) not null,
  description varchar(255),
  unit_price int
);	
-- rollback drop table item;

--changeset chris:2
create table customer (
  id varchar(50) primary key,
  first_name varchar(255),
  last_name varchar(255)

);	
-- rollback drop table customer;

--changeset chris:3
create table basket (
  id varchar(50) primary key,
  customer_id varchar(50) not null,
  total_price int,
  constraint customer_id_fk FOREIGN KEY (customer_id) references customer (id) on delete cascade
);	
-- rollback drop table basket;


