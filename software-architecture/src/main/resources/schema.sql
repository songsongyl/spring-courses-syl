/*
 用户表，一对多地址表
 登录密码应加密编码后存储
 */
create table if not exists `user`
(

    id char(19) primary key ,
    account varchar(11) not null ,
    password varchar(40) not null ,
    role int not null ,
    unique (account)
);
/*
 地址表，一对一用户表
 用户表主键未设为外键，添加索引用于检索
 */
create table if not exists `address`
(
    id char(19) primary key ,
    detail varchar(40) not null,
    user_id char(19) not null ,

    index (user_id)
);