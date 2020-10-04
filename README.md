<p align="center">
  <img src="https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/readme_resources/logo.png" title="Lanches logo" alt="Lanches Rest API">
</p>

<p align="center"><b>Rest API</b> de gestão de lanches<br>
	
A Lanches API Rest tem o intuito de gerir a venda de lanches, possibilitando o registro de ingredientes e a criação de lanches personalizados, assim como calcular o valor do lanche e aplicando descontos promocionais para lanches com ingredientes específicos.

## Techs
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

**Via Imagem DOCKER**
Se você utiliza o [Docker](https://www.docker.com/), pode importar a imagem com o comando:
`docker import - lanches_postgresql.tar`

[DOWNLOAD DA IMAGEM](https://drive.google.com/file/d/1Nk4ByfneNUzwmilnlLs6BGha-2_FcBwQ/view?usp=sharing)

**Manualmente**

As configurações podem ser modificadas no `src/main/resources/application.properties`:

```
spring.datasource.url = jdbc:postgresql://localhost:5432/lanches
spring.datasource.username = postgres
spring.datasource.password = password
```

Troque o `localhost` e a porta `5432` para as equivalentes ao seu banco (assim como as credenciais `username` e `password`) antes de iniciar o projeto.

### Montando o projeto:

Baixe o projeto para seu computador através do ZIP ou do comando:

`git clone https://github.com/mleitejunior/lanches-rest-api-spring`

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

**Salve o bearer token** de resposta e o utilize para as requisições que somente os funcionários poderão executar.


## Database Schema

![](https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/readme_resources/mer.png)

Caso não utilizou o docker ja citado, você pode baixar o arquivo `.sql` de [exemplo de banco já populado AQUI!](https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/readme_resources/dump-lanches.sql)

*Entidades:*
- ingredient (ingredientes dos lanches com seu valor por custo)
- sandwich (o lanche em si)
- order (representa o pedido de um lanche em específico)
- order_item (o ingrediente do lanche específico)

ps: O atributo **ingredient_price** em `order_item` existe para manter registrado o valor atual do ingrediente no momento do pedido. Caso contrário não seria necessário por já existir o **price_per_item** em `ingredient`.

*Tabela de relacionamento:*
- sandwich_recipe_has_ingredient (armazena quais ingredientes fazem parte de uma receita)

## Requisições e Regras de Negócios

**INSERINDO NOVO SANDUICHE:**

O exemplo do banco já populado foi adicionado pelo POST `/sandwich` da seguinte forma:
```
[
	{
  "name": "x-burguer",
  "ingredients": [
		{
			"id": 3
		},
		{
			"id": 5
		}
  ]
  }
]
```
Onde `3` é o ID do hambúrguer no banco e `5` é ID do queijo.


**FAZENDO O PEDIDO UTILIZANDO O SANDUÍCHE:**

É possível pedir um sanduiche direto pelo id de sua receita, gerando os `ordem_item` diretamente através de um POST `/order`:
```
{
	"sandwich": { "id": 1 }
}
```

Onde `1` seria o id de um x-bacon por exemplo.


**PROMOÇÕES:**

A classe `src/main/java/com/mleitejunior/lanchesrestapispring/service/PromotionService.java` gerencia a regra de negócios das promoções, que no momento são 3:

*Light:* Se o lanche tem alface e não tem bacon, ganha 10% de desconto.
*Muita carne:* A cada 3 porções de hambúrguer o cliente só paga 2, a cada 6 porções, o cliente pagará 4 e assim sucessivamente.
*Muito queijo:* A cada 3 porções de queijo o cliente só paga 2, a cada 6 porções, o cliente pagará 4 e assim sucessivamente.

Sempre que ocorrer um INSERT, UPDATE ou DELETE de um `order_item`, o desconto é calculado sobre o preço do `order`.

## Documentação

Acesse a documentação do projeto pelo endereço `http://localhost:9191/swagger-ui/`.
Se deseja visualizar as requisições em seu Insomnia, importe as configurações através do arquivo [lanches_rest_api.yaml](https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/readme_resources/lanches_rest_api.yaml)

## Melhorias

**Testes:**
Os testes até o momento foram feitos manualmente, deve-se implementar testes automáticos para verificar as regras de negócios e as relações entre as tabelas.

**Implementação de sistema de vendas:**
É necessário expandir o banco e o sistema tanto para as validações atuais quanto para recursos básicos de uma lanchonete.

**Abstrair sistema de promoções:**
Apesar estar concentrado em um arquivo apenas, as promoções ainda não são fáceis de serem adicionadas. Pode-se criar uma classe para cada lógica de promoção (no caso temos duas, quantidade e tipo de ingrediente) e chamá-las todas no `PromotionService`, podendo até mesmo ir para o banco de dados com data de expiração da promoção.

**Frontend:**
Para consumir a API e visualizar o sistema.

**Autenticação AWT:**
No momento a autenticação está feita por regex (o que é longe do ideal) e as credenciais estão salvas na memória, será criado a entidade `user` para registrar clientes e funcionários e mapeadas as requisições corretas para que se autentique de acordo com as permissões de usuário.

**Montagem automatica do projeto:**
Sintetizar o banco e as configurações em um Dockerfile para ser montado automaticamente pelo projeto maven.

## Autor
* **Marcelo Leite Junior** - *Information Systems Final-years Student, code owner* - [mleitejunior's Github](https://github.com/mleitejunior) - `mleitejunior@gmail.com`
