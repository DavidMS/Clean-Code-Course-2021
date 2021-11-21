package org.cleancode.course.model;

import lombok.Data;

import java.util.List;

@Data
public class Rating {
    private int id;
    private int rate;
    private int comment;
    private int postId;
    private List<Image> images;
}
