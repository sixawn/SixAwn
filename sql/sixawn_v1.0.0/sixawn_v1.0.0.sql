drop table if exists sa_user;
create table sa_user (
  id int(11) not null auto_increment comment '主键ID',
  username varchar(255) default null comment '用户名',
  password varchar(255) default null comment '用户密码',
  deleted tinyint comment '是否删除 0-否, 1-是',
  create_time datetime default null comment '创建时间',
  modify_time datetime default null comment '修改时间',
  primary key (id)
) engine=innodb auto_increment=1 default charset=utf8;

insert into sa_user values('1', 'SixAwn', '123456', 0, now(), now());
insert into sa_user values('2', 'admin', '123456', 0, now(), now());