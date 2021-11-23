package org.cleancode.course.controller;

import lombok.AllArgsConstructor;
import org.cleancode.course.service.TheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class TheController {

    private TheService theService;

    @GetMapping("/getThemAll")
    public List<String[]> getThemAll() {
        return theService.getPosts();
    }

    @GetMapping("/getThem")
    public List<String[]> getThem() {
        return theService.getFeaturedPosts();
    }

    @GetMapping("/duplicateOneAndReturnThemAll/{i}")
    public List<String[]> duplicateOneAndReturnThemAll(@PathVariable int i) {
        return theService.copyPostAddItAndReturnIt(i);
    }

    @GetMapping("/countPostLetters/{letter}/{i}")
    public String countPostLetters(@PathVariable char letter, @PathVariable int i) {
        return theService.countPostLetters(letter, i);
    }

    @GetMapping("/ratings-aggregate/{i}")
    public List<String[]> getPRA(@PathVariable String i) {
        return theService.getPostRatingsAggregate(i);
    }
}
