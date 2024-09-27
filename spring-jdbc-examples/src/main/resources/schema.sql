create table if not exists `user`
(
    id char(19) not null primary key ,
    name varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists `address`
(
    id char(19) not null primary key ,
    detail varchar(45),
    user_id char(19),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,
    index (user_id)
);

explain
select * from user u join address a on u.id = a.user_id where u.id='1283947928306098176';

explain
select a.id as id, a.detail as detail, a.user_id as user_id,a.create_time as create_time,a.update_time as update_time,u.name as name
from address a join user u on a.user_id = u.id
where a.id = '1';
