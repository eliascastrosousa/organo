create table colaboradores (
     id bigint not null auto_increment,
     nome varchar(100) not null,
     cargo varchar(100) not null,
     imagem varchar(100) not null,
     time_id bigint,
     data_admissao datetime not null,
     ativo tinyint,
     favorito tinyint,

     primary key(id),
     FOREIGN KEY (time_id) REFERENCES times(id)

);