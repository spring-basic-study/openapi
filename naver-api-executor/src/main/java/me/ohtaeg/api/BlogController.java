package me.ohtaeg.api;

import me.ohtaeg.domain.response.Blog;
import me.ohtaeg.domain.search.SearchWord;
import me.ohtaeg.domain.search.repository.SearchRepository;
import me.ohtaeg.infra.BlogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private SearchRepository repository;

    public BlogController(BlogRepository blogRepository) {
        this.repository = blogRepository;
    }

    @GetMapping("/{searchWord}")
    public Blog blog(@PathVariable SearchWord searchWord) throws UnsupportedEncodingException {
        return repository.search(searchWord);
    }
}
