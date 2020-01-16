package me.ohtaeg.util;

import config.NaverApiProperties;
import org.springframework.stereotype.Component;

@Component
public class PropertyUtils {
    private static NaverApiProperties naverApiProperties;

    public PropertyUtils(NaverApiProperties naverApiProperties) {
        this.naverApiProperties = naverApiProperties;
    }

    public static String getUrl() {
        return naverApiProperties.getUrl();
    }

    public static String getClientId() {
        return naverApiProperties.getClientId();
    }

    public static String getSecret() {
        return naverApiProperties.getClientSecret();
    }
}
