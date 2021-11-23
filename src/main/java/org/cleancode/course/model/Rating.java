package org.cleancode.course.model;

import lombok.Data;

import java.util.List;

@Data
public class Rating {
    private int id;
    private int rate;
    private String comment;
    private int postId;
    private List<Image> images;

    public Rating(int id, int rate, String comment, int postId) {
        this.id = id;
        this.rate = rate;
        this.comment = comment;
        this.postId = postId;
    }
}
