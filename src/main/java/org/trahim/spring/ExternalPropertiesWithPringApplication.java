package org.trahim.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.trahim.spring.examplebean.FakeDataSource;
import org.trahim.spring.examplebean.SpringBootProperties;

@SpringBootApplication
public class ExternalPropertiesWithPringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ExternalPropertiesWithPringApplication.class, args);
        FakeDataSource dataSource = (FakeDataSource) context.getBean(FakeDataSource.class);

        System.out.println(dataSource.getUrl());


        SpringBootProperties bootProperties =(SpringBootProperties) context.getBean(SpringBootProperties.class);
        System.out.println(bootProperties.getUsername());
    }
}
