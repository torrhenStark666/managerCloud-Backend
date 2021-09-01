# ManagerCloudBackend

Esse projeto foi construido afim de demonstrar os conhecimentos adquiridos na disciplina de Tecnologia em Desenvolvimento de Sistema da [UTFPR Campi Santa Helena](https://www.utfpr.edu.br/campus/santahelena).

O escopo escolhido foi a construção de um módulo de compras para um ERP, então dentro da aplicação existe como controlar produto, fornecedores e pedidos de compras. Além de poder ser observado a construção do sistema de autenticação JWT, implementação de queries com o padrão Specification e também queries Nativas através do Spring Data, outra funcionalidade explorada é o mapeamento objeto relacional que pode ser visto dentro do package models e entre outras particularidades que podem ser exploradas clonando o projeto.

A tecnologia utilizada para essa etapa do projeto foi o [Spring](https://spring.io/) versão 2.1.5 utilizando o [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) versão 11, e a base dados foi o [MySQL Server](https://dev.mysql.com/downloads/mysql/) versão 8.0 (autenticação legado).

Caso tenha interesse em ver mais sobre o projeto verifique o outro [repositório](https://github.com/torrhenStark666/managerCloud-Front), deste mesmo trabalho.

## Requisitos

- Java: 11
- Mysql: 8.0 (Método de Autenticação Legado)
- Uma IDE Java(testado com Intelij e Apache Netbeans 12).

## Iniciando o projeto

Para iniciar utilize o script SQL `banco-de-dados.sql` que se encontra na raiz desse projeto para criar a sua base dados no banco. Note que no começo do tem o nome do schema que será criado.

Posterior após clonado o projeto, abre sua IDE Java e busque abrir o projeto através dela.

Como o projeto faz uso do spring boot, não é necessário fazer nenhuma configuração especial dentro do ambiente (exceto configurar o usuário e senha da base dados), basta primeiramente baixar a dependencias utilizando através da IDE o comando `Build with Dependences`.

Concluido a build(pode demorar um tempo até baixar tudo), procure a pasta `resources` onde será possivel encontrar o arquivo `application.properties`, abra o arquivo e configure o usuário e senha que a aplicação deverá utilizar para autenticar no MySQL e caso necessário a porta e o endereço de acesso.

Feito isso tudo, basta iniciar a aplicação e as API's ficaram disponiveis em `http://localhost:8080`.



