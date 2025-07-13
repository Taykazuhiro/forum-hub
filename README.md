<p align="center">
<img src = "ONE_logo_rgb.png" width="300" height="150">
</p>
  <p align="center">
   <img src="https://img.shields.io/badge/Framework-Spring-blue"> <img src="https://img.shields.io/badge/Language-Java%2021.07-orange"> <img src="https://img.shields.io/badge/Database-MySQL-green"> 
  </p>

<p><a href="#english-version"> English Version </a></p>

<a id="readme-top"></a>
# 📚 Forum Hub

O **Forum Hub** é uma API RESTful construída com Spring Boot para gerenciamento de um fórum de discussão. A aplicação permite o cadastro, detalhamento, atualização e exclusão de tópicos, autenticação de usuários com JWT, promovendo uma estrutura robusta e segura para aplicações web modernas.

---

## 🚀 Funcionalidades principais:

- ✅ Cadastro e autenticação de usuários com JWT
- ✅ Registro, detalhamento, atualização e exclusão de tópicos
- ✅ Listagem paginada de tópicos com filtros
- ✅ Validação de regras de negócio
- ✅ Controle de acesso baseado em perfil (ex: ADMIN)
- ✅ Tratamento de exceções e respostas padronizadas

---

## 🛠️ Tecnologias e frameworks utilizados:

- **Java 17**
- **Spring Boot 3**
- **Spring Security** (com JWT)
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Flyway** (para versionamento de banco de dados)
- **Lombok**
- **JPA Specification / JPQL**
- **Bean Validation**
- **OpenAPI/Swagger** (para documentação)

---

## ✅ Requisitos para executar a aplicação:

- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.8+](https://maven.apache.org/install.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/) (ou banco equivalente configurado no `application.properties`)
- [Insomnia](https://insomnia.rest/) ou outro HTTP Client (opcional, para testes)

---

## 🎯 Configuração do Banco de Dados:

Antes de rodar a aplicação, configure o arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:8080/forum
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Obs: Certifique-se de ter criado um banco de dados chamado `forum` no MySQL.

---

## 🔐 Configuração de Secret do Token JWT

No arquivo:
```
src/main/resources/application.properties
```

Exemplo:

```properties
api.security.token.secret=${SUA_SENHA}
```
> Obs: Recomendo o uso de variáveis de ambiente para todas as configurações do arquivo.
___

## 📦 Como rodar a aplicação:

### 1. Clone o repositório

```bash
git clone https://github.com/Taykazuhiro/forum-hub.git
cd forum-hub
```

### 2. Crie o banco de dados

No MySQL, crie um banco com o nome:

```sql
CREATE DATABASE forum;
```

> Caso esteja usando Flyway, ele criará as tabelas automaticamente.

### 3. Configure o arquivo `application.properties`

Preencha com seus dados de conexão (usuário/senha do banco).

### 4. Rode a aplicação com Maven

```bash
./mvnw spring-boot:run
```

### 5. Teste os endpoints

Você pode usar o Postman, Insomnia ou até mesmo o Swagger, se estiver habilitado. Os principais endpoints são:

- `POST /login` → Autenticação
- `GET /topicos` → Listagem de tópicos
- `GET /topicos/${id}` → Detalha o tópico selecionado pelo ID
- `POST /topicos` → Criação de novo tópico
- `DELETE /topicos/{id}` → Exclusão do tópico
- `DELETE /resolved/{id}` → Altera o status do tópico para resolvido. O tópico não aparecerá no método de listagem, mas não será excluído do banco. 

---

## 👩‍💻 Desenvolvedora:

Feito com 💜 por **Tayná Silva** `aka` _Tay Kazuhiro_

**[LinkedIn](https://www.linkedin.com/in/tay-silva/)** | **[GitHub](https://github.com/Taykazuhiro)**

_Este projeto faz parte do desafio **ForumHub** do programa **Oracle Next Generation (ONE) em parceria com a Alura**._

_____________________________

<p><a href="#english-version">Versão em Português</a></p>

<a id="readme-top"></a>
# 📚 Forum Hub

**Forum Hub** is a RESTful API built with Spring Boot designed to manage a discussion forum. The application allows topic creation, editing, deletion, and JWT-based authentication — providing a secure and scalable structure for modern web applications.

---

## 🚀 Main Features:

- ✅ User authentication with JWT
- ✅ Create, read, update and delete discussion topics
- ✅ Paginated listing of topics with filters
- ✅ Business rule validations
- ✅ Role-based access control (e.g., ADMIN)
- ✅ Exception handling with standardized responses

---

## 🛠️ Technologies and Frameworks:

- **Java 17**
- **Spring Boot 3**
- **Spring Security** (JWT-based)
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Flyway** (for database versioning)
- **Lombok**
- **JPA Specification / JPQL**
- **Bean Validation**
- **OpenAPI/Swagger** (for documentation)

---

## ✅ Requirements to Run the App:

- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.8+](https://maven.apache.org/install.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/) (or another configured DB in `application.properties`)
- [Insomnia](https://insomnia.rest/) or another HTTP client (optional for testing)

---

## ⚙️ Database Configuration

Before running the application, configure the file:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:8080/forum
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Make sure you've created a database named `forum` in MySQL.

---

## 🔐 JWT Token Secret Configuration

In the same file:

```
src/main/resources/application.properties
```

Example:

```properties
api.security.token.secret=${YOUR_SECRET}
```

> Tip: It's recommended to store secrets and credentials in environment variables.

---

## 📦 How to Run the App

### 1. Clone the repository

```bash
git clone https://github.com/Taykazuhiro/forum-hub.git
cd forum-hub
```

### 2. Create the database

In MySQL:

```sql
CREATE DATABASE forum;
```

> If Flyway is enabled, the schema will be initialized automatically.

### 3. Configure `application.properties`

Set your database credentials and connection URL.

### 4. Run the application using Maven

```bash
./mvnw spring-boot:run
```

### 5. Test the endpoints

Use tools like Postman, Insomnia or Swagger if enabled. Key endpoints include:

- `POST /login` → User authentication
- `GET /topicos` → List all topics
- `GET /topicos/{id}` → Get topic details by ID
- `POST /topicos` → Create a new topic
- `DELETE /topicos/{id}` → Delete a topic
- `DELETE /resolved/{id}` → Mark a topic as resolved. It will be hidden in listings but not deleted from the database.

---

## 👩‍💻 Developer:

Made with 💜 by **Tayná Silva** `aka` _Tay Kazuhiro_

**[LinkedIn](https://www.linkedin.com/in/tay-silva/)** | **[GitHub](https://github.com/Taykazuhiro)**

_This project is part of the **ForumHub Challenge** from the **Oracle Next Generation (ONE) program in partnership with Alura**._