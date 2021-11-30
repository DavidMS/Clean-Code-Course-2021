package org.cleancode.course.service;

import org.cleancode.course.exceptions.LoginException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String login(String name, String password) {
        if(!name.equals("juan")) {
            throw new LoginException("Invalid username");
        } else if (!password.equals("1234")) {
            throw new LoginException("Invalid password");
        }
        else return "successful login!";
    }

}
