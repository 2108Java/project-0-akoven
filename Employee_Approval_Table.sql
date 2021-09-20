create table Employee_database(customer_id serial primary key,customer_username varchar(20) not null,customer_passcode varchar(10) not null,isApproved boolean not null);
insert into Employee_database(customer_username,customer_passcode, isapproved values (select customer_username from customer_id),(select customer_passcode from customer_id),false);



select *from Employee_database;


drop table Employee_database; 