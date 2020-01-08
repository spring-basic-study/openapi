package me.ohtaeg.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public abstract class OpenApi {
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
//    LocalDateTime lastBuildDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
//    LocalDateTime postdate;
    Integer total;
    Integer display;
    List<Item> items;

    private static class Item {
        String title;
        String link;
        String description;
        String bloggerName;
        String bloggerLink;

        public String getTitle() {
            return title;
        }

        public void setTitle(final String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(final String link) {
            this.link = link;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(final String description) {
            this.description = description;
        }

        public String getBloggerName() {
            return bloggerName;
        }

        public void setBloggerName(final String bloggerName) {
            this.bloggerName = bloggerName;
        }

        public String getBloggerLink() {
            return bloggerLink;
        }

        public void setBloggerLink(final String bloggerLink) {
            this.bloggerLink = bloggerLink;
        }
    }

//    public LocalDateTime getLastBuildDate() {
//        return lastBuildDate;
//    }
//
//    public void setLastBuildDate(final LocalDateTime lastBuildDate) {
//        this.lastBuildDate = lastBuildDate;
//    }
//
//    public LocalDateTime getPostdate() {
//        return postdate;
//    }
//
//    public void setPostdate(final LocalDateTime postdate) {
//        this.postdate = postdate;
//    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(final Integer total) {
        this.total = total;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(final Integer display) {
        this.display = display;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }
}
