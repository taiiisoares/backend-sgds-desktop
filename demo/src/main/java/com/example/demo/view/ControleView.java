package com.example.demo.view;

import org.springframework.stereotype.Component;

import com.example.demo.entidade.Login;

@Component
public class ControleView {
    private Login login;

    public ControleView(Login login){
        this.login = login;
    }

    public ControleView(){

    }
    public boolean requisitarLogin(String cpf, String senha){
        Login servico = new Login();
        boolean retornoLogin = servico.login(cpf, senha);
        return retornoLogin;
    }
}
