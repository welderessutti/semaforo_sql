# Semaforo Inteligente SQL

Este projeto consiste em uma aplicação **API RESTful** que permite realizar **CRUD** de usuários e das entidades
relacionadas ao sistema de semáforo inteligente. Utiliza **autenticação stateless** com token e autorização de acesso
conforme tipo de usuário. Com essa aplicação é possível realizar a gestão de semáforos, dos seus sensores, das suas
leituras e dos seus eventos.

A aplicação foi desenvolvida com padrão de arquitetura **MVC**, classe responsável por tratar as execeções (**Exception
Handler**), token **JWT**, banco de dados **MySQL** utilizando migração com **Flyway**, testes unitários com **JUnit**
e **Mockito**, testes automatizados com **Cucumber**, **Gherkin** e **Rest Assured**, e documentação com **Swagger**.

## DevOps - CI/CD

O foco do projeto é realizar a implementação de **CI/CD** da aplicação utilizando **GitHub Actions**, são utilizados
dois arquivos de **CI** e mais dois arquivos de CD.

Os workflows de **CI** são disparados toda vez que é aberto, ou reaberto, um **pull request** na branch **Staging** ou
na **Main**, executando um job de teste. Assim que os testes são validados, o usuário pode realizar o merge para a
branch de destino.

Os workflows de **CD** são disparados toda vez que é realizado um **push** na branch **Staging** ou na **Main**,
executando dois jobs, o primeiro job realiza a **build** da aplicação **(.jar)** e da imagem **Docker**, e faz o push da
imagem para o **Docker Hub**, já o segundo job, realiza o **deploy** da aplicação, tanto do ambiente **staging** quanto
do **production**, na cloud **Azure** utilizando **Web App**.

## QA - Testes

Foi implementado testes unitários com JUnit e testes automatizados com Cucumber e Gherkin.

O foco do projeto é realizar testes para verificar e validar a consistência do software, garantindo a sua qualidade e
estabilidade.

Os testes automatizados verificam a interação do usuário com a aplicação, validando os dados enviados para a API, o
status code, validação do corpo de resposta e a consistência dos dados retornados utilizando JSON Schema, tanto em
cenários positivos quanto em cenários negativos.

### Execução dos testes localmente

Faça o download ou clone o projeto na sua máquina.

Abra seu terminal, acesse a pasta raíz do projeto (local onde se encontra o arquivo **pom.xml** da aplicação), e executo
o comando a seguir para rodar a aplicação com o Docker:

```bash
docker compose up -d
```

Aguarde até que os containers sejam criados e estejam rodando.

Novamente com o terminal e na pasta raíz do projeto, execute o comando abaixo para executar todos os testes:

```bash
mvn clean test
```

Os testes devem ser executados com sucesso.

**Atenção, para executar os testes novamente, você deve antes **parar**, **excluir** e **subir** os containers
novamente, caso contrário, os testes falharão devido a uma regra de negócio da aplicação.*

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada para o desenvolvimento.
- **Spring Boot 3.3.0**: Framework principal para construção da aplicação.
- **Spring Web**: Para criação de APIs RESTful.
- **Spring Data JPA**: Para integração com bancos de dados relacionais, facilitando a manipulação de dados.
- **MySQL Connector**: Driver utilizado para conectar a aplicação ao banco de dados MySQL.
- **H2 Database**: Banco de dados em memória utilizado para testes e desenvolvimento local.
- **Spring Security**: Para implementação de autenticação e autorização na aplicação.
- **JWT (Java JWT - Auth0)**: Utilizado para geração e validação de tokens JWT (JSON Web Token), garantindo a segurança
  na troca de informações.
- **Spring Validation**: Para validação de dados de entrada, garantindo que as informações recebidas estejam no formato
  correto.
- **Spring DevTools**: Facilita o desenvolvimento com funcionalidades como auto-reload e ferramentas de debug.
- **Lombok**: Simplificação de código com anotações, gerando automaticamente getters, setters, construtores e outros.
- **Flyway**: Ferramenta de migração de banco de dados, garantindo o versionamento e a execução de scripts SQL de forma
  controlada.
