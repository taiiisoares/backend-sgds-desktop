package com.example.demo.entidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.db.controller.ApiService;

@Component
public class Login {
    private String cpf;
    private String senha;
    private ConfigurableApplicationContext context;
    @Autowired
    private ApiService apiService;



    public Login(String cpf, String senha, ApiService apiService){
        this.cpf = cpf;
        this.senha = senha;
        this.apiService = apiService;
    }

    public Login(ApiService apiService){
        this.apiService = apiService;
    }

    public Login(){
        
    }

    public boolean login(String cpf, String senha){
        this.cpf = cpf;
        this.senha = senha;
        
        apiService = ContextApp.getContext().getBean(ApiService.class);
        return apiService.enviarRequisicaoLogin(cpf, senha);
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
