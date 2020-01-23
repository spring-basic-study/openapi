package me.ohtaeg.api.dto.request;

public class MovieRequest extends SearchWord {
    private String genre;
    private String country;
    private int yearfrom;
    private int yearto;

    public MovieRequest(final String query) {
        super(query);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(final String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public int getYearfrom() {
        return yearfrom;
    }

    public void setYearfrom(final int yearfrom) {
        this.yearfrom = yearfrom;
    }

    public int getYearto() {
        return yearto;
    }

    public void setYearto(final int yearto) {
        this.yearto = yearto;
    }
}
