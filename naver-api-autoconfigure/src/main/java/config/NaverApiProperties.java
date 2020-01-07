package config;

import exception.InvalidUrlException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

// TODO : Immutable ConfigureProperties
@ConfigurationProperties(prefix = "naver.openapi")
public class NaverApiProperties {
    private String url;
    private String clientId;
    private String clientSecret;

//    @ConstructorBinding
//    public Properties(final String url, final String clientId, final String clientSecret) {
//        this.url = url;
//        this.clientId = clientId;
//        this.clientSecret = clientSecret;
//    }

    public void setUrl(final String url) {
        validUrl(url);
        this.url = url;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getUrl() {
        return url;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    private void validUrl(String url) {
        if (url == null) {
            throw new InvalidUrlException(url);
        }
    }
}
