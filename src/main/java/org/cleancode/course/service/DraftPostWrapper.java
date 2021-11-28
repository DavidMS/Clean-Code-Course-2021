package org.cleancode.course.service;

import org.cleancode.course.model.Post;

public class DraftPostWrapper extends PostWrapper {

    public DraftPostWrapper(Post post) {
        super(post);
    }

    @Override
    public String print() {
        return "I am a draft post";
    }
}
