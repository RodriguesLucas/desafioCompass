# Desafio  de recutamento [Compass.uol](https://bitbucket.org/RecrutamentoDesafios/desafio-java-springboot/src/master/README.md)
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/RodriguesLucas/desafioCompass/blob/main/LICENSE)

Esse desafio foi realizado com o objetivo de treinar o desenvolvimento em uma aplicação real de recrutamento.

A aplicação consiste em um microserviço onde é possível criar, alterar, visualizar e excluir um determinado produto, além de visualizar a lista de produtos cadastrados. Também é possível realizar a busca de produtos filtrando por name, description e price.

![Modelo Conceitual](https://github.com/RodriguesLucas/desafioCompass/blob/main/ASSETS/ModeloConceitual.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Jpa / Hibernate
- Maven

# Como executar o projeto
## Back end
Pré-requisito: Java 11

```bash
# Clonar o repositório
git clone https://github.com/RodriguesLucas/desafioCompass.git

# Entrar na pasta do projeto back end
cd backend

# Executar o projeto
./mvnw spring-boot:run

```
```bash
# Sugestão: Usar o Postman para testar as requisições
  URL padrão da requisição: http://localhost:8080/products
  
  Get: http://localhost:8080/products
  
  Get: http://localhost:8080/products/{id}
  
  Get: http://localhost:8080/products/search?q={name}&min_price={price}&max_price={price}
  
  Post: http://localhost:8080/products
  
  Put: http://localhost:8080/products/
  
  Delete: http://localhost:8080/products/{id}
```
# Autor
Lucas Rodrigues

https://www.linkedin.com/in/lucas-rodrigues-0558a3205/
