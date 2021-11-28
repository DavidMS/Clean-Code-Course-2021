package org.cleancode.course.service;

import org.cleancode.course.model.Post;

public class PublishedPostWrapper extends PostWrapper {

    public PublishedPostWrapper(Post post) {
        super(post);
    }

    @Override
    public String print() {
        return "I am a published post";
    }
}
