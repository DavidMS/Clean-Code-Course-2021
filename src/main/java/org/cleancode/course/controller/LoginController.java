package org.cleancode.course.controller;

import org.cleancode.course.model.ErrorCode;
import org.cleancode.course.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password) {
        var result = loginService.login(name, password);
        if(result.equals(ErrorCode.INVALID_NAME.name())) {
            return "the user name is not valid";
        } else if(result.equals(ErrorCode.INVALID_PASSWORD.name())) {
            return "the password is incorrect";
        }
        return result;
    }
}
