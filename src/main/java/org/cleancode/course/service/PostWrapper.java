package org.cleancode.course.service;

import lombok.AllArgsConstructor;
import org.cleancode.course.model.Post;

@AllArgsConstructor
public abstract class PostWrapper {

    protected Post post;

    public abstract String print();
}
