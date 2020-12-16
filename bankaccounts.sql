
drop schema if exists bank cascade;
create schema bank;

set schema 'bank';

insert into "Customer" ("id", "username", "password") values( '505', 'Rammi', '505864' );

select * from "Customer" where "id" = 


INSERT INTO "BK_ACCOUNTS"("ACC_TYPE_ID", "ACC_OWNER", "ACC_BALANCE") VALUES(1, 523, 10000);

UPDATE "BK_ACCOUNTS" SET "ACC_BALANCE" = ? WHERE "ACC_TYPE_ID" = ? AND "ACC_OWNER" = ?
CREATE TABLE "BK_ACCOUNTS" (
 
 "ACC_ID" serial PRIMARY KEY,
 "ACC_TYPE_ID" int NOT NULL,
 "ACC_OWNER" text NOT NULL,
 "ACC_BALANCE" numeric NOT NULL,
 
 FOREIGN KEY ("ACC_TYPE_ID") REFERENCES "BK_ACCOUNT_TYPES"("TYPE_ID"),
 FOREIGN KEY ("ACC_OWNER") REFERENCES "Customer"("id")
 
);

drop table "BK_ACCOUNTS" cascade;


create table "BK_ACCOUNT_TYPES"(
 	"TYPE_ID"  SERIAL PRIMARY KEY,
 	"ACC_TYPE" VARCHAR(24) NOT null
 	);



drop table  "BK_ACCOUNT_TYPES" cascade;


drop table "Customer";



INSERT INTO "BK_ACCOUNT_TYPES" ("ACC_TYPE") VALUES(?)




drop table "account"; 


select * from "Customer";



create table "Employee"(
  id text primary key ,
  username text,
  password varchar(20)
  );

 
    select * from "Employee";


  
 create table "account"(
 	account_id int primary key,
 	accoount_number int,
 	account_balance numeric	
 );



create table "Customer"(
  id text primary key ,
  username text,
  password varchar(20)
  );


 delete from "Customer" where id = '502';

