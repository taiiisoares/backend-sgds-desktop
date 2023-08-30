package com.example.demo.entidade;

import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String cargo;

    public String getUsuario(){
        return "ID: " + id +
            "\nNome: " + nome +
            "\nCPF: " + cpf +
            "\nEmail: " + email +
            "\nTelefone: " + telefone +
            "\nCargo: " + cargo;
    }

    public void printUsuarioList(List<Usuario> usuarioList) {
    for (Usuario usuario : usuarioList) {
        System.out.println("ID: " + usuario.getId());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Telefone: " + usuario.getTelefone());
        System.out.println("Cargo: " + usuario.getCargo());
        System.out.println("-----------------------------"); 
    }
}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
