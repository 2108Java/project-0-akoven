create table Customer_ID(customer_username varchar(20),customer_passcode varchar(10));
insert into Customer_ID(customer_username,customer_passcode) values ('akovenburg','abc123');

select *from Customer_ID;

drop table Customer_ID;
truncate Customer_ID;

delete from customer_id where customer_username = 'sfsdfs';
delete from customer_id where customer_username = 'dsggdd';