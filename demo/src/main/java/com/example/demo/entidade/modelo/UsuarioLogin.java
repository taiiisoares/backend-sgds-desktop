package com.example.demo.entidade.modelo;

public class UsuarioLogin {
    private String cpf;
    private String cargo;

    private boolean login;

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean getLogin() {
        return this.login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

}
