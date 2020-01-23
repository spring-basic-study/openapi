package me.ohtaeg.application;

import me.ohtaeg.api.dto.request.SearchWord;
import me.ohtaeg.domain.repository.SearchRepository;
import me.ohtaeg.domain.response.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements SearchService {

    private SearchRepository searchRepository;

    public MovieService(final SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public Movie search(final SearchWord searchWord) {
        return (Movie) searchRepository.search(new Movie(searchWord), Movie.class);
    }
}
