create table device (serial_number varchar(255) not null, asset_number varchar(255), name varchar(255), device_model_id bigint, user_id bigint, primary key (serial_number)) engine=MyISAM
create table device_model (id bigint not null, description varchar(255), name varchar(255), os integer not null, primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table user (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id)) engine=MyISAM
alter table device add constraint FK4230av3mt8u6h1hls3q2ip1l7 foreign key (device_model_id) references device_model (id)
alter table device add constraint FKk92m2qj36vn62ctp5pgbt4982 foreign key (user_id) references user (id)
