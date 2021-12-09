package org.cleancode.course.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Post {
    @Id
    private Long id;
    private String title;
    private String content;
    private String author;
    private String status;
    @OneToMany(mappedBy = "postId", targetEntity = Image.class, fetch = FetchType.LAZY)
    private List<Image> images;
    @OneToMany(mappedBy = "postId", targetEntity = Tag.class, fetch = FetchType.LAZY)
    private List<Tag> tags;
    @OneToMany(mappedBy = "postId", targetEntity = Rating.class, fetch = FetchType.LAZY)
    private List<Rating> ratings;
    private String info;
}
