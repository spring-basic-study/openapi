package me.ohtaeg.application;

import me.ohtaeg.api.dto.request.SearchWord;
import me.ohtaeg.domain.repository.SearchRepository;
import me.ohtaeg.domain.response.Blog;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements SearchService {

    private SearchRepository searchRepository;
    private static final int LIMIT_LENGTH = 2;

    public BlogService(final SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public Blog search(final SearchWord searchWord) {
        Blog searchedBlog = (Blog) searchRepository.search(new Blog(searchWord), Blog.class);
        searchedBlog.limit(LIMIT_LENGTH);
        return searchedBlog;
    }
}
