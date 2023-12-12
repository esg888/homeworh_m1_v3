package org.example;


import org.example.config.DefaultRegAppConfig;
import org.example.config.ProdRegAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    	
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DefaultRegAppConfig.class);
        ChoiceClass choiceClass = ctx.getBean(ChoiceClass.class);
choiceClass.choceAction();

    }
}