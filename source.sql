create database networksecurity;

use networksecurity;

create table if not exists server_key(
    key_tgs varchar(32) not null ,
    key_server varchar(32) not null ,
    key_as varchar(32) not null
    );

create table if not exists user(
    id varchar(20) not null ,
    password varchar(20) not null
    );

create table if not exists session(
    session_id varchar(32) not null primary key ,
    rsa_private_key varchar(256) not null ,
    rsa_public_key varchar(256) not null ,
    client_id varchar(20) not null ,
    des_key_client varchar(32) not null ,
    des_key_client_tgs varchar(32) not null ,
    des_key_client_server varchar(32) not null ,
    time_stamp varchar(20) not null
    );