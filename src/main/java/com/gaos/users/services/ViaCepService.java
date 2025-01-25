package com.gaos.users.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ViaCepService {
    private final WebClient webClient;

    public ViaCepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws").build();
    }

    public boolean isValidCep(String cep) {
        try {
            String response = webClient
                    .get()
                    .uri("/{cep}/json/", cep.replace("-", ""))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            assert response != null;
            if (response.contains("erro")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
