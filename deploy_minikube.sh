#!/bin/bash
echo 'Removendo namespace "techchallenge" se já existir...'
kubectl delete namespace techchallenge --ignore-not-found
echo 'Criando namespace "techchallenge"...'
kubectl create namespace techchallenge
sleep 5
echo 'Namespace "techchallenge" criado com sucesso.'
echo 'Iniciando configuração do banco de dados...'
kubectl apply -f k8s/db-deployment.yaml -n techchallenge
sleep 5
echo 'Deployment do banco de dados aplicado com sucesso.'
echo 'Configurando serviço para o banco de dados...'
kubectl apply -f k8s/db-service.yaml -n techchallenge
sleep 5
echo 'Serviço do banco de dados configurado com sucesso.'
echo 'Configurando serviço para a aplicação...'
kubectl apply -f k8s/app-service.yaml -n techchallenge
sleep 5
echo 'Iniciando deployment da aplicação...'
kubectl apply -f k8s/app-deployment.yaml -n techchallenge
sleep 60
echo 'Deployments concluídos.'
