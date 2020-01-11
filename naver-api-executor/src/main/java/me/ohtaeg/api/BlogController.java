package me.ohtaeg.api;

import me.ohtaeg.api.annotation.BlogArgumentResolver;
import me.ohtaeg.api.dto.SearchWord;
import me.ohtaeg.domain.response.Blog;
import me.ohtaeg.domain.search.repository.SearchRepository;
import me.ohtaeg.infra.BlogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api")
public class BlogController {
    private final SearchRepository repository;

    public BlogController(BlogRepository blogRepository) {
        this.repository = blogRepository;
    }

    @GetMapping("/blog")
    public ResponseEntity<Blog> blog(@BlogArgumentResolver SearchWord searchWord) throws UnsupportedEncodingException {
        return repository.search(searchWord);
    }
}
