package org.cleancode.course.controller;

import lombok.AllArgsConstructor;
import org.cleancode.course.model.Post;
import org.cleancode.course.service.TheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TheController {

    private TheService theService;

    @GetMapping("/getPosts")
    public List<Post> getPosts() {
        return theService.getPosts();
    }

    @GetMapping("/getFeaturedPosts")
    public List<Post> getFeaturedPosts() {
        return theService.getFeaturedPosts();
    }

    @GetMapping("/ratings-aggregate/{i}")
    public List<String[]> getPRA(@PathVariable int i) {
        return theService.getPostRatingsAggregate(i);
    }

    @GetMapping("/countPostLetters/{letter}/{i}")
    public String countPostLetters(@PathVariable char letter, @PathVariable int i) {
        return theService.countPostLetters(letter, i);
    }
}
