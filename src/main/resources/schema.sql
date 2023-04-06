DROP TABLE IF EXISTS PRODUCT;
create table PRODUCT (
    id NUMERIC NOT NULL PRIMARY KEY,
    name TEXT NOT NULL
);

--Bad practice
insert into PRODUCT(id, name) values(1, 'test1');
insert into PRODUCT(id, name) values(2, 'test2');
insert into PRODUCT(id, name) values(3, 'test3');