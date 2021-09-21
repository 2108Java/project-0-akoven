create table Customer_ID(customer_username varchar(10),customer_passcode varchar(10),isApproved boolean not null, user_id serial primary key);
insert into Customer_ID(customer_username,customer_passcode,isApproved) values ('akovenburg','abc123',false);

select *from Customer_ID;
alter table customer_id add isApproved = false;
alter table customer_id add customer_id serial primary key; 

drop table Customer_ID;
truncate Customer_ID;
select *from customer_id where isApproved = false and customer_username = 'AnnieO';

delete from customer_id where customer_username = 'sfsdfs';
delete from customer_id where customer_username = 'dsggdd';