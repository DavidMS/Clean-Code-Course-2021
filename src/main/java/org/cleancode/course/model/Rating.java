package org.cleancode.course.model;

import lombok.Data;

@Data
public class Rating {
    private int id;
    private int rate;
    private int comment;
    private int postId;
}
