package config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableConfigurationProperties(NaverApiProperties.class)
@PropertySource("classpath:api.properties")
public class NaverApiPropertyAutoConfigure {

    @Bean
    @ConditionalOnMissingBean
    public NaverApiProperties naverApiProperties(NaverApiProperties naverApiProperties) {
        return naverApiProperties;
    }
}
