package com.rafaelaugustor.linkio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  LinkioApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkioApplication.class, args);
    }

}

/*
🧠 1. Recursos Inteligentes

Custom aliases: Permitir ao usuário criar sua própria terminação (https://xxx.com/meuLinkLegal).

Expiração configurável: O usuário escolhe por quanto tempo a URL deve durar.

Preview da URL original: Algo como https://xxx.com/info/DXB6V que mostra a URL original antes de redirecionar.

🔄 2. Integração e Automatização

Webhook: Notificar algum endpoint quando a URL for acessada.

QR Code para a URL encurtada.

🧪 3. Testes e Qualidade
Testes automatizados (unitários e de integração).
* */ 