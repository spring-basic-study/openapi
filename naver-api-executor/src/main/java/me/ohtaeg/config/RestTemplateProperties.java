package me.ohtaeg.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "resttemplate")
public class RestTemplateProperties {
    private int readTimeout;
    private int connectionTimeout;
    private int maxConnectionTotal;
    private int maxConnectionRoute;

    public RestTemplateProperties(final int readTimeout, final int connectionTimeout, final int maxConnectionTotal, final int maxConnectionRoute) {
        this.readTimeout = readTimeout;
        this.connectionTimeout = connectionTimeout;
        this.maxConnectionTotal = maxConnectionTotal;
        this.maxConnectionRoute = maxConnectionRoute;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public int getMaxConnectionTotal() {
        return maxConnectionTotal;
    }

    public int getMaxConnectionRoute() {
        return maxConnectionRoute;
    }
}
