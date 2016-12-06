/*-------------------------------------------------
Marcel Poblet
CSCI 3410 Information Management
Dr. Yan
17, October 2016
*/

-- Create Database
create database IDEALHOME;

/*
After you create IdealHome Database, ensure you double 
click on the schema and then select the rest of the 
script and it will all run in the order provided.
*/

-- Insert Branch Table
create table IDEALHOME.branch
(branchNo 	varchar(10) not null,
street 		varchar(30),
city		varchar(20),
postcode	varchar(20),

primary key(branchNo)
);

-- Insert Staff Table
create table IDEALHOME.staff
(staffNo	varchar(10) not null,
fName		varchar(15) not null,
lName		varchar(15) not null,
position 	varchar(30),
sex			char,
DOB			varchar(10),
salary		decimal(10,2) not null,
branchNo	varchar(10) ,

primary key(staffNo),
foreign key(branchNo) references branch(branchNo)
on delete set null on update cascade
);

-- Insert PrivateOwner Table
create table IDEALHOME.privateOwner
(ownerNo		varchar(10) not null,
fName			varchar(30),
lName			varchar(30),
address			varchar(55),
telNo			varchar(20),
eMail			varchar(30),
password		varchar(30) default'********',

primary key(ownerNo),
unique(telNo,eMail)
);

-- Insert PropertyForRent Table
create table IDEALHOME.propertyForRent
(propertyNo		varchar(10) not null,
street			varchar(30),
city			varchar(20),
postcode		varchar(20),
propertyType	varchar(10),
rooms			int,
rent			int,
ownerNo			varchar(10),
staffNo			varchar(10),
branchNo		varchar(10),

primary key(propertyNo),
foreign key(staffNo) references staff(staffNo)
on delete set null  on update cascade,
foreign key(branchNo) references branch(branchNo)
on delete set null  on update cascade,
foreign key(ownerNo) references privateOwner(ownerNo)
on delete set null  on update cascade
);

-- Insert Client Table
create table IDEALHOME.client
(clientNo		varchar(10) not null,
fName			varchar(15),
lName			varchar(15),
telNo			varchar(20),
prefType		varchar(10),
maxRent			int,
eMail			varchar(30),

primary key(clientNo),
unique(telNo,eMail)
);

-- Insert Viewing Table
create table IDEALHOME.viewing
(clientNo		varchar(10),
propertyNo		varchar(10),
viewDate		varchar(10),
comment			varchar(30) default'',

foreign key(clientNo) references client(clientNo)
on delete set null  on update cascade,
foreign key(propertyNo) references propertyforrent(propertyNo)
on delete set null  on update cascade
);

-- Insert Registration Table
create table IDEALHOME.registration
(clientNo		varchar(10),
branchNo		varchar(10),
staffNo			varchar(10),
dateJoined		varchar(10),

foreign key(clientNo) references client(clientNo)
on delete set null  on update cascade,
foreign key(branchNo) references branch(branchNo)
on delete set null  on update cascade
);

-- Insert data into Branch Table
insert into idealhome.branch
values('B005', '22 Deer Rd', 'London', 'SW1 4EH'),
	  ('B007', '16 Argyll St', 'Aberdeen', 'AB2 3SU'),
      ('B003', '163 Main St', 'Glassgow', 'G11 9QX'),
      ('B004', '32 Manse Rd', 'Bristol', 'BS99 1NZ'),
      ('B002', '56 Clover Dr', 'London', 'NW10 6EU');

-- Insert data into Staff Table
insert into idealhome.staff
values('SL21', 'John', 'White', 'Manager', 'M', '1-Oct-45', 30000, 'B005'),
	  ('SG37', 'Ann', 'Beech', 'Assistant', 'F', '10-Nov-60', 12000, 'B003'),
      ('SG14', 'David', 'Ford', 'Supervisor', 'M', '24-Mar-58', 18000, 'B003'),
      ('SA9', 'Mary', 'Howe', 'Assistant', 'F', '19-Feb-70', 9000, 'B007'),
      ('Sg5', 'Susan', 'Brand', 'Manager', 'F', '3-Jun-40', 24000, 'B003'),
      ('SL41', 'Julie', 'Lee', 'Assistant', 'F', '13-Jun-65', 9000, 'B005');
 
 -- Insert data into PrivateOwner Table
