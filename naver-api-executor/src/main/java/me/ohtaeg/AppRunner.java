package me.ohtaeg;

import config.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    Properties properties;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println(properties.getClientId());
        System.out.println(properties.getClientSecret());
        System.out.println(properties.getUrl());
    }
}
