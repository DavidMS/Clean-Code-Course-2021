package org.cleancode.course.controller;

import org.cleancode.course.service.TheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheController {

    private TheService theService = new TheService();

    @GetMapping("/getThemAll")
    public List<String[]> getThemAll() {
        return theService.getThemAll();
    }

    @GetMapping("/getThem")
    public List<String[]> getThem() {
        return theService.getThem();
    }

    @GetMapping("duplicateOneAndReturnThemAll/{i}")
    public List<String[]> duplicateOneAndReturnThemAll(@PathVariable int i) {
        return theService.duplicateOneAndReturnThemAll(i);
    }
}
