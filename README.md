# PrimeiroProjetoSpring
#### Status: Concluído.

Primeira aplicação Java no ecossistema Spring Boot, no qual é possível realizar as operações básicas de criação, alteração e exclusão de um novo Administradores de um sistema, bem como listar todos os Administradores cadastrados após sua autenticação e permanência no sistema.

## Tecnologias:
- Spring Boot v2.6.2;
- Template HTML [Thymeleaf](https://www.thymeleaf.org/);
- Banco de dados relacional Postgres, rodando localmente.

## Características:
- Gerenciador de dependências Maven;
- Dependências Spring: com dependências: JPA, Web e Postgres;
- Serviço de Autenticação do usuário e autorização de acesso aos recursos do sistema (Cookie e Pre Handler Interceptor);
- Padrão de projeto em camadas MVC: Controller, Service, Repository e Model;
- Estilização das páginas com Bootstrap 4.

## Instruções para a Instalação:

Projeto em produção sendo executado no [Heroku](https://jcgama-springboot.herokuapp.com/login). 

Usuário padrão: `julio@email.com`

Senha padrão: `julio`.

Para rodar o projeto localmente, basta executar o comando:

```sh
./mvnw spring-boot:run
```

## Referências:
[Torne-se um Programador](https://www.torneseumprogramador.com.br/aulas/java).