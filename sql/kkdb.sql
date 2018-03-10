drop table if exists account cascade;
drop table if exists account_role cascade;
create table account (record_id  serial not null, account_id text not null, account_role_record_id int4 not null, password text not null, name text not null, email text, last_login_date timestamp, create_date timestamp not null, update_date timestamp not null, primary key (record_id));
create table account_role (record_id  serial not null, name text not null, create_date timestamp not null, update_date timestamp not null, primary key (record_id));
alter table account_role add constraint UK_g90cadqst33sk9ji2hcex4h47 unique (name);
