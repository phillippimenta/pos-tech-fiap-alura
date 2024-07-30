#!/bin/bash

# Nome do namespace (opcional, ajuste se necessário)
NAMESPACE="techchallenge"

# Nome da imagem Docker e tag
IMAGE_NAME="techchallenge-app"
IMAGE_TAG="latest"

# Configura o ambiente Docker do Minikube
eval $(minikube docker-env)

# Construir a imagem Docker
echo "Construindo a imagem Docker..."
docker build -t $IMAGE_NAME:$IMAGE_TAG .

# Aplicar configurações Kubernetes
echo "Aplicando configurações Kubernetes..."
kubectl apply -f k8s/db-deployment.yaml -n $NAMESPACE
kubectl apply -f k8s/db-service.yaml -n $NAMESPACE
kubectl apply -f k8s/app-deployment.yaml -n $NAMESPACE
kubectl apply -f k8s/app-service.yaml -n $NAMESPACE

# Verificar o status dos pods
echo "Verificando o status dos pods..."
kubectl get pods -n $NAMESPACE

# Verificar o status dos serviços
echo "Verificando o status dos serviços..."
kubectl get services -n $NAMESPACE

# Exibir logs dos pods para diagnóstico
echo "Exibindo logs dos pods..."
kubectl logs -l app=$IMAGE_NAME -n $NAMESPACE
