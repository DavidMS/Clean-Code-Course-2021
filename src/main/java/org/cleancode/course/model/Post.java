package org.cleancode.course.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private PostStatus status;
    private List<Image> images;
    private List<String> tags;
    private List<Rating> ratings;
    private String info;

    public Post(int id, String title, String content, String author, PostStatus status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.status = status;
    }

    public boolean isFeatured() {
        return status == PostStatus.FEATURED;
    }
}
