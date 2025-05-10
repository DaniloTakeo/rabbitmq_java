# 📬 Projeto de Mensageria com Java, Spring Boot e RabbitMQ

Este projeto tem como objetivo explorar os principais conceitos de mensageria usando **RabbitMQ** com **Spring Boot**, passando por diferentes tipos de **exchanges**, **roteamento** e **formatos de mensagens** como JSON.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring AMQP
- RabbitMQ
- Jackson (para serialização JSON)
- Docker (para executar o RabbitMQ localmente)

---

## ▶️ Executando o projeto

### 1. Suba o RabbitMQ com Docker

```bash
docker run -d --hostname rabbit-local --name rabbitmq \
  -p 5672:5672 -p 15672:15672 \
  rabbitmq:3-management
```

A interface de administração estará disponível em:
http://localhost:15672
Login: guest | Senha: guest

---

#### 2. Rode o projeto com Maven
```bash
./mvnw spring-boot:run
```

---

## 🧪 Funcionalidades implementadas

#### ✅ Fila e Exchange Básica
- Configuração de uma fila direta (fila.teste)
- Envio e consumo simples de mensagens de texto

#### ✅ Exchange Fanout (broadcast)
- Criada FanoutExchange para enviar a mesma mensagem para múltiplas filas
- Vários consumidores recebem a mesma mensagem

#### ✅ Exchange Topic (roteamento com padrões)
- Criada TopicExchange
- Rotas com padrões como email.*, sms.#
- Mensagens roteadas para filas específicas conforme a routing key

#### ✅ Exchange Headers
- Criada HeadersExchange
- Filtro de mensagens baseado em cabeçalhos (ex: tipo=financeiro)
- Uso de whereAll e whereAny para controle de entrega

#### ✅ Mensagens JSON
- Uso de Jackson2JsonMessageConverter para enviar/receber objetos Java como JSON
- Fila fila.json configurada
- DTO MensagemDTO com campos conteudo e remetente
- Endpoint HTTP para envio de mensagens JSON
- Consumo com desserialização automática via @RabbitListener

---

## 🧑‍💻 Desenvolvidor por Danilo Takeo Kanizawa
Projeto desenvolvido como estudo prático sobre mensageria com Java.
Inclui desde o básico até tópicos intermediários envolvendo roteamento e JSON.
