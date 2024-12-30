create table products
(
    id          bigserial primary key,
    name        varchar(100)     not null,
    description varchar(200),
    price       double precision not null,
    stock       bigint           not null
);

insert into products (name, description, price, stock)
values ('Laptop', 'Laptop gamer, 24 gb ram y 1TB SSD', 2000, 10),
       ('Smartphone', 'Smartphone 6,1 pulgadas', 200, 12),
       ('Audifonos', 'Audifonos inalambricos', 150, 10);