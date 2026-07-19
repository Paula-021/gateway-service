# Gateway de Comunicação GPS

## Sobre o projeto

🚀 **Projeto desenvolvido como freelancer**, com o objetivo de integrar um sistema de rastreamento GPS a um servidor que utiliza um protocolo proprietário de comunicação via UDP.

O gateway foi desenvolvido com **Java** e **Spring Boot** e é responsável por receber dados de localização por meio de uma API REST, processá-los e convertê-los para o formato exigido pelo protocolo proprietário antes de enviá-los ao servidor via **UDP**.

Durante o desenvolvimento, trabalhei com integração entre sistemas, manipulação de datas e horários, conversão de coordenadas geográficas, transformação de valores para hexadecimal, cálculo de checksum e montagem de pacotes de dados conforme a especificação técnica do protocolo.

## Principais funcionalidades

- Recebimento de dados GPS através de API REST
- Conversão das informações para protocolo proprietário
- Envio das mensagens utilizando UDP
- Conversão de coordenadas geográficas
- Manipulação e formatação de datas e horários
- Conversão de dados para hexadecimal
- Cálculo de checksum
- Montagem de pacotes seguindo a especificação do protocolo

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- API REST
- UDP (DatagramSocket)
- Maven

## Conhecimentos aplicados

Durante o desenvolvimento deste projeto foram aplicados conhecimentos em:

- Desenvolvimento de APIs REST com Spring Boot
- Comunicação de rede utilizando UDP
- Programação de sockets em Java
- Integração entre sistemas
- Manipulação de datas e horários
- Conversão de coordenadas geográficas
- Conversão de dados para hexadecimal
- Implementação de algoritmos de checksum
- Processamento e transformação de dados
- Implementação de protocolos proprietários

## Principal desafio

O principal desafio do projeto foi implementar fielmente a especificação do protocolo proprietário. Cada mensagem precisava seguir exatamente o formato definido na documentação técnica, incluindo o posicionamento dos campos, formatação das coordenadas, conversão dos valores, cálculo do checksum e estrutura do pacote enviado via UDP. Qualquer inconsistência fazia com que a mensagem fosse rejeitada pelo servidor, exigindo uma validação cuidadosa e diversos testes durante o desenvolvimento.

## Objetivo

Este projeto permitiu aplicar conhecimentos de desenvolvimento back-end, integração entre sistemas e comunicação em rede em um cenário real, simulando situações comuns em aplicações de rastreamento, telemetria e Internet das Coisas (IoT). A experiência também reforçou habilidades de interpretação de documentação técnica, resolução de problemas e implementação de soluções seguindo especificações de protocolos de comunicação.
