package com.example.demo.entidade;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.db.controller.ApiService;

public class ContextApp {
    static List<ConfigurableApplicationContext> context;

    public static void setContext(ConfigurableApplicationContext apiService){
        context.add(apiService);
    }

    public static ConfigurableApplicationContext getContext(){
        return context.get(0);
    }
}
