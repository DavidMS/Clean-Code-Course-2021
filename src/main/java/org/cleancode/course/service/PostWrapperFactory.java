package org.cleancode.course.service;

import org.cleancode.course.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostWrapperFactory {

    public PostWrapper makePostWrapper(Post post) {
        switch (post.getStatus()) {
            case "FEATURED": return new FeaturedPostWrapper(post);
            case "PUBLISHED": return new PublishedPostWrapper(post);
            default: return new DraftPostWrapper(post);
        }
    }
}
