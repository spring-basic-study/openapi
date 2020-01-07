package config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Properties.class)
public class AutoConfigure {
    @Bean
    @ConditionalOnMissingBean
    public Properties properties(Properties properties) {
        return properties;
    }
}
