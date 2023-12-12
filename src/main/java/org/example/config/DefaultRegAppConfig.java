package org.example.config;


import org.example.WriteClassForProd;
import org.example.WriteClassForTest;
import org.example.WriteInterface;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@ComponentScan("org.example")
@Configuration
@PropertySource("classpath:application.properties")
public class DefaultRegAppConfig {

    @Bean
    public WriteInterface writeInterface()
    {
        return new WriteClassForTest();
    }
}
