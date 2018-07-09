package org.trahim.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.trahim.spring.examplebean.FakeDataSource;
import org.trahim.spring.examplebean.SpringBootProperties;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:other.properties"})
/// or
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:other.properties")
}
)
public class PropertiConfig {

    @Value("${trahim.username}")
    private String username;
    @Value("${trahim.password}")
    private String password;
    @Value("${trahim.url}")
    private String url;

    //spring boot default properties
    @Value("${boot.username}")
    private String usernameBoot;
    @Value("${boot.password}")
    private String passwordBoot;
    @Value("${boot.url}")
    private String urlBoot;


    @Bean
    public SpringBootProperties getBootProperties() {
        SpringBootProperties bootProperties = new SpringBootProperties();
        bootProperties.setPassword(passwordBoot);
        bootProperties.setUrl(urlBoot);
        bootProperties.setUsername(usernameBoot);
        return bootProperties;
    }

    @Bean
    public FakeDataSource getDatasource() {
        FakeDataSource dataSource = new FakeDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer proprties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;

    }

}
