package org.cleancode.course.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Rating {
    @Id
    private Long id;
    private int rate;
    private String comment;
    private Long postId;
}
