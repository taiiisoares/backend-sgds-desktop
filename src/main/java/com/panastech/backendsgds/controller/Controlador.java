package com.panastech.backendsgds.controller;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.panastech.backendsgds.db.controller.Api.UsuarioRest;
import com.panastech.backendsgds.entidade.modelo.Usuario;
import com.panastech.backendsgds.entidade.modelo.UsuarioLogin;

@Component
public class Controlador {

    @Autowired
    private final UsuarioRest apiService; // Serviço para realizar requisições à API

    // Construtor
    public Controlador(UsuarioRest apiService) {
        this.apiService = apiService; // Injeta o serviço ApiService ao criar uma instância de Login
    }

    // Método para realizar o login
    public boolean login(String cpf, String senha) {
        try {
            UsuarioLogin usuarioLogin = apiService.enviarRequisicaoLogin(cpf, senha);
            String cargo = usuarioLogin.getCargo();
            if (!cargo.equals("Paciente")) {
                if (cargo.equals("Recepcionista")) {
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso Recepcionista!",
                            "Login realizado",
                            JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso Profissional da Saúde!",
                            "Login realizado",
                            JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não autorizado", "Erro ao efetuar login", 0);
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "CPF e/ou senha incorretos!", "Erro ao efetuar login", 0);
            return false;
        }
    }

    public boolean cadastro(String nome, String cpf, String email, String senha, String cargo) {
        Usuario usuario = new Usuario();
        usuario.setName(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setCargo(cargo);

        Usuario usuario2 = usuario;
        if (apiService.cadastro(usuario2)) {
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Sucesso!",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Tente novamente!", "Erro ao efetuar cadastro", 0);
        }
        return false;
    }
}
