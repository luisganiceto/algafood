insert into cozinha(nome_cozinha) values('Tailandesa');
insert into cozinha(nome_cozinha) values('Brasileira');
insert into cozinha(nome_cozinha) values('Mexicana');

insert into restaurante(nome_restaurante, taxa_frete, cozinha_id) values('Thai Restaurante ', 4.99, 1);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id) values('Restaurante Tuk ', 3.99, 1);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id) values('Churrascaria Gaucha', 2, 2);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id) values('Gelobel Londrina', 7, 2);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id) values('Restaurante do Donizette', 1.99, 2);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id) values('Zapata La Taqueria', 2, 3);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id) values('La Santa Calle', 2, 3);

insert into estado (nome_estado, sigla_estado) values ('Minas Gerais', 'MG');
insert into estado (nome_estado, sigla_estado) values ('São Paulo', 'SP');
insert into estado (nome_estado, sigla_estado) values ('Ceará', 'CE');
insert into estado (nome_estado, sigla_estado) values ('Paraná', 'PR');

insert into cidade (nome_cidade, estado_id) values ('Uberlândia', 1);
insert into cidade (nome_cidade, estado_id) values ('Belo Horizonte', 1);
insert into cidade (nome_cidade, estado_id) values ('São Paulo', 2);
insert into cidade (nome_cidade, estado_id) values ('Campinas', 2);
insert into cidade (nome_cidade, estado_id) values ('Fortaleza', 3);
insert into cidade (nome_cidade, estado_id) values ('Curitiba', 4);
insert into cidade (nome_cidade, estado_id) values ('Londrina', 4);

insert into forma_pagamento (descricao_forma_pagamento) values ('Cartão de crédito');
insert into forma_pagamento (descricao_forma_pagamento) values ('Cartão de débito');
insert into forma_pagamento (descricao_forma_pagamento) values ('Dinheiro');

insert into permissao (nome_permissao, descricao_permissao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (nome_permissao, descricao_permissao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');
