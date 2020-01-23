package me.ohtaeg.api;

import me.ohtaeg.api.dto.request.BlogRequest;
import me.ohtaeg.api.dto.request.MovieRequest;
import me.ohtaeg.api.dto.request.SearchWord;
import me.ohtaeg.api.dto.response.ApiResult;
import me.ohtaeg.application.BlogService;
import me.ohtaeg.application.MovieService;
import me.ohtaeg.domain.response.Blog;
import me.ohtaeg.domain.response.Movie;
import me.ohtaeg.domain.response.SearchApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private BlogService blogService;
    private MovieService movieService;

    public ApiController(final BlogService blogService, final MovieService movieService) {
        this.blogService = blogService;
        this.movieService = movieService;
    }

    @GetMapping("/blog")
    public ApiResult<Blog> blog(@Valid BlogRequest blogRequest) {
        Blog blog = blogService.search(blogRequest);
        return ApiResult.OK(blog);
    }

    @GetMapping("/movie")
    public ApiResult<Movie> movie(@Valid MovieRequest movieRequest) {
        Movie movie = movieService.search(movieRequest);
        return ApiResult.OK(movie);
    }

    @GetMapping("/with")
    public ApiResult<List<SearchApi>> with(@Valid SearchWord searchWord) {
        // TODO : refactoring
        List<SearchApi> searchApis = new ArrayList<>();
        String query = searchWord.getQuery();
        int start = searchWord.getStart();
        int display = searchWord.getDisplay();

        BlogRequest blogRequest = new BlogRequest(query);
        blogRequest.setStart(start);
        blogRequest.setDisplay(display);

        MovieRequest movieRequest = new MovieRequest(query);
        movieRequest.setStart(start);
        movieRequest.setDisplay(display);

        Blog blog = blogService.search(blogRequest);
        Movie movie = movieService.search(movieRequest);

        searchApis.add(blog);
        searchApis.add(movie);

        return ApiResult.OK(searchApis);
    }
}
