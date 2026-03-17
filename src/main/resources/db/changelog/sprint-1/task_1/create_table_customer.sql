CREATE TABLE if not exists public.Customer
(
    customer_id   serial PRIMARY KEY,
    customer_name VARCHAR(50),
    last_name     VARCHAR(50),
    country      VARCHAR(50),
    age          INT CHECK (Age >= 0 AND Age <= 99),
    phone        VARCHAR(50)
);
go;