-- liquibase formatted sql
-- changeset author:parbh context:test,local

create table public.tb_users (
    id bigserial NOT NULL,
    user_id varchar(30) NOT NULL UNIQUE,
    address1 varchar(100) NOT NULL,
    address2 varchar(100) NULL,
    phone1 varchar(100) NOT NULL,
    phone2 varchar(100) NULL,
    password varchar(20) NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NULL,
    constraint tb_users_pk primary key (id)
);
drop index if exists ix_tb_users_user_id;
create index ix_tb_users_user_id on tb_users(user_id);


create table public.tb_point (
    user_id varchar(30) not null UNIQUE,
    point numeric(19,2) NOT NULL DEFAULT 0,
    created_at timestamp NOT NULL,
    updated_at timestamp NULL,
    constraint tb_point_pk primary key (user_id)
);
drop index if exists ix_tb_point_user_id;
create index ix_tb_point_user_id on tb_point(user_id);