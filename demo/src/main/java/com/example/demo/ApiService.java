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

    public List<Usuario> getUsuarios() {
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(API_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public Usuario getUsuarioById(Long idUsuario) {
        String url = API_URL + "/" + "buscaruserid" + "/" + idUsuario;
        ResponseEntity<Usuario> response = restTemplate.exchange(url, HttpMethod.GET, null, Usuario.class);
        return response.getBody();
    }

    public Usuario getUsuarioByCpf(String cpf) {
        String url = API_URL + "/" + "buscarusercpf" + "/" + cpf;
        ResponseEntity<Usuario> response = restTemplate.exchange(url, HttpMethod.GET, null, Usuario.class);
        return response.getBody();
    }

    public List<Usuario> getUsuarioByNome(String nome) {
        String url = API_URL + "/" + "buscarusernome" + "/" + nome;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByEmail(String email) {
        String url = API_URL + "/" + "buscaruseremail" + "/" + email;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByTelefone(String telefone) {
        String url = API_URL + "/" + "buscarusertelefone" + "/" + telefone;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }

    public List<Usuario> getUsuarioByCargo(String cargo) {
        String url = API_URL + "/" + "buscarusercargo" + "/" + cargo;
        ResponseEntity<List<Usuario>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                });
        return response.getBody();
    }
}
