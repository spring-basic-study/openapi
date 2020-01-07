package me.ohtaeg.api;

import me.ohtaeg.application.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping("/")
    public String defaultUrl() {
        return "hello world, please rewrite /api";
    }

//    @GetMapping("/api")
//    public String searchBlog() throws UnsupportedEncodingException {
//        return apiService.search();
//    }
}
