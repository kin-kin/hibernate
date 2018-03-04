alter table account drop constraint FKcp50qbq0dv55q04m36vtc5qu9;
drop table if exists account cascade;
drop table if exists account_role cascade;
create table account (account_id  serial not null, id text not null, password text not null, name text not null, email text, role_id int4 not null, last_login_date timestamp, create_date timestamp not null, update_date timestamp not null, primary key (account_id));
create table account_role (account_role_id  serial not null, name text not null, create_date timestamp not null, update_date timestamp not null, primary key (account_role_id));
alter table account_role add constraint UK_g90cadqst33sk9ji2hcex4h47 unique (name);
alter table account add constraint FKcp50qbq0dv55q04m36vtc5qu9 foreign key (role_id) references account_role (account_role_id);
