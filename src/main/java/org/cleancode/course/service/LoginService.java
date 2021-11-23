package org.cleancode.course.service;

import org.cleancode.course.model.ErrorCode;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String login(String name, String password) {
        if(!name.equals("juan")) {
            return ErrorCode.INVALID_NAME.name();
        } else if (!password.equals("1234")) {
            return ErrorCode.INVALID_PASSWORD.name();
        }
        else return "successful login!";
    }

}
