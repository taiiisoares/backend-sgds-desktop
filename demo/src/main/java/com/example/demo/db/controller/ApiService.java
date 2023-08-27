package com.example.demo.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entidade.Usuario;

import java.util.List;

@Service
public class ApiService {
    private static final String API_URL = "http://localhost:8080/usuario";

    @Autowired
    private RestTemplate restTemplate;

    public List<Usuario> getUsuario() {
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(API_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public Usuario getUsuarioById(Long id){
        String apiURlString = API_URL + "/buscaruserid" + "/" + id;
        ResponseEntity<Usuario> response = restTemplate.exchange(apiURlString,
        HttpMethod.GET, null, Usuario.class);
        return response.getBody();
    }

    public Usuario getUsuarioByCpf(String cpf){
        String apiURlString = API_URL + "/buscarusercpf" + "/" + cpf;
        ResponseEntity<Usuario> response = restTemplate.exchange(apiURlString,
        HttpMethod.GET, null, Usuario.class);
        return response.getBody();
    }

    public List<Usuario> getUsuarioByNome(String nome) {
        String apiURlString = API_URL + "/buscarusernome" + "/" + nome;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByEmail(String email) {
        String apiURlString = API_URL + "/buscaruseremail" + "/" + email;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByTelefone(String telefone) {
        String apiURlString = API_URL + "/buscarusertelefone" + "/" + telefone;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByCargo(String cargo) {
        String apiURlString = API_URL + "/buscarusecargo" + "/" + cargo;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public Usuario alterarUsuario(String cpf){
        String apiURlString = API_URL + "/alterarusuario" + "/" + cpf;
        ResponseEntity<Usuario> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<Usuario>() {
                });
        return response.getBody();
    }
}
