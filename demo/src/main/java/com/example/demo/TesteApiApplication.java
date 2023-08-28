package com.example.demo;

import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.neo4j.ConfigBuilderCustomizer;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.db.controller.ApiService;
import com.example.demo.entidade.Usuario;

@SpringBootApplication
public class TesteApiApplication {

	public static void main(String[] args) {
	
		Thread springThread = new Thread(() -> {
			Usuario usuario = new Usuario();
			ConfigurableApplicationContext context = SpringApplication.run(TesteApiApplication.class, args);
			ApiService apiService = context.getBean(ApiService.class);
			List<Usuario> user = apiService.getUsuarioByTelefone("551124510987");
			usuario.printUsuarioList(user);
		});

        Thread swingThread = new Thread(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			}
				java.awt.EventQueue.invokeLater(() -> {
				Login login = new Login();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
			});
        });

		swingThread.start();
		
		springThread.start();
	}

}
