create table posts (
     id bigint not null auto_increment,
     titulo varchar(255) not null,
     texto  LONGTEXT not null,
     imagem varchar(255),
     colaborador_id bigint  not null,
     ativo tinyint  not null,
     data_criacao datetime,


     primary key(id),
     FOREIGN KEY (colaborador_id) REFERENCES colaboradores(id)

);