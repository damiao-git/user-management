# User Management

![Java](https://img.shields.io/badge/Java-17+-brightgreen)

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0+-blue)

![License](https://img.shields.io/badge/License-MIT-green)

## Descrição

O **User Management** é um sistema de gerenciamento de usuários desenvolvido com Spring Boot. Ele permite realizar operações de autenticação, cadastro e gerenciamento de usuários com diferentes níveis de acesso.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.0**
- **Spring Security (JWT)** 
- **Hibernate/JPA** 
- **MySQL 8.0** 
- **Maven** 

## Funcionalidades

- Cadastro de usuários(Sim, **por enquanto** pode se cadastrar como admin)
- Login com autenticação via JWT
- Proteção de rotas com permissões baseadas em roles
- Usuário _**admin**_ pode fazer tudo
- Usuário _**user**_ pode apenas visualizar
- Operações CRUD de usuários


## Usuários cadastrados: 

O cadastro foi feito via Seeder usando a classe **DataSeeder**

```
"login": "admin",
"password": "123qwe!@#"

ou

"login": "user",
"password": "123qwe123"
```

## Configuração do Ambiente

1. Certifique-se de que você tenha o **Java 17** instalado.
2. Clone o repositório:
   ```bash
   git clone https://github.com/damiao-git/user-management.git
   ```

Acesse o diretório do projeto:

```bash
cd user-management
```
Configure o banco de dados no arquivo application.properties:
Exemplo do meu _application.properties_

```properties
spring.application.name=users
spring.datasource.url=jdbc:mysql://localhost:3306/challenge?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

spring.jpa.hibernate.ddl-auto=update
api.security.token.secret=${JWT_SECRET:my-secret-key}

```
Por padrão, o projeto usa o banco de dados MYSQL. Você pode alterar para H2 ou PostgreSQL, se necessário.


Compile e execute o projeto:

```bash
mvn spring-boot:run
```

O sistema estará disponível em:

```arduino
http://localhost:8080
```
Documentação Swagger disponivel em: 

```
http://localhost:8080/swagger-ui/index.html
```

Para testes no Swagger:
```
- 1º Passo: Acessar com usuário e senha disponibilizados mais acima.
- 2º Passo: copiar Token de autorização e colar em authorize para efetuar o login.
- 3º Passo: Testar os endpoints abaixo.
```

Endpoints da API
```
|Método  |  Endpoint        | Descrição                         | Permissão|
|POST	 |  /auth/register  | Registra um novo usuário	        | Pública  |    
|POST	 |  /auth/login	    | Autentica um usuário	            | Pública  |
|GET	 |  /api/users	    | Lista todos os usuários	        | ADMIN    |
|PUT	 |  /api/users/{id} | Atualiza os dados de um usuário	| ADMIN    |
|DELETE	 |  /api/users/{id} | Remove um usuário	                | ADMIN    |
```

Exemplo de Payload para Registro:
```
POST /auth/register
```

json
```
{
  "username": "admin",
  "password": "admin123",
  "role": "ROLE_ADMIN"
}
```

Exemplo de Payload para Login:
```
POST /auth/login
```

json

```
{
  "username": "admin",
  "password": "admin123"
}
```
Resposta:

json
```
{
  "token": "eyJhbGciOiJIUzUxMiJ9..."
}
```
Utilize o token JWT retornado no cabeçalho de todas as requisições protegidas:

```makefile

Authorization: Bearer <seu_token>
```

### Considerações finais

- Achei um tanto estranho consumir API no BackEnd, então fiz apenas o uso da validação do cep.
- Tive dificuldade para validar quantidade de digitos para mobile.
- Com mais tempo é possível inserir testes unitários e de implementação.
- Uma tela para visualizar melhor as funcionalidades seria bem bacana, mas não tenho conhecimento em React, faria em Angular com mais tempo.