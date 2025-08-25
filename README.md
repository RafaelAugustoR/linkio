# Linkio — Encurtador de URLs

Encurtador de URLs simples e rápido, com API REST para criar links curtos e redirecionar para a URL original. Os links possuem tempo de vida limitado, expirando automaticamente após um período de tempo.

## Visão geral

A aplicação expõe uma API REST para:
- Receber uma URL longa e retornar um link curto.
- Redirecionar (HTTP 302 Found) do link curto para a URL original.

Os registros de link possuem expiração automática, o que ajuda a manter o banco limpo e o serviço eficiente.

## Principais recursos

- Geração de link curto automática com identificadores aleatórios.
- Suporte a alias personalizado opcional (ex.: escolher o “ID” do link).
- Redirecionamento via HTTP 302 com cabeçalho `Location`.
- Expiração automática de links após um período definido.
- Pronto para execução local e via Docker.

## Stack tecnológica

- Java 21
- Spring Boot (Spring Web/MVC)
- Spring Data MongoDB
- Lombok
- MongoDB
- Docker e Docker Compose (opcional)
- Biblioteca de Nano ID para geração de identificadores curtos

## Requisitos

- JDK 21+
- Maven 3.9+ (ou utilizar o Maven Wrapper incluso no projeto)
- MongoDB em execução local ou acessível via URI
- Docker e Docker Compose (opcional, para execução conteinerizada)

