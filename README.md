# Tech Challenge - Pós-Tech SOAT - FIAP

Este é o projeto desenvolvido durante a fase I do curso de pós-graduação em arquitetura de software da FIAP - turma 7SOAT.

Membros do grupo 88:
phillip eduardo pimenta forte - phillippimenta@gmail.com - RM 356060

## Propósito do projeto

Fornecer uma API Rest para um sistema de gerenciamento de pedidos para uma empresa atuante no ramo de entrega de refeição.

## Stack utilizada

* Java 17 
* MariaDB
* Flyway
* Jakarta Bean Validation
* Springdoc-openapi
* Spring Boot
* Spring Security
* Spring Data JPA
* Docker

## Instalação do projeto

Este projeto está preparado para ser executado em um ambiente Docker. Portanto, apenas a instalação do Docker será necessária, eliminando a necessidade de instalar manualmente o projeto ou o banco de dados (MariaDB).

Se ainda não tiver o Docker instalado, siga as instruções específicas para o seu sistema operacional na documentação oficial do Docker.

Para "construir" (build) o projeto, utilize o comando docker compose up.

### Estrutura do projeto

```shell
└── src
    ├── adapter
    │   ├── inbound
    │   │   └── controller
    │   │       ├── request
    │   │       ├── response
    │   ├── outbound
    │   │   └── repository
    │   │       ├── entity
    │   │       ├── mapper
    │   │   └── security
    │   └── application
    │       └── domain
    │       └── exception
    │       └── port
    │   │       ├── inbound
    │   │       ├── outbound
    │       └── usecase
    │       └── util
    ├── config
```
