alter table cidade drop column nome_estado;

create table forma_pagamento (
	id bigint not null auto_increment, 
    descricao_forma_pagamento varchar(50) not null, 
    
    primary key (id)
) engine=InnoDB default charset=utf8;

create table grupo (
	id bigint not null, 
    nome_grupo varchar(50) not null, 
    
    primary key (id)
) engine=InnoDB default charset=utf8;

create table grupo_permissao (
	grupo_id bigint not null, 
    permissao_id bigint not null
) engine=InnoDB default charset=utf8;

create table permissao (
	id bigint not null auto_increment, 
    nome_permissao varchar(50) not null,
    descricao_permissao varchar(100), 
    
    primary key (id)
) engine=InnoDB default charset=utf8;

create table produto (
	id bigint not null auto_increment, 
    nome_produto varchar(100) not null,
    preco decimal(19,2) not null,
    descricao varchar(255) not null, 
    ativo bit not null,      
    restaurante_id bigint, 
    
    primary key (id)
) engine=InnoDB default charset=utf8;

create table restaurante (
	id bigint not null auto_increment, 
    nome_restaurante varchar(50) not null, 
    taxa_frete decimal(19,2) not null,
    cozinha_id bigint,
    endereco_cep varchar(10), 
    endereco_logradouro varchar(100), 
	endereco_numero varchar(10),
    endereco_bairro varchar(50), 
    endereco_complemento varchar(100),  
    endereco_cidade_id bigint,
    data_cadastro datetime not null,
    data_atualizacao datetime not null, 
    
    primary key (id)
) engine=InnoDB default charset=utf8;

create table restaurante_forma_pagamento (
	restaurante_id bigint not null, 
    forma_pagamento_id bigint not null
) engine=InnoDB default charset=utf8;

create table usuario (
	id bigint not null, 
    nome_usuario varchar(50) not null,
    email varchar(100) not null, 
    senha varchar(100) not null, 
    data_cadastro datetime, 	 

	primary key (id)
) engine=InnoDB default charset=utf8;

create table usuario_grupo (
	usuario_id bigint not null, 
    grupo_id bigint not null
) engine=InnoDB default charset=utf8;

alter table grupo_permissao add constraint fk_grupo_permissao_permissao 
foreign key (permissao_id) references permissao (id);

alter table grupo_permissao add constraint fk_grupo_permissao_grupo
foreign key (grupo_id) references grupo (id);

alter table produto add constraint fk_produto_restaurante
foreign key (restaurante_id) references restaurante (id);

alter table restaurante add constraint fk_restaurante_cozinha 
foreign key (cozinha_id) references cozinha (id);

alter table restaurante add constraint fk_restaurante_cidade
foreign key (endereco_cidade_id) references cidade (id);

alter table restaurante_forma_pagamento add constraint fk_restaurante_forma_pagamento_forma_pagamento
foreign key (forma_pagamento_id) references forma_pagamento (id);

alter table restaurante_forma_pagamento add constraint fk_restaurante_forma_pagamento_restaurante 
foreign key (restaurante_id) references restaurante (id);

alter table usuario_grupo add constraint fk_usuario_grupo_permissao 
foreign key (grupo_id) references permissao (id);

alter table usuario_grupo add constraint fk_usuario_grupo_usuario 
foreign key (usuario_id) references usuario (id);