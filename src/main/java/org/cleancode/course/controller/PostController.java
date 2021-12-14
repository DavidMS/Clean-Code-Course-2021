package org.cleancode.course.controller;

import lombok.AllArgsConstructor;
import org.cleancode.course.model.Post;
import org.cleancode.course.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping("/getPosts")
    public Iterable<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/getFeaturedPosts")
    public List<Post> getFeaturedPosts() {
        return postService.getFeaturedPosts();
    }

    @GetMapping("/ratings-aggregate/{i}")
    public List<String[]> getPRA(@PathVariable int i) {
        return postService.getPostRatingsAggregate(i);
    }

    @GetMapping("/countPostLetters/{letter}/{i}")
    public String countPostLetters(@PathVariable char letter, @PathVariable int i) {
        return postService.countPostLetters(letter, i);
    }
    
    @GetMapping("/getPostById/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postService.getPostById(postId);
    }
}
