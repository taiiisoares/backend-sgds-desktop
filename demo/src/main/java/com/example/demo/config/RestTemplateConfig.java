package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /*
     * Configuração de um Bean do RestTemplate
     * Essa configuração permite que você injete o RestTemplate em outras partes do
     * seu aplicativo, como serviços ou controladores, para realizar requisições
     * HTTP de forma fácil e eficiente.
     * Bean é um componente gerenciado pelo Spring que pode ser injetado em outras
     * partes do seu aplicativo.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(); // Cria e retorna uma instância de RestTemplate
    }

    // Outras configurações podem ser adicionadas aqui...
}
