create table times (
     id bigint not null auto_increment,
     nome varchar(100) not null,
     cor varchar(100) not null,
     ativo tinyint,

     primary key(id)
);