- **SpringDoc OpenAPI 2.6.0**: Para gerar automaticamente a documentação da API em formato OpenAPI (Swagger UI),
  facilitando o entendimento e uso da API por desenvolvedores.
- **Spring Security Test**: Utilizado para testes de segurança, garantindo que as configurações de autenticação e
  autorização estejam corretas.
- **Spring Boot Starter Test**: Dependência para suporte a testes de unidade e integração no Spring Boot.
- **Cucumber Java 7.18.1**: Integração para escrever testes baseados em BDD.
- **Rest Assured 5.5.0**: Para criação de requisições HTTP e validação de respostas em testes de APIs RESTful.
- **Google Gson 2.11.0**: Biblioteca para serialização e desserialização de JSON.
- **Cucumber Junit 7.18.1**: Suporte para execução de testes Cucumber com JUnit.
- **JUnit Vintage Engine 5.7.0**: Executa testes JUnit 3 e 4 na plataforma JUnit 5.
- **Json Schema Validator 1.5.1**: Para validação de JSONs com base em schemas JSON.
- **Json 20240303**: Biblioteca para manipulação e criação de objetos JSON.
- **JUnit 5.9.2**: Framework de testes unitários para garantir a qualidade e integridade do código.
- **Mockito 5.4.0**: Ferramenta para criação de mocks e testes unitários de forma isolada.

## Pré-requisitos

- **Git** (caso queira clonar o repositório, mas você pode apenas baixá-lo):
    - [Git](https://git-scm.com/downloads)
- **Docker Desktop** (para executar a aplicação através de containers):
    - [Docker](https://www.docker.com/products/docker-desktop/)

## Como executar a aplicação

### Passo 1: Clonar ou baixar o repositório

Certifique-se de que o **Git** está instalado.

Para clonar o repositório, use o comando:

```bash
git clone https://github.com/welderessutti/semaforo_sql.git
```

Caso não queira clonar o repositório, você pode baixá-lo em [GitHub](https://github.com/welderessutti/semaforo_sql).

### Passo 2: Executar a aplicação

#### Ambiente de Desenvolvimento (dev):

Para executar a aplicação no ambiente **dev**, você deve executá-la diretamente da sua **IDE** de preferência, dessa
forma, a aplicação utilizará o banco de dados em memória **H2 Databse** e criará o banco de dados e as tabelas
automaticamente.

A aplicação estará disponível para acesso em:

```
http://localhost:8080/
```

Você pode acessar o banco de dados H2 pela **URL**:

```
http://localhost:8080/h2-console
```

- **Dados de acesso ao H2**:
    - **Driver Class**: org.h2.Driver
    - **JDBC URL**: jdbc:h2:mem:db_semaforo
    - **User Name**: sa

**Deixar o campo **Password** vazio.*

#### Ambiente de Testes (staging):

Certifique-se de ter o **Docker Desktop** instalado.

No terminal, dentro do diretório raíz do projeto
(local onde se encontra o arquivo **pom.xml** da aplicação),
execute o comando abaixo para subir os containers da aplicação e do banco de dados **MySQL**:

```bash
docker compose up -d
```

O Docker tentará baixar a imagem no repositório do
[Docker Hub](https://hub.docker.com/repository/docker/welderessutti/semaforo_sql),
caso ele não encontre a imagem, ele realizará a **build** da aplicação **(.jar)** e criará a imagem automaticamente.

Antes do container da aplicação subir, ele aguardará o container do banco de dados **MySQL** estar pronto utilizando um
**healthcheck**, quando pronto, o container da aplicação inicia, e realizará a migração do banco de dados e suas tabelas
automaticamente utilizando o **Flyway**, e estará disponível para acesso em:

```
http://localhost:8080/
```

## Documentação da API (Swagger UI)

A documentação da **API** pode ser acessada via **Swagger UI**. Após executar a aplicação em qualquer um dos ambientes
(**dev** ou **staging**), acesse:

```
http://localhost:8080/swagger-ui/index.html
```

Lá você encontrará detalhes sobre todos os endpoints disponíveis, parâmetros de entrada, e respostas.