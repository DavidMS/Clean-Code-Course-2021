package org.cleancode.course.controller;

import org.cleancode.course.model.Post;
import org.cleancode.course.service.TheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheController {

    private TheService theService = new TheService();

    @GetMapping("/getPosts")
    public List<Post> getPosts() {
        return theService.getPosts();
    }

    @GetMapping("/getFeaturedPosts")
    public List<Post> getFeaturedPosts() {
        return theService.getFeaturedPosts();
    }

    @GetMapping("/countPostLetters/{letter}/{i}")
    public String countPostLetters(@PathVariable char letter, @PathVariable int i) {
        return theService.countPostLetters(letter, i);
    }

    @GetMapping("/ratings-aggregate/{i}")
    public List<String[]> getPRA(@PathVariable String i) {
        return theService.getPRA(i);
    }
}
