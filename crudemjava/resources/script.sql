-- Desenvolvendo um CRUD em Java
-- Autor: Felipe Pinto Marinho
-- Data:23/08/2023

-- Criando um database
CREATE DATABASE agenda;
create table contatos(
id int not null auto_increment primary key,
nome varchar(40),
idade int,
dataCadastro date)