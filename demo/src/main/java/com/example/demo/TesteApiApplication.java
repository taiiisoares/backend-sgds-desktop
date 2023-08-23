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
		List<Usuario> userList = apiService.getUser();
		for (Usuario user : userList) {
			System.out.println(user);
		}
	}

}
