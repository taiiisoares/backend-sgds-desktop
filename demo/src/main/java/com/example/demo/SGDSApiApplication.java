package com.example.demo;

import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.neo4j.ConfigBuilderCustomizer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.db.controller.ApiService;
import com.example.demo.entidade.ContextApp;
import com.example.demo.entidade.Login;
import com.example.demo.entidade.modelo.Usuario;
import com.example.demo.view.login.JFLogin;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class SGDSApiApplication {

	public static void main(String[] args) {

            Thread springThread = new Thread(() -> {
                Usuario usuario = new Usuario();
                ConfigurableApplicationContext context = SpringApplication.run(SGDSApiApplication.class, args);
                ApiService apiService = context.getBean(ApiService.class);
                boolean b = apiService.enviarRequisicaoLogin("51028851898", "1234");
                if(b){
                    System.out.println("Logado com sucesso");
                }else{
                    System.out.println("STATUS CODE: 401!");
                }
                ContextApp.setContext(context);
            });

            Thread swingThread = new Thread(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                    java.awt.EventQueue.invokeLater(() -> {
                    JFLogin login = new JFLogin();
                    login.setLocationRelativeTo(null);
                    login.setVisible(true);
                });
            });

		swingThread.start();
		
		springThread.start();
	}

}
