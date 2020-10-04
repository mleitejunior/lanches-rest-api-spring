<p align="center">
  <img src="https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/readme_resources/logo.png" title="Lanches logo" alt="Lanches Rest API">
</p>

<p align="center">Rest API de gestão de lanches (backend)<br>

## Features
- REST API
- PostgreSQL
- JWT authentication

## Technology Stacks
  - Java 8
  - Spring Boot 2.3.4
  - Spring Security
  - PostgreSQL
  - Hibernate
  - Spring Data JPA
  - Lombok
  - JWT Authentication
  - Maven

## Como rodar o projeto?

### Banco de dados:

O projeto no momento está configurado com PostgreSQL, será necessário um banco com o nome `lanches`.
As configurações podem ser modificadas no `src/main/resources/application.properties`:

```
spring.datasource.url = jdbc:postgresql://localhost:5432/lanches
spring.datasource.username = postgres
spring.datasource.password = password
```

Troque o `localhost` e a porta `5432` para as equivalentes ao seu banco (assim como as credenciais `username` e `password`) antes de iniciar o projeto.

### Montando o projeto:

Baixe o projeto para seu computador através do ZIP ou do comando `git clone https://github.com/mleitejunior/lanches-rest-api-spring`.

Na pasta do projeto execute `maven clean install` para montar o projeto baixando os arquivos necessários. Se as configurações do banco estiverem corretas, após os testes você receberá `BUILD SUCCESS`.

### Rodando o projeto:

Ainda na pasta do projeto, execute o comando `mvn spring-boot:run`.

### Autenticando:

Algumas requisições precisam de autenticação no sistema para funcionar, utilizando um Cliente API (como [Insomnia](https://insomnia.rest/download/) ou [Postman](https://www.postman.com/downloads/)), faça uma requisição POST em `http://localhost:9191/login` com as credenciais salvas em memória:

```
{
	"username": "employee",
	"password": "password"
}
```

Salve o bearer token de resposta e o utilize para as requisições que somente os funcionários poderão executar.


## Database Schema

![](https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/readme_resources/mer.png)

O Lanches API rest tem o intuito de gerir a venda de lanches, possibilitando o registro de ingredientes e a criação de lanches personalizados, assim como calcular o valor do lanche e aplicando descontos promocionais para lanches com ingredientes específicos.

*Entidades:*
- ingredient (ingredientes dos lanches com seu valor por custo)
- sandwich_recipe (a "receita" do lanche que irá definir os ingredientes, x-bacon, por exemplo)
- sandwich (representa o pedido de um lanche em específico)
- sandwich_item (o ingrediente do lanche específico)

*Tabela de relacionamento:*
- sandwich_recipe_has_ingredient (armazena quais ingredientes fazem parte de uma receita)

## Documentação

Acesse a documentação do projeto pelo endereço `http://localhost:9191/swagger-ui/`.
Para melhor visualização das requisições, importe em seu Insomnia o [lanches_rest_api.yaml](https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/readme_resources/lanches_rest_api.yaml)

## Autor
* **Marcelo Leite Junior** - *Information Systems Final-years Student, code owner* - [mleitejunior's Github](https://github.com/mleitejunior)
