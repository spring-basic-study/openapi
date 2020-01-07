package me.ohtaeg.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "something")
public class SomethingProperties {
    private final String name;

    public SomethingProperties(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
