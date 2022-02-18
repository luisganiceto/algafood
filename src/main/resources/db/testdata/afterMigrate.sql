set foreign_key_checks = 0;

delete from cidade;
delete from cozinha;
delete from estado;
delete from forma_pagamento;
delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from produto;
delete from restaurante;
delete from restaurante_forma_pagamento;
delete from usuario;
delete from usuario_grupo;

set foreign_key_checks = 1;

alter table cidade auto_increment = 1;
alter table cozinha auto_increment = 1;
alter table estado auto_increment = 1;
alter table forma_pagamento auto_increment = 1;
alter table grupo auto_increment = 1;
alter table grupo_permissao auto_increment = 1;
alter table permissao auto_increment = 1;
alter table produto auto_increment = 1;
alter table restaurante auto_increment = 1;
alter table restaurante_forma_pagamento auto_increment = 1;
alter table usuario auto_increment = 1;
alter table usuario_grupo auto_increment = 1;

insert into cozinha(nome_cozinha) values('Tailandesa');
insert into cozinha(nome_cozinha) values('Brasileira');
insert into cozinha(nome_cozinha) values('Mexicana');
insert into cozinha(nome_cozinha) values('Argentina');

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
insert into cidade (nome_cidade, estado_id) values ('Arapongas', 4);

insert into restaurante(nome_restaurante, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values('Thai Restaurante ', 4.99, 1, '80430-110', 'Rua Alameda Júlia da Costa', '870', 'Bigorrilho', '', 6, utc_timestamp, utc_timestamp);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values('Restaurante Tuk ', 3.99, 1, '30310-530', 'Rua Francisco Deslandes', '689', 'Anchieta', '', 2, utc_timestamp, utc_timestamp);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values('Churrascaria Gaucha', 2, 2, ' 86706-430', 'Avenida Maracanã', '7300', 'Parque Industrial IV', '', 8, utc_timestamp, utc_timestamp);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values('Gelobel Londrina', 7, 2, '86027-750', 'Av. Theodoro Victorelli', '150', 'Carlota', '1o andar', 7, utc_timestamp, utc_timestamp);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values('Restaurante do Donizette', 1.99, 2, '18540-000', 'AV: Monsenhor Seckler', '306', 'Pôrto Feliz', '', 3, utc_timestamp, utc_timestamp);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values('Zapata La Taqueria', 2, 3, '80250-030', ' R. Brg. Franco', '2300', 'Centro', ' Loja 422 - 3º andar', 6, utc_timestamp, utc_timestamp);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values('La Santa Calle', 2, 3, '80510-070', 'R. Paula Gomes', '485', 'Centro', '', 6, utc_timestamp, utc_timestamp);
insert into restaurante(nome_restaurante, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values('Cabaña Del Primo', 0.99, 4, '60170-001', 'R. Maria Tomásia', '503', 'Aldeota', '', 5, utc_timestamp, utc_timestamp);

insert into forma_pagamento (descricao_forma_pagamento) values ('Cartão de crédito');
insert into forma_pagamento (descricao_forma_pagamento) values ('Cartão de débito');
insert into forma_pagamento (descricao_forma_pagamento) values ('Dinheiro');

insert into permissao (nome_permissao, descricao_permissao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (nome_permissao, descricao_permissao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (1,1), (1,2), (1,3);
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (2,1), (2,2), (2,3);
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (3,1), (3,2);
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (4,1), (4,2), (4,3);
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (5,3);
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (6,1), (6,2), (6,3);
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (7,1), (7,2), (7,3);
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (8,1), (8,2), (8,3);

insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 7);
insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);
insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 6);
insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 2);
insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 1);
insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 3);
insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 8);
insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);
insert into produto (nome_produto, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 4);
