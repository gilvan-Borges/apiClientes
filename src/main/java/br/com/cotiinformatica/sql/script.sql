CREATE DATABASE bd_apiclientes;
USE bd_apiclientes;

CREATE TABLE cliente(
	id 			CHAR(36) 		PRIMARY KEY,
	nome 		VARCHAR(150) 	NOT NULL,
	cpf			VARCHAR(14)		NOT NULL UNIQUE,
	telefone 	VARCHAR(20) 	NOT NULL,
	email	 	VARCHAR(50) 	NOT NULL
);

DESC cliente;

----------------------------------------------------------------------

use bd_apiclientes;

#consulta para exibir todos os clientes
select * from cliente order by nome;

#consulta para verificar se um cpf está cadastrado
select count(cpf) as qtd from cliente where cpf = '123456789-00' AND id <> 'ea56259c-d1bc-4433-a25d-b50318dcc3b7';

#consulta para retornar os dados de um cliente atraves do id
select * from cliente where id = '18de4037-1b82-4c2a-a94a-2fa64cad1db3';



