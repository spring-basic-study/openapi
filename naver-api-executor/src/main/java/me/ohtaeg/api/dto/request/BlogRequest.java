package me.ohtaeg.api.dto.request;

public class BlogRequest extends SearchWord {
    private static final String SORT_DEFAULT = "sim";
    private String sort = SORT_DEFAULT;

    public BlogRequest(final String query) {
        super(query);
    }

    public String getSort() {
        return sort;
    }

    public void setSort(final String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "BlogRequest{" +
                "sort='" + sort + '\'' +
                ", query='" + query + '\'' +
                ", display=" + display +
                ", start=" + start +
                '}';
    }
}
