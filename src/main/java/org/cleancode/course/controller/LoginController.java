package org.cleancode.course.controller;

import lombok.extern.slf4j.Slf4j;
import org.cleancode.course.exceptions.LoginException;
import org.cleancode.course.model.ErrorCode;
import org.cleancode.course.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password) {
        var result = "";
        try {
            result = loginService.login(name, password);
        } catch (LoginException ex) {
            log.error(ex.getMessage(), ex);
        }
        return result;
    }
}
