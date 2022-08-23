DROP DATABASE IF EXISTS library;
CREATE DATABASE library;
USE library;

CREATE TABLE customers(
customerID INT NOT NULL UNIQUE AUTO_INCREMENT,
customerFN varchar(15) NOT NULL,
customerSN varchar(15) NOT NULL,
address varchar(50) NOT NULL,
postcode varchar(8) NOT NULL,
PRIMARY KEY(customerID));

CREATE TABLE books(
bookID INT NOT NULL UNIQUE AUTO_INCREMENT,
author varchar(25) NOT NULL,
publishDate date NOT NULL,
PRIMARY KEY(bookID));

CREATE TABLE staff(
staffID INT NOT NULL UNIQUE AUTO_INCREMENT,
staffFN varchar(15) NOT NULL,
staffSN varchar(15) NOT NULL,
address varchar(15) NOT NULL,
postcode varchar(8) NOT NULL,
PRIMARY KEY(staffID));

CREATE TABLE orders(
orderID INT NOT NULL UNIQUE AUTO_INCREMENT,
customerID INT NOT NULL,
bookID INT NOT NULL,
borrowDate date NOT NULL,
returnDate date NOT NULL,
staffID INT NOT NULL,
PRIMARY KEY(orderID),
FOREIGN KEY(customerID) REFERENCES customers(customerID),
FOREIGN KEY(bookID) REFERENCES books(bookID),
FOREIGN KEY(staffID) REFERENCES staff(staffID));