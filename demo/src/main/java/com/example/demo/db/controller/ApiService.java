package com.example.demo.db.controller;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entidade.modelo.Usuario;
import com.example.demo.entidade.modelo.UsuarioLogin;

import java.util.List;

/**
 * Classe responsável por realizar requisições para a API externa.
 * 
 * Esta classe possui métodos para interagir com a API, como por exemplo,
 * obter dados de usuários, enviar informações, entre outros.
 * 
 * A anotação @Service indica que esta classe é um componente gerenciado pelo
 * Spring.
 */
@Service
public class ApiService {
    private static final String API_URL = "http://localhost:8080/usuario";

    private final RestTemplate restTemplate;

    /**
     * Construtor da classe ApiService.
     * 
     * @param restTemplate Um objeto RestTemplate que permite fazer requisições
     *                     HTTP.
     *                     Essa instância será injetada pelo Spring para
     *                     possibilitar
     *                     a comunicação com a API externa.
     */
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Campo de Getters e Setters
     */
    public List<Usuario> getUsuario() {
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(API_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public Usuario getUsuarioById(Long id) {
        String apiURlString = API_URL + "/id" + ":" + id;
        ResponseEntity<Usuario> response = restTemplate.exchange(apiURlString,
                HttpMethod.GET, null, Usuario.class);
        return response.getBody();
    }

    public Usuario getUsuarioByCpf(String cpf) {
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

    public Usuario alterarUsuario(String cpf) {
        String apiURlString = API_URL + "/alterar" + ":" + cpf;
        ResponseEntity<Usuario> response = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<Usuario>() {
                });
        return response.getBody();
    }

    public UsuarioLogin enviarRequisicaoLogin(String cpf, String senha) {
        String apiURlString = API_URL + "/login?" + "cpf=" + cpf + "&senha=" + senha;
        ResponseEntity<UsuarioLogin> retorno = restTemplate.exchange(apiURlString, HttpMethod.GET, null,
                new ParameterizedTypeReference<UsuarioLogin>() {
                });
        return retorno.getBody();
    }

    public Boolean cadastro(Usuario usuario) {
        String apiURlString = API_URL + "/adicionar";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        HttpEntity<Usuario> requestEntity = new HttpEntity<>(usuario, headers);
        ResponseEntity<String> retorno = restTemplate.exchange(apiURlString, HttpMethod.POST, requestEntity,
                String.class);
        if (retorno.getStatusCode() == HttpStatus.OK) {
            return true;
        }
        return false;
    }
}
