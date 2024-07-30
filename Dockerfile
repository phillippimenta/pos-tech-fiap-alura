# Use uma imagem base leve do OpenJDK 17 com Alpine
FROM eclipse-temurin:17-jdk-alpine AS builder

# Instale o Maven
RUN apk add --no-cache maven

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo de configuração do Maven
COPY pom.xml .

# Baixe as dependências do Maven
RUN mvn dependency:go-offline -B

# Copie o código-fonte
COPY src ./src

# Empacote a aplicação
RUN mvn package -DskipTests

# Use uma imagem base mínima do OpenJDK para a fase de execução
FROM eclipse-temurin:17-jre-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR empacotado da fase de construção
COPY --from=builder /app/target/*.jar ./app.jar

# Exponha a porta
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
