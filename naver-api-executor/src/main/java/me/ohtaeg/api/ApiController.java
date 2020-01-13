package me.ohtaeg.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/")
    public String defaultUrl() {
        return "hello world, please rewrite /blog + /{query}";
    }
}
