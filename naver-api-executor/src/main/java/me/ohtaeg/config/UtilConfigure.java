package me.ohtaeg.config;

import me.ohtaeg.util.PropertyUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfigure {
    @Bean
    public PropertyUtils propertyUtils() {
        return PropertyUtils.getInstance();
    }
}
