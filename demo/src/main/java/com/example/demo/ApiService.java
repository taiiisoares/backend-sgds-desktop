package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ApiService {
    private static final String API_URL = "http://localhost:8080/usuario";

    @Autowired
    private RestTemplate restTemplate;

    public List<Usuario> getUser() {
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(API_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }
}
