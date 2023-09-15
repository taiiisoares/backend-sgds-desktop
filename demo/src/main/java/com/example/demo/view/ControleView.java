package com.example.demo.view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.stereotype.Component;

import com.example.demo.db.controller.Controlador;
import com.example.demo.view.login.Login;

@Component
public class ControleView {
    private final Controlador servico;
    ControleView controleView;

    // Construtor que injeta uma instância de Login
    public ControleView(Controlador servico) {
        this.servico = servico;
    }

    // Método que solicita um login usando o serviço de Login
    public boolean requisitarLogin(String cpf, String senha) {
        // Chama o método de login no serviço e retorna o resultado
        return servico.login(cpf, senha);
    }

    public boolean requisitarCadastro(String nome, String cpf, String email, String senha, String cargo) {
        return servico.cadastro(nome, cpf, email, senha, cargo);
    }
}
