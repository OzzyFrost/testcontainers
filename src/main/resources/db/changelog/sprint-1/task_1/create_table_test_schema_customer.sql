CREATE TABLE if not exists test_schema.Customer2
(
    CustomerID   int PRIMARY KEY,
    CustomerName VARCHAR(50),
    LastName     VARCHAR(50),
    Country      VARCHAR(50),
    Age          INT CHECK (Age >= 0 AND Age <= 99),
    Phone        int
);
go;