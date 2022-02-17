create table estado (
	id bigint not null auto_increment,
    nome_estado varchar(50) not null,
    sigla_estado varchar(2) not null,
    
    primary key (id)
) engine=InnoDB default charset=utf8;

alter table cidade add column estado_id bigint not null;

alter table cidade add constraint fk_cidade_estado
foreign key (estado_id) references estado (id);

alter table cozinha change nome nome_cozinha varchar(60);