# Gerenciamento de Pessoas

## Descrição
Aplicação de gerenciamento de pessoas (CRUD) utilizando Spring Boot.

## Tecnologias Utilizadas
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database

## Funcionalidades
- CRUD de Pessoas
- Autenticação básica com Spring Security
- Banco de dados em memória H2

## Como Executar
1. Clone o repositório.
2. Execute o comando `mvn spring-boot:run`.
3. Acesse a aplicação em `http://localhost:8080`.

## Endpoints
- `POST /pessoas`: Cria uma nova pessoa.
- `GET /pessoas`: Lista todas as pessoas.
- `GET /pessoas/{id}`: Busca uma pessoa específica utilizando o id.
- `PUT /pessoas/{id}`: Atualiza uma pessoa utilizando o id.
- `DELETE /pessoas/{id}`: Deleta uma pessoa utilizando o i.

## Testes
Para executar os testes, utilize o comando `mvn test`.

## Autenticação
Credenciais padrão:
- Usuário: `user`
- Senha: `password`
