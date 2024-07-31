# Tech Challenge - Pós-Tech SOAT - FIAP

Trabalho de conclusão da pós-graduação em Arquitetura de Software pela FIAP e Alura - Turma 7SOAT.

## Membros do Grupo 88
- **Phillip Eduardo Pimenta Forte** - phillippimenta@gmail.com

## Recursos do Projeto

### Link do Miro
[https://miro.com/app/board/uXjVNTlNjME=/](https://miro.com/app/board/uXjVKMjQsV4=/)

### Link do Vídeo no YouTube
[https://www.youtube.com/watch?v=hvchwzuE9HY](https://www.youtube.com/watch?v=hvchwzuE9HY)

## Tecnologias Utilizadas

### Linguagem
- **Java** - JDK 17

### Banco de Dados
- **MariaDB** - Versão 10.11

### Frameworks e Ferramentas
- **Spring Boot**
- **Springdoc-openapi**
- **Flyway**

## Diagramas Arquitetônicos
![Diagramas Arquitetônicos](https://github.com/phillippimenta/pos-tech-fiap-alura/blob/main/documentacao/imagens/group-88-fiap-7soat-techchallenge-diagrams.png)

## Execução da Aplicação Localmente

### Utilizando Kubernetes (K8s)
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/phillippimenta/pos-tech-fiap-alura
   
### Instale o Minikube
Siga as instruções no site oficial: [Minikube Installation](https://minikube.sigs.k8s.io/docs/start/)

1. **Inicie o Minikube**
   ```bash
   minikube start

2. **Execute o script de deploy**
   ```bash
   ./deploy_minikube.sh
