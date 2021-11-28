package org.cleancode.course.service;

import org.cleancode.course.model.Post;

public class FeaturedPostWrapper extends PostWrapper {

    public FeaturedPostWrapper(Post post) {
        super(post);
    }

    @Override
    public String print() {
        return "I am a featured post";
    }
}
