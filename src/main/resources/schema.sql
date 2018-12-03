create table item (id integer generated by default as identity, description varchar(400), name varchar(255) not null, price double not null, url varchar(255) not null, order_id varchar(255), primary key (id));
create table orderinfo (id varchar(255) not null, delivery_date date, last_update_ts timestamp, status varchar(255), primary key (id));