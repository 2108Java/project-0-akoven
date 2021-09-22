create table customer_checking(customer_ID serial primary key, customer_username varchar(20), checking_acct int);

select *from customer_checking;

insert into customer_checking(customer_username,checking_acct)values('akovenburg',20000);
update customer_checking set checking_acct = (checking_acct + 2000) where customer_username = 'akovenburg';

truncate table customer_checking;

create table customer_savings(customer_ID serial primary key, customer_username varchar(20), savings_acct int);

select *from customer_savings;





create table customer_checkingAndsavings(customer_ID serial primary key, customer_username varchar(20), checking_acct int, savings_acct int);

select *from customer_checkingAndSavings;

update customer_checkingandsavings set checking_acct = (checking_acct - 100),savings_acct = (savings_acct + 100) where customer_username = 'HarryS';


drop table customer_checking_savings;