package me.ohtaeg.domain.search.formatter;

import me.ohtaeg.domain.search.SearchWord;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class SearchWordFormatter implements Formatter<SearchWord> {
    @Override
    public SearchWord parse(final String query, final Locale locale) {
        return new SearchWord(query);
    }

    @Override
    public String print(final SearchWord searchWord, final Locale locale) {
        return searchWord.toString();
    }
}
