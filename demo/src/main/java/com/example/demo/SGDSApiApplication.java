package com.example.demo;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.db.controller.ApiService;
import com.example.demo.view.ControleView;
import com.example.demo.view.login.JFLogin;
import com.example.demo.view.cadastro.Cadastro;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class SGDSApiApplication {

    public static void main(String[] args) {

        // Inicializa a interface gráfica Swing em uma nova thread
        Thread swingThread = new Thread(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException ex) {
                // Em caso de falha ao definir o look-and-feel, continue com o padrão
            }

            java.awt.EventQueue.invokeLater(() -> {
                // Inicia a aplicação Spring e obtém o contexto da aplicação
                ConfigurableApplicationContext context = SpringApplication.run(SGDSApiApplication.class, args);

                // Obtém o controle da view a partir do contexto do Spring
                ControleView controleView = context.getBean(ControleView.class);

                // Cria e exibe a tela de login
                JFLogin login = new JFLogin(controleView);
                login.setResizable(false);
                login.setLocationRelativeTo(null);
                login.setVisible(true);
            });
        });

        // Inicia a thread da interface gráfica
        swingThread.start();

    }

}
