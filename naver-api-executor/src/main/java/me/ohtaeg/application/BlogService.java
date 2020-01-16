package me.ohtaeg.application;

import me.ohtaeg.api.dto.SearchWord;
import me.ohtaeg.domain.repository.SearchRepository;
import me.ohtaeg.domain.response.Blog;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements SearchService {

    private SearchRepository searchRepository;

    public BlogService(final SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public Blog search(final SearchWord searchWord) {
        Blog searchedBlog = (Blog) searchRepository.search(new Blog(searchWord), Blog.class);
        searchedBlog.limit(2);
        return searchedBlog;
    }
}
