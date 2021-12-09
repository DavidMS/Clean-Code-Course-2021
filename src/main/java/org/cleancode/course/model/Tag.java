package org.cleancode.course.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Tag {
    @Id
    private Long id;
    private String name;
    private Long postId;
}
