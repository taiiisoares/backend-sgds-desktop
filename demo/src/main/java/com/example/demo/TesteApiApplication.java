package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.neo4j.ConfigBuilderCustomizer;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.ApiService;

@SpringBootApplication
public class TesteApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TesteApiApplication.class, args);
		ApiService apiService = context.getBean(ApiService.class);
		List<Usuario> teste = apiService.getUsuarioByCargo("Profissional da saúde");

		for (Usuario user : teste) {
			System.out.println("User ID: " + user.getId());
			System.out.println("User Name: " + user.getNome());
			System.out.println("User Cpf: " + user.getCpf());
			System.out.println("User E-mail: " + user.getEmail());
			System.out.println("User Senha: " + user.getSenha());
			System.out.println("User Telefone: " + user.getTelefone());
			System.out.println("User Cargo: " + user.getCargo());
			System.out.println("\t");

		}

	}

}
