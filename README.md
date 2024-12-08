# apiClientes
Este é um projeto de API RESTful desenvolvido em Java utilizando o framework Spring Boot. A API é projetada para gerenciar clientes, permitindo operações de criação, leitura, atualização e exclusão (CRUD). Além disso, a API inclui autenticação JWT e integração com o banco de dados MySQL.

## Funcionalidades
### Endpoints
- Clientes

-- POST /api/clientes: Cria um novo cliente.
-- GET /api/clientes: Retorna todos os clientes.
-- GET /api/clientes/{id}: Retorna um cliente pelo ID.
-- PUT /api/clientes/{id}: Atualiza um cliente existente.
-- DELETE /api/clientes/{id}: Exclui um cliente pelo ID.

- Tipos
-- GET /api/tipos: Retorna todos os tipos de clientes.

- Dashboard
-- GET /api/dashboard: Retorna a quantidade de clientes agrupados por tipo.

## Autenticação JWT
A API utiliza JWT (JSON Web Token) para autenticação. O filtro JwtTokenFilter é responsável por validar o token JWT em cada requisição.

## Configurações
- JWT
-- O segredo do JWT é configurado diretamente no código para fins de simplicidade. Em um ambiente de produção, recomenda-se utilizar variáveis de ambiente ou um serviço de gerenciamento de segredos.

- CORS
-- A configuração de CORS permite que o frontend (por exemplo, um aplicativo Angular) se comunique com a API.

## Banco de Dados
O projeto utiliza MySQL como banco de dados. As configurações de conexão estão definidas na classe ConnectionFactory.

## Swagger
A documentação da API é gerada automaticamente utilizando o Swagger. A configuração está na classe SwaggerConfig.

## Configuração e Execução
### Pré-requisitos
- Java 21
- MySQL
- Maven

## Passos para Executar
1. Clone o repositório:

git clone https://github.com/seu-usuario/apiClientes.git
cd apiClientes

2. Configure o banco de dados MySQL:
-- Crie um banco de dados chamado bd_apiclientes.
-- Atualize as credenciais de conexão no arquivo ConnectionFactory.java se necessário.

3. Execute o Docker Compose para iniciar o banco de dados MySQL:

docker-compose up -d

4. Compile e execute a aplicação:

./mvnw spring-boot:run

5. Acesse a documentação da API no Swagger:

http://localhost:8081/swagger-ui.html

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

### Nota: Este projeto é parte do treinamento Java WebDeveloper da COTI Informática.
