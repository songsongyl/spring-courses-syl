create table if not exists `department`
(
  id char(19) primary key ,
  name varchar(20)  not null ,
  insert_time datetime not null default current_timestamp ,
  update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists `user`
(
    id char(19) primary key ,
    account varchar(12) not null ,
    password varchar(65) not null ,
    name varchar(6) not null ,
    depart json null comment '{depId,depName}',
    role char(4) not null ,
    `group` tinyint unsigned null ,
    student json null comment '{sequence,projectTitle,teacherId,teacherName}',
    teacher json comment '{total,A,C}',
    insert_time datetime not null default current_timestamp ,
    update_time datetime not null default current_timestamp on update current_timestamp,
    unique (account),
    index ((cast(depart ->> '$.depId' as char(19)) collate utf8mb3_bin),role),
    index((cast(student ->> '$.teacherId' as char (19) )collate utf8mb3_bin))
);

create table if not exists `process`
(
    dep_id char(19) not null ,
    id char(19) primary key ,
    name varchar(20) not null ,
    `describe` varchar(100) null ,
    point tinyint unsigned not null ,
    items json not null comment '[{number,name,percentage,describe}]',
    type char(4) not null ,
    attach json null comment '[{number,name,extend,describe]',
    insert_time datetime not null default current_timestamp ,
    update_time datetime not null default current_timestamp on update current_timestamp,
    index(dep_id)
);

create table if not exists `process_score`
(
    id char(19) primary key ,
    student_id char(19) not null ,
    teacher_id char(19) not null ,
    process_id char(19) not null ,
    `group` tinyint unsigned null ,
    insert_time datetime not null default current_timestamp ,
    update_time datetime not null default current_timestamp on update current_timestamp,
    scores json not null comment '{teacherName,scores,detail:[{itemId,score}]}',
    unique (process_id,teacher_id,student_id)
);

create table if not exists `process_file`
(
    id          char(19)    not null primary key,
    detail      varchar(60) null,
    student_id  char(19)    not null,
    process_id  char(19)    not null,
    number      tinyint     not null,
    insert_time datetime    not null default current_timestamp,
    update_time datetime    not null default current_timestamp on update current_timestamp,

    unique (process_id, student_id, number)
);

