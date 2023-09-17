package com.panastech.backendsgds.view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.stereotype.Component;

import com.panastech.backendsgds.controller.Controlador;
import com.panastech.backendsgds.entidade.modelo.Especialidade;
import com.panastech.backendsgds.entidade.modelo.UsuarioLogin;
import com.panastech.backendsgds.view.login.Login;

@Component
public class ControleView {
    private final Controlador servico;
    ControleView controleView;
    UsuarioLogin usuarioLogin = new UsuarioLogin();

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

    public List<String> requisitarEspecialidades() {
        List<String> lista;
        lista = servico.requisitarEspecialidades();
        return lista;
    }

    public void setCpfLogin(String cpf) {
        usuarioLogin.setCpf(cpf);
    }

    public UsuarioLogin getCpfLogin() {
        return this.usuarioLogin;
    }

    public UsuarioLogin getNomeLogin(String cpf) {
        UsuarioLogin usuario = new UsuarioLogin();
        usuario = servico.getNomeLogin(cpf);
        return usuario;
    }

    // public boolean solicitarExame(String especialidade, String nome, String
    // detalhes){

    // }
}
