-- SQL: DML (manipulation), DDL (definition), DCL (control) --> admiministrative
        
        
               
        BEGIN TRANSACTION;
        
        DROP TABLE  IF EXISTS purchase;
        DROP TABLE  IF EXISTS painting;
        DROP TABLE  IF EXISTS artist;
        DROP TABLE  IF EXISTS customer;
        
        CREATE TABLE artist
        (
                artist_id serial, 
                name varchar(100) NOT NULL,
                
                
                constraint pk_artist primary key (artist_id)
        );
        
        CREATE TABLE painting 
        (
                painting_id serial,
                title varchar (160) NOT NULL,
                artist_id int NOT NULL,
                
                
                constraint pk_painting primary key (painting_id),
                constraint fk_painting_artist foreign key (artist_id) references artist (artist_id)       
        );
        
        
        
        CREATE TABLE customer
        (
                customer_id SERIAL PRIMARY KEY,
                name varchar (100) NOT NULL,
                address varchar (100) NOT NULL, 
                phone varchar (15)
        );
        
        CREATE TABLE purchase
        (
                purchase_id serial PRIMARY KEY,
                customer_id int NOT NULL, 
                painting_id int NOT NULL,
                purchase_date timestamp NOT NULL,
                price money NOT NULL,  
                
                constraint fk_customer_customer_id FOREIGN KEY (customer_id) references customer (customer_id),
                constraint fk_painting_painting_id FOREIGN KEY (painting_id) references painting (painting_id)
                
        );
        
        
        
        COMMIT;