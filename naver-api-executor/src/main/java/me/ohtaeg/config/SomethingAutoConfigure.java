package me.ohtaeg.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SomethingProperties.class)
@PropertySource("classpath:application.properties")
public class SomethingAutoConfigure {
    @Bean
    public SomeThing someThing(SomethingProperties somethingProperties) {
        return new SomeThing(somethingProperties.getName());
    }
}
