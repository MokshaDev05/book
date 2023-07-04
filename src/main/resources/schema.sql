CREATE TABLE employee
(
 employeeName varchar(100) NOT NULL,
  employeeId varchar(11) NOT NULL ,
 employeeAddress varchar(100) DEFAULT NULL,
 employeeEmail varchar(100) DEFAULT NULL,
 PRIMARY KEY (employeeId)
);



CREATE TABLE person
(
 personName varchar(100) NOT NULL,
 personId varchar(11) NOT NULL ,
 personAddress varchar(100) DEFAULT NULL,
 personEmail varchar(100) DEFAULT NULL,
 PRIMARY KEY (personId)
);

CREATE TABLE Book
(
 bookName varchar(100) NOT NULL,
 bookId varchar(11) NOT NULL ,
 bookISBN varchar(100) DEFAULT NULL,
 PRIMARY KEY (bookId)
);


CREATE TABLE address
(
 addressName varchar(100) NOT NULL,
 addressId varchar(11) NOT NULL ,
 addressDetail varchar(100) DEFAULT NULL,
 PRIMARY KEY (addressId)
);

insert into address(addressId, addressName , addressDetail) values('1','Java','Java Detail');


CREATE TABLE Cities
(
 cityName varchar(100) NOT NULL,
 cityId varchar(11) NOT NULL ,
 cityDetail varchar(100) DEFAULT NULL,
 PRIMARY KEY (cityId)
);

insert into cities(cityId, cityName , cityDetail) values('1','Java','Java Detail');

psql -d postgres -U postgres -W

