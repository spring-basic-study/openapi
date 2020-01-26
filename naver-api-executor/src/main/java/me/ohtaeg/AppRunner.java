package me.ohtaeg;

import config.NaverApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    NaverApiProperties naverApiProperties;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println(naverApiProperties.getClientId());
    }
}