insert into idealhome.privateowner
values('CO46', 'Joe', 'Keogh', '2 Fergus Dr, Aberdeen AB2 7SX', '01224-861212', 'jkeogh@lhh.com', null),
	  ('CO87', 'Carol', 'Farrel', '6 Achray St, Glasgow G32 9DX', '0141-357-7419', 'cfarrel@gmail.com', null),
      ('CO40', 'Tina', 'Murphy', '63 Well St, Glasgow G42', '0141-943-1728', 'tinam@hotmail.com', null),
      ('CO93', 'Tony', 'Shaw', '12 Park Pl, Glasgow G4 0QR', '0141-225-7025', 'tony.shaw@ark.com', null);

-- Insert data into PropertyForRent Table
insert into idealhome.propertyforrent
values('PA14', '16 Holhead', 'Aberdeen', 'AB7 5SU', 'House', 6, 650, 'CO46', 'SA9', 'B007'),
	  ('PL94', '6 Argyll St', 'London', 'NW2', 'Flat', 4, 400, 'CO87', 'SL41', 'B005'),
      ('PG4', '6 Lawrence St', 'Glasgow', 'G11 9QX', 'Flat', 3, 350, 'CO40', null, 'B003'),
      ('PG36', '2 Manor Rd', 'Glasgow', 'G32 4QX', 'Flat', 3, 375, 'CO93', 'SG37', 'B003'),
      ('PG21', '18 Dale Rd', 'Glasgow', 'G12', 'House', 5, 600, 'CO87', 'SG37', 'B003'),
      ('PG16', '5 Novar Dr', 'Glasgow', 'G12 9AX', 'Flat', 4, 450, 'CO93', 'SG14', 'B003');

-- Insert data into Client Table
insert into idealhome.client
values('CR76', 'John', 'Kay', '0207-774-5632', 'Flat', 425, 'john.kay@gmail.com'),
	  ('CR56', 'Aline', 'Stewart', '0141-848-1825', 'Flat', 350, 'astewart@hotmail.com'),
	  ('CR74', 'Mike', 'Ritchie', '01475-392178', 'House', 750, 'mritchie01@yahoo.co.uk'),
	  ('CR62', 'Mary', 'Tregear', '01224-196720', 'Flat', 600, 'maryt@hotmail.co.uk');

-- Insert data into Viewing Table      
insert into idealhome.viewing
values('CR56', 'PA14', '24-May-13', 'too small'),
	  ('CR56', 'PG4', '20-Apr-13', 'too remote'),
      ('CR56', 'PG4', '26-May-13', null),
      ('CR62', 'PA14', '14-May-13', 'no dining room'),
      ('CR56', 'PG36', '28-Apr-13', null);

-- Insert data into Registration Table
insert into idealhome.registration
values('CR76', 'B005', 'SL41', '2-Jan-13'),
	  ('CR56', 'B003', 'SG37', '11-Apr-12'),
      ('CR74', 'B003', 'SG37', '16-Nov-11'),
      ('CR62', 'B007', 'SA9', '7-Mar-12');

-- Part 2
-- Question 1
select s.fName, s.lName
from staff as s, branch as b
where b.city = 'London' and s.branchNo = b.branchNo;

-- Qeustion 2
select p.propertyNo, p.street, p.city, p.postcode, p.propertyType, p.rooms, p.rent
from propertyforrent as p, privateowner as o
where o.fName = 'Carol' and o.lName = 'Farrel' and p.ownerNo = o.ownerNo;

-- Question 3
select c.fName, c.lName
from client as c, viewing as v
where v.propertyNo = 'PA14' and c.clientNo = v.clientNo;