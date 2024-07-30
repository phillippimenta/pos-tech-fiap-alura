# Use a imagem oficial do Maven como imagem base
FROM maven:3.8.4-openjdk-17 AS builder

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo do projeto Maven
COPY pom.xml .

# Baixa todas as dependências do Maven (as dependências serão armazenadas em cache se o pom.xml não tiver mudado)
RUN mvn dependency:go-offline -B

# Copia o código-fonte para o contêiner
COPY src ./src

# Empacota a aplicação
RUN mvn package -DskipTests

# Inicia uma nova etapa a partir da imagem base openjdk
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo JAR empacotado da etapa de construção para o diretório atual
COPY --from=builder /app/target/*.jar ./app.jar

# Expõe a porta em que a aplicação será executada
EXPOSE 8080

# Especifica o comando a ser executado ao iniciar o contêiner
CMD ["java", "-jar", "app.jar"]
