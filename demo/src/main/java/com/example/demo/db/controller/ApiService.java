package com.example.demo.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entidade.modelo.Usuario;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public class ApiService {
    private static final String API_URL = "http://localhost:8080/usuario";

    @Autowired
    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Usuario> getUsuario() {
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(API_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public Usuario getUsuarioById(Long id){
        String apiURlString = API_URL + "/id" + ":" + id;
        ResponseEntity<Usuario> response = restTemplate.exchange(apiURlString,
        HttpMethod.GET, null, Usuario.class);
        return response.getBody();
    }

    public Usuario getUsuarioByCpf(String cpf){
        String apiURlString = API_URL + "/cpf" + ":" + cpf;
        ResponseEntity<Usuario> response = restTemplate.exchange(apiURlString,
        HttpMethod.GET, null, Usuario.class);
        return response.getBody();
    }

    public List<Usuario> getUsuarioByNome(String nome) {
        String apiURlString = API_URL + "/nome" + ":" + nome;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByEmail(String email) {
        String apiURlString = API_URL + "/email" + ":" + email;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByTelefone(String telefone) {
        String apiURlString = API_URL + "/telefone" + ":" + telefone;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByCargo(String cargo) {
        String apiURlString = API_URL + "/cargo" + ":" + cargo;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public Usuario alterarUsuario(String cpf){
        String apiURlString = API_URL + "/alterar" + ":" + cpf;
        ResponseEntity<Usuario> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<Usuario>() {
                });
        return response.getBody();
    }

    public Boolean enviarRequisicaoLogin(String cpf, String senha){
        String apiURlString = API_URL + "/login?" + "cpf=" + cpf + "&senha=" + senha;
        ResponseEntity<Boolean> retorno = restTemplate.exchange(apiURlString, HttpMethod.GET, null, Boolean.class);
        return retorno.getBody();
    }
}
