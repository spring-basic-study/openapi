package me.ohtaeg.util;

import config.NaverApiProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertyUtils {
    private NaverApiProperties naverApiProperties;

    @Autowired
    public void setNaverApiProperties(final NaverApiProperties naverApiProperties) {
        this.naverApiProperties = naverApiProperties;
    }

    public static PropertyUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getUrl() {
        return naverApiProperties.getUrl();
    }

    public String getClientId() {
        return naverApiProperties.getClientId();
    }

    public String getSecret() {
        return naverApiProperties.getClientSecret();
    }

    private static class LazyHolder {
        private static final PropertyUtils INSTANCE = new PropertyUtils();
    }
}
