CREATE DATABASE 'vendordb';
USE dvendordb;

create table vendordata (
 
	vendor_id  int(1) NOT NULL AUTO_INCREMENT,
                    vendor_name varchar(120) NOT NULL,
                    bank_accno int NOT NULL,
                    bank_name varchar(120) NOT NULL,
                    address varchar(200) NOT NULL,
                    city varchar(30) NOT NULL,
                    country varchar(120) NOT NULL,
                    zipcode int NOT NULL,
	PRIMARY KEY (vendor_id)
);